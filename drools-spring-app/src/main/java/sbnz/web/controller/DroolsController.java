package sbnz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sbnz.service.DroolsService;
import sbnz.web.dto.IngredientDto;
import sbnz.web.dto.RecipeDto;

@RestController("api/drools")
public class DroolsController {
	
	@Autowired
	private DroolsService droolsService;
	
	@GetMapping("/recipes")
	public List<RecipeDto> getRecipes(@RequestBody List<IngredientDto> ingredients) {
		return droolsService.getRecipesByIngridients(ingredients);
	}
}
