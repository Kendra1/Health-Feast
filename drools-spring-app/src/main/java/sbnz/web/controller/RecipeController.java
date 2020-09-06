package sbnz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.service.RecipeService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("/recipes")
	public List<String> getRecipes() {
		return recipeService.getRecipes();
	}
	
}
