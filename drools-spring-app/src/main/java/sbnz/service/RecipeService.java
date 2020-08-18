package sbnz.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import sbnz.web.dto.IngredientDto;
import sbnz.model.Ingredient;
import sbnz.model.IngredientQuantity;
import sbnz.model.Recipe;
import sbnz.repository.RecipeRepository;

@Service
public class RecipeService {

	private final KieContainer kieContainer;
	private final RecipeRepository recipeRepository;
	
	public RecipeService(KieContainer kieContainer,RecipeRepository recipeRepository ) {
		this.kieContainer = kieContainer;
		this.recipeRepository = recipeRepository;
	}
	
	public String recipes(List<IngredientDto> ingredients) {		
		KieSession kieSession = kieContainer.newKieSession();
		ingredients.forEach(ingredient -> kieSession.insert(ingredient));
		kieSession.insert(ingredients);
		kieSession.insert(this);
		
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();
		
		return "";
	}
	
	public Recipe getRecipeByName(String name) {
		Recipe recipe = new Recipe();
		recipe.setName("pizza");
		List<IngredientQuantity> ingredients = new ArrayList();
		
		//cheese
		IngredientQuantity ingredientQuantity = new IngredientQuantity();
		Ingredient ingredient = new Ingredient();
		ingredient.setName("cheese");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity);		

		//cheese
		IngredientQuantity ingredientQuantity1 = new IngredientQuantity();
		Ingredient ingredient1 = new Ingredient();
		ingredient.setName("ketchup");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity1);		
		
		//cheese
		IngredientQuantity ingredientQuantity2 = new IngredientQuantity();
		Ingredient ingredient2 = new Ingredient();
		ingredient.setName("mushrooms");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity2);		

		
		//cheese
		IngredientQuantity ingredientQuantity3 = new IngredientQuantity();
		Ingredient ingredient3 = new Ingredient();
		ingredient.setName("base");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity3);		

		
		//cheese
		IngredientQuantity ingredientQuantity4 = new IngredientQuantity();
		Ingredient ingredient4 = new Ingredient();
		ingredient.setName("egg");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity4);				
		
		recipe.setIngredients(ingredients);
		
		return recipe;
//		return recipeRepository.findByName(name);
	}
	
	public Recipe getRecipeByName1(String name) {
		Recipe recipe = new Recipe();
		recipe.setName("muffin");
		List<IngredientQuantity> ingredients = new ArrayList();
		
		//cheese
		IngredientQuantity ingredientQuantity = new IngredientQuantity();
		Ingredient ingredient = new Ingredient();
		ingredient.setName("flour");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity);		

		//cheese
		IngredientQuantity ingredientQuantity1 = new IngredientQuantity();
		Ingredient ingredient1 = new Ingredient();
		ingredient.setName("sugar");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity1);		
		
		//cheese
		IngredientQuantity ingredientQuantity2 = new IngredientQuantity();
		Ingredient ingredient2 = new Ingredient();
		ingredient.setName("milk");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity2);		

		
		//cheese
		IngredientQuantity ingredientQuantity3 = new IngredientQuantity();
		Ingredient ingredient3 = new Ingredient();
		ingredient.setName("cocoa");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity3);		

		
		//cheese
		IngredientQuantity ingredientQuantity4 = new IngredientQuantity();
		Ingredient ingredient4 = new Ingredient();
		ingredient.setName("chocolate");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity4);				
		
		//cheese
		IngredientQuantity ingredientQuantity5 = new IngredientQuantity();
		Ingredient ingredient5 = new Ingredient();
		ingredient.setName("oil");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity5);	
		recipe.setIngredients(ingredients);
		
		//cheese
		IngredientQuantity ingredientQuantity6 = new IngredientQuantity();
		Ingredient ingredient6 = new Ingredient();
		ingredient.setName("egg");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity6);	

		return recipe;
//		return recipeRepository.findByName(name);
	}
	
	public Recipe getRecipeByName2(String name) {
		Recipe recipe = new Recipe();
		recipe.setName("cookies");
		List<IngredientQuantity> ingredients = new ArrayList();
		
		//cheese
		IngredientQuantity ingredientQuantity = new IngredientQuantity();
		Ingredient ingredient = new Ingredient();
		ingredient.setName("flour");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity);		

		//cheese
		IngredientQuantity ingredientQuantity1 = new IngredientQuantity();
		Ingredient ingredient1 = new Ingredient();
		ingredient.setName("sugar");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity1);		
		
		//cheese
		IngredientQuantity ingredientQuantity2 = new IngredientQuantity();
		Ingredient ingredient2 = new Ingredient();
		ingredient.setName("brown sugar");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity2);		

		
		//cheese
		IngredientQuantity ingredientQuantity3 = new IngredientQuantity();
		Ingredient ingredient3 = new Ingredient();
		ingredient.setName("butter");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity3);		

		
		//cheese
		IngredientQuantity ingredientQuantity4 = new IngredientQuantity();
		Ingredient ingredient4 = new Ingredient();
		ingredient.setName("chocolate");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity4);				
		
		//cheese
		IngredientQuantity ingredientQuantity6 = new IngredientQuantity();
		Ingredient ingredient6 = new Ingredient();
		ingredient.setName("egg");
		ingredientQuantity.setIngredient(ingredient);
		ingredientQuantity.setQuantity(250);
		ingredients.add(ingredientQuantity6);	
		
		recipe.setIngredients(ingredients);

		return recipe;
//		return recipeRepository.findByName(name);
	}
	
}
