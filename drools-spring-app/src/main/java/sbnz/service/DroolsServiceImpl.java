package sbnz.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import sbnz.model.drools.PrioritizedRecipe;
import sbnz.model.drools.Recipes;
import sbnz.web.dto.RecipeFilterDto;
import sbnz.web.dto.RecipeDto;

@Service
public class DroolsServiceImpl implements DroolsService {

	private final KieContainer kieContainer;
	private final RecipeService recipeService;
	
	public DroolsServiceImpl(KieContainer kieContainer, RecipeService recipeService) {
		this.kieContainer = kieContainer;
		this.recipeService = recipeService;
	}
	
	@Override
	public List<RecipeDto> getRecipesByIngridients(RecipeFilterDto recipeFilterDto) {
		KieSession kieSession = kieContainer.newKieSession();
		
		kieSession.insert(recipeFilterDto);
		kieSession.insert(recipeService);
		
		Recipes recipes = new Recipes();
		kieSession.setGlobal("globalRecipes", recipes);
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();
		
		Recipes globalRecipes = (Recipes) kieSession.getGlobal("globalRecipes");
		
		List<PrioritizedRecipe> prioritizedRecipes = globalRecipes.getRecipes();
		List<RecipeDto> recipesDto = new ArrayList<>();
		
		for (PrioritizedRecipe recipe: prioritizedRecipes) {
			RecipeDto recipeDto = new RecipeDto();
			recipeDto.setName(recipe.getName());
			recipesDto.add(recipeDto);
		}
		
		return recipesDto;
	}

	@Override
	public List<RecipeDto> getRecipesByName(String name) {

		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(name);
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();
		
//		kieSession.getObjects();
		return null;
	}

}
