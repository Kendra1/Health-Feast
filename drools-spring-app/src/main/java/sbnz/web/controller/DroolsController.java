package sbnz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.service.DroolsService;
import sbnz.web.dto.RecipeFilterDto;
import sbnz.web.dto.RecipeDto;

@RestController
@RequestMapping("/api/drools")
public class DroolsController {
	
	@Autowired
	private DroolsService droolsService;
	
	@GetMapping("/recipes")
	public List<RecipeDto> getRecipes(@RequestBody RecipeFilterDto recipeFilterDto) {
		return droolsService.getRecipesByIngridients(recipeFilterDto);
	}
	
	@GetMapping("/recipesByName")
	public List<RecipeDto> getRecipesByName(@RequestParam("name") String name) {
		return droolsService.getRecipesByName(name);
	}
}
