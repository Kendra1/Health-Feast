package sbnz.integracija.service;

import java.util.List;
import java.io.Console;
import java.util.ArrayList;

import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.enumeration.Activity;
import sbnz.integracija.enumeration.Gender;
import sbnz.integracija.enumeration.Goal;
import sbnz.integracija.enumeration.UserStatus;
import sbnz.integracija.facts.DailyMeal;
import sbnz.integracija.facts.Ingredient;
import sbnz.integracija.facts.MealHistory;
import sbnz.integracija.facts.Recipe;
import sbnz.integracija.facts.User;


@Service
public class UserService {
	
	private final KieContainer kieContainer;

	@Autowired
	public UserService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public UserStatus getUserStatus(int purchasePoints) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		user.setPurchasePoints(purchasePoints);
		user.setActivity(Activity.VERY_LIGHT);
		kieSession.insert(user);
		kieSession.getAgenda().getAgendaGroup("status").setFocus();
		kieSession.fireAllRules();		
		kieSession.dispose();
		return user.getUserStatus();
	}
	
	public String getRecommendedIntake(int weight, String gender, String activity) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		
		user.setWeight(weight);
		user.setGender(Gender.valueOf(gender));
		user.setActivity(Activity.valueOf(activity));
		
		kieSession.insert(user);
		kieSession.getAgenda().getAgendaGroup("activity").setFocus();
		kieSession.fireAllRules();		
		kieSession.dispose();
		
		return String.format("Recommended daily intake of calories to mantain your current weight is: %s", user.getRecommendedDailyCalories());
	}
	
	public String getRecommendedCalories(String goal) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		
		user.setWeight(150);
		user.setGender(Gender.MALE);
		user.setActivity(Activity.HEAVY);
		user.setGoal(Goal.valueOf(goal));
		
		kieSession.insert(user);
		kieSession.getAgenda().getAgendaGroup("activity").setFocus();
		kieSession.fireAllRules();	
		kieSession.dispose();

		
		return String.format("Recommended daily intake of calories for your goal is: %s", user.getRecommendedDailyCalories());
	}
	
	public String getDailyCaloriesStatus() {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		user.setRecommendedDailyCalories(1200);
		
		Ingredient ing1 = new Ingredient();
		ing1.setCalories(100);
		
		Ingredient ing2 = new Ingredient();
		ing2.setCalories(200);
		
		Recipe recipe = new Recipe();
		recipe.setCalories(300);
		
		DailyMeal meal1 = new DailyMeal();
		meal1.setMeal(ing1);
		meal1.setQuantity(2);
		
		DailyMeal meal2 = new DailyMeal();
		meal2.setMeal(ing2);
		meal2.setQuantity(3);
		
		DailyMeal meal3 = new DailyMeal();
		meal3.setMeal(recipe);
		meal3.setQuantity(1);
		
		List<DailyMeal> meals = new ArrayList<DailyMeal>();
		meals.add(meal1);
		meals.add(meal2);
		meals.add(meal3);
		
		MealHistory mealHistoryObj = new MealHistory();
		mealHistoryObj.setMeals(meals);
	
	
		System.out.println("pre ubacivanje");
		kieSession.insert(user);
		kieSession.insert(mealHistoryObj);
		System.out.println("posle ubacivanje");
		kieSession.getAgenda().getAgendaGroup("dailyCalories").setFocus();
		kieSession.fireAllRules();			
		System.out.println("posle svega");
		return "";
	}
}
