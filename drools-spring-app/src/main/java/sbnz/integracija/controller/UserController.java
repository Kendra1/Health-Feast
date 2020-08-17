	package sbnz.integracija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dtos.IngredientDto;
import sbnz.integracija.enumeration.UserStatus;
import sbnz.integracija.facts.Ingredient;
import sbnz.integracija.service.RecipeService;
import sbnz.integracija.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;

	
	@GetMapping("/userStatus")
	public UserStatus getUserStatus(@RequestParam ("purchasePoints") int purchasePoints) {
		return userService.getUserStatus(purchasePoints);
	}
	
	@GetMapping("/calories")
	public String getRecommendedIntake(@RequestParam ("weight") int weight, 
			@RequestParam ("gender") String gender, @RequestParam ("activity") String activity) {
		return userService.getRecommendedIntake(weight, gender, activity);
	}
	
	@GetMapping("/recommendedCalories")
	public String getRecommendedCalories(@RequestParam ("goal") String goal) {
		return userService.getRecommendedCalories(goal);
	}
	
	@GetMapping("/dailyCaloriesStatus")
	public String getDailyCaloriesStatus() {
		return userService.getDailyCaloriesStatus();
	}
	
	@PostMapping("/recipes")
	public String getRecipes(@RequestBody List<IngredientDto> ingredients) {
		return recipeService.recipes(ingredients);
	}
}
