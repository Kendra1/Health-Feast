package sbnz.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import sbnz.enumeration.Goal;
import sbnz.enumeration.UserStatus;
import sbnz.model.Ingredient;
import sbnz.model.IngredientQuantity;
import sbnz.model.MealHistory;
import sbnz.model.Recipe;
import sbnz.model.User;
import sbnz.repository.IngredientQuantityRepository;
import sbnz.repository.IngredientRepository;
import sbnz.repository.MealHistoryRepository;
import sbnz.repository.UserRepository;
import sbnz.web.dto.DailyMealDto;
import sbnz.web.dto.UpdateUserDto;
import sbnz.web.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	private final KieContainer kieContainer;
	private final UserRepository userRepository;
	private final ObjectMapper objectMapper;
	private final IngredientQuantityRepository ingredientQuantityRepository;
	private final IngredientRepository ingredientRepository;
	private final MealHistoryRepository mealHistoryRepository;

	@Autowired
	public UserServiceImpl(KieContainer kieContainer, UserRepository userRepository, 
			ObjectMapper objectMapper, IngredientRepository ingredientRepository,
			MealHistoryRepository mealHistoryRepository, IngredientQuantityRepository ingredientQuantityRepository) {
		this.kieContainer = kieContainer;
		this.userRepository = userRepository;
		this.objectMapper = objectMapper;
		this.ingredientRepository = ingredientRepository;
		this.mealHistoryRepository = mealHistoryRepository;
		this.ingredientQuantityRepository = ingredientQuantityRepository;
	}

	@Override
	public UserStatus getUserStatus(Authentication authentication) {		
		User user = getUserFromAuthentication(authentication);

		createKieSessionAndFireRules(user, "status");

		userRepository.save(user);

		return user.getUserStatus();
	}
	
	@Override
	public String getRecommendedIntake(Authentication authentication) {		
		User user = getUserFromAuthentication(authentication);
		
		createKieSessionAndFireRules(user, "activity");
		
		return String.format("Recommended daily intake of calories to mantain your current weight is: %s", user.getRecommendedDailyCalories());
	}
	
	@Override
	public String getRecommendedCalories(String goal, Authentication authentication) {
		
		User user = getUserFromAuthentication(authentication);
		user.setGoal(Goal.valueOf(goal));
				
		createKieSessionAndFireRules(user, "activity");
		
		userRepository.save(user);

		return String.format("Recommended daily intake of calories for your goal is: %s", user.getRecommendedDailyCalories());
	}
	
	private void createKieSessionAndFireRules(User user, String agendaGroup) {
		KieSession kieSession = kieContainer.newKieSession();
		
		kieSession.insert(user);
		kieSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();
		kieSession.fireAllRules();		
		kieSession.dispose();
		kieSession.destroy();
	}
	
	@Override
	public String getDailyCaloriesStatus(Authentication authentication) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		user.setRecommendedDailyCalories(2000.0);
		
		Ingredient ing1 = new Ingredient();
		ing1.setCalories(100);
		
		Ingredient ing2 = new Ingredient();
		ing2.setCalories(200);
		
		Recipe recipe = new Recipe();
		List<IngredientQuantity> ingredients = new ArrayList<>();
		ingredients.add(new IngredientQuantity(ing1, 5));
		recipe.setIngredients(ingredients);
		
		IngredientQuantity meal1 = new IngredientQuantity();
		meal1.setIngredient(ing1);
		meal1.setQuantity(2);
		
		IngredientQuantity meal2 = new IngredientQuantity();
		meal2.setIngredient(ing2);
		meal2.setQuantity(3);
		
		List<IngredientQuantity> meals = new ArrayList<IngredientQuantity>();
		meals.add(meal1);
		meals.add(meal2);
		meals.addAll(recipe.getIngredients());
		
		MealHistory mealHistoryObj = new MealHistory();
		mealHistoryObj.setMeals(meals);
	
//		user.setMealHistory(mealHistoryObj);
	
		kieSession.insert(user);
		kieSession.insert(mealHistoryObj);
		kieSession.getAgenda().getAgendaGroup("dailyCalories").setFocus();
		kieSession.fireAllRules();		
		kieSession.dispose();
		
		userRepository.save(user);
		
		return String.format("Daily intake of calories is: ", user.getCaloriesConsumed().toString());
	}

	@Override
	public UserDto getLoggedUser(Authentication authentication) {		
		return objectMapper.convertValue(getUserFromAuthentication(authentication), UserDto.class);
	}
	
	@Transactional
    public User getUserFromAuthentication(Authentication authentication) {
        try {
            return (userRepository.findByEmail(((User) authentication.getPrincipal()).getEmail()))
                    .orElseThrow(EntityNotFoundException::new);
        } catch (ClassCastException | NullPointerException | EntityNotFoundException ex) {
            throw new AccessDeniedException("User is not logged in. Access is denied.");
        }
    }
	
	@Override
	public UpdateUserDto updateUser(UpdateUserDto updatedUser, Authentication authentication) {
		User user = getUserFromAuthentication(authentication);
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        mapperFacade.map(updatedUser, user);
        
        userRepository.save(user);
        
        return objectMapper.convertValue(user, UpdateUserDto.class);
	}

	@Override
	public DailyMealDto saveDailyMeal(DailyMealDto dailyMealDto, Authentication authentication) {
		User user = getUserFromAuthentication(authentication);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dailyMealDto.getDate(), formatter);
				
		List <IngredientQuantity> dailyMeals = dailyMealDto.getIngredientsDto().stream().map(ingredientDto -> {
			Ingredient ingredient = ingredientRepository.findById(ingredientDto.getId()).orElseThrow(EntityNotFoundException::new);
			IngredientQuantity ingredientQuantity = new IngredientQuantity(ingredient, ingredientDto.getQuantity());
			
			ingredientQuantityRepository.save(ingredientQuantity);
			
			return ingredientQuantity;
		}).collect(Collectors.toList());
		
		MealHistory dailyMealHistory = new MealHistory();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(user);
		kieSession.insert(date);
		kieSession.insert(dailyMealHistory);
		kieSession.getAgenda().getAgendaGroup("dailyCalories").setFocus();
		kieSession.fireAllRules();		
		kieSession.dispose();
		kieSession.destroy();
		
		mealHistoryRepository.save(dailyMealHistory);
		
		KieSession kieSession2 = kieContainer.newKieSession();
		kieSession2.getAgenda().getAgendaGroup("dailyCalories").setFocus();
		kieSession2.insert(dailyMeals);
		kieSession2.insert(dailyMealHistory);
		kieSession2.fireAllRules();		
		kieSession2.dispose();
		kieSession2.destroy();
		
		mealHistoryRepository.save(dailyMealHistory);
        userRepository.save(user);
		
		return dailyMealDto;
	}
}
