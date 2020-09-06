package sbnz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import sbnz.model.IngredientQuantity;
import sbnz.model.Recipe;
import sbnz.model.drools.PrioritizedRecipe;
import sbnz.model.drools.PrioritizedRecipes;
import sbnz.web.dto.IngredientDto;
import sbnz.web.dto.RecipeDto;
import sbnz.web.dto.RecipeFilterDto;

@Service
public class DroolsServiceImpl implements DroolsService {

	private final KieContainer kieContainer;
	private final RecipeService recipeService;
	private final ObjectMapper objectMapper;
	
	public DroolsServiceImpl(KieContainer kieContainer, RecipeService recipeService, ObjectMapper objectMapper) {
		this.kieContainer = kieContainer;
		this.recipeService = recipeService;
		this.objectMapper = objectMapper;
	}
	
	@Override
	public List<RecipeDto> getRecipesByIngridients(RecipeFilterDto recipeFilterDto) {
		KieSession kieSession = kieContainer.newKieSession();
		
		List<Recipe> allRecipes = recipeService.findAll();
		List<PrioritizedRecipe> pRecipes = new ArrayList<>();
		
		//get all recipes
		kieSession.insert(recipeFilterDto);
		kieSession.insert(pRecipes);
		kieSession.insert(allRecipes);
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();
		
		PrioritizedRecipes prioritizedRecipes = sortRecipesByPriority(pRecipes);
		System.out.println("Filter " + recipeFilterDto.toString());

		List<RecipeDto> recipesDto = new ArrayList<>();
				
		for (PrioritizedRecipe recipe: prioritizedRecipes.getRecipes()) {
			List<IngredientDto> ingredientsDto = mapIngredientsToIngredientDto(recipe.getRecipe().getIngredients());
			RecipeDto recipeDto = objectMapper.convertValue(recipe.getRecipe(), RecipeDto.class);
			recipeDto.setIngredients(ingredientsDto);
			recipesDto.add(recipeDto);
		}
		
		return recipesDto;
	}
	
	private PrioritizedRecipes sortRecipesByPriority(List<PrioritizedRecipe> pRecipes) {
		KieSession kieSession = kieContainer.newKieSession();

		for (PrioritizedRecipe recipe: pRecipes) {
			kieSession.insert(recipe);
		}
		
		//sort all recipes by priority
		PrioritizedRecipes prioritizedRecipes = new PrioritizedRecipes();
		kieSession.insert(prioritizedRecipes);
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return prioritizedRecipes;
	}

	@Override
	public List<RecipeDto> getRecipesByName(String name) {

		KieSession kieSession = kieContainer.newKieSession();
		
		List<Recipe> allRecipes = recipeService.findAll();
		List<Recipe> foundRecipes = new ArrayList<>();
		
		kieSession.insert(name);
		kieSession.insert(allRecipes);
		kieSession.insert(foundRecipes);
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();
		
		return mapRecipesToRecipesDto(foundRecipes);
	}

	@Override
	public Map<String, String> getWarningForRecipe(Long id) {		
		Recipe recipe = recipeService.findRecipeById(id);
		Map<String, String> ingredientWarning = new HashMap<>();
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(recipe);
		kieSession.insert(ingredientWarning);
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();

		return ingredientWarning;
	}

	@Override
	public List<RecipeDto> getRecommendedRecipes(Long id) {
		Recipe recipe = recipeService.findRecipeById(id);
		List<Recipe> recommendedRecipes = new ArrayList<>();
		System.out.println(recipe.getRecommendedRecipes());
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(recipe);
		kieSession.insert(recommendedRecipes);
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();

		return mapRecipesToRecipesDto(recommendedRecipes);
	}

	private List<RecipeDto> mapRecipesToRecipesDto(List<Recipe> foundRecipes){
		List<RecipeDto> recipesDto = new ArrayList<>();
		
		for (Recipe recipe: foundRecipes) {
			List<IngredientDto> ingredientsDto = mapIngredientsToIngredientDto(recipe.getIngredients());
			RecipeDto recipeDto = objectMapper.convertValue(recipe, RecipeDto.class);
			recipeDto.setIngredients(ingredientsDto);
			recipesDto.add(recipeDto);
		}
		
		return recipesDto;	
	}
	
	private List<IngredientDto> mapIngredientsToIngredientDto(List<IngredientQuantity> ingredients){
		return ingredients.stream()
				.map(ingredientQuantity-> {
					
					IngredientDto ingredientDto = objectMapper.convertValue(ingredientQuantity.getIngredient(), IngredientDto.class);
					ingredientDto.setQuantity(ingredientQuantity.getQuantity());
					
					return ingredientDto;
					}).collect(Collectors.toList());		
	}
}
