package sbnz.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import sbnz.enumeration.Goal;
import sbnz.enumeration.UserStatus;
import sbnz.model.Ingredient;
import sbnz.model.IngredientQuantity;
import sbnz.model.MealHistory;
import sbnz.model.Recipe;
import sbnz.model.User;
import sbnz.repository.UserRepository;
import sbnz.web.dto.UpdateUserDto;
import sbnz.web.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	private final KieContainer kieContainer;
	private final UserRepository userRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public UserServiceImpl(KieContainer kieContainer, UserRepository userRepository, ObjectMapper objectMapper) {
		this.kieContainer = kieContainer;
		this.userRepository = userRepository;
		this.objectMapper = objectMapper;
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
	public UpdateUserDto updateUser(UpdateUserDto updatedUser, MultipartFile image, Authentication authentication) {
		User user = getUserFromAuthentication(authentication);
		
        ObjectReader objectReader = objectMapper.readerForUpdating(user);
        User updatedExistingUser = null;
        
		try {
	        String updatedUserString = objectMapper.writeValueAsString(updatedUser);
			updatedExistingUser = objectReader.readValue(updatedUserString);
	        userRepository.save(updatedExistingUser);
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return objectMapper.convertValue(updatedExistingUser, UpdateUserDto.class);
	}
}
