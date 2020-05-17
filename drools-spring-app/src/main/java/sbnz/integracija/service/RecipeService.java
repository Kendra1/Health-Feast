package sbnz.integracija.service;

import java.util.ArrayList;

import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.facts.Recipe;

@Service
public class RecipeService {

	private static Logger log = LoggerFactory.getLogger(RecipeService.class);

	private final KieContainer kieContainer;

	@Autowired
	public RecipeService(KieContainer kieContainer) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}

	public Recipe getClassifiedRecipe(Recipe recipe) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(recipe);
		kieSession.fireAllRules();
		kieSession.dispose();
		return recipe;
	}
	
	public void app() {
		KieSession kieSession = kieContainer.newKieSession();
//		Ingredient food1 = new Ingredient();
//		food1.setId(1L);
//		food1.setName("brasno");
//		
//		Ingredient food2 = new Ingredient();
//		food2.setId(2L);
//		food2.setName("mleko");
//		
//		Ingredient food3 = new Ingredient();
//		food3.setId(3L);
//		food3.setName("jaja");
//		
//		Recipe recipe = new Recipe();
//		ArrayList<Ingredient> foods = new ArrayList<Ingredient>();
//		foods.add(food1);
//		foods.add(food2);
//		foods.add(food3);
		
//		recipe.setId(1L);
//		recipe.setGroupOfRecipe(GroupA.SECOND);
//		recipe.setIngredients(foods);
//		recipe.setName("Palacinke");
//		recipe.setNumIngredients(0L);
//		recipe.setMinimumOI(1);
//		kieSession.insert(recipe);
//		kieSession.insert(food1);
//		kieSession.insert(food2);
//		kieSession.insert(food3);
		
		
		int firedRules =  kieSession.fireAllRules();
//		
//		System.out.println(firedRules);
//		System.out.println(recipe.getNumIngredients());
//		System.out.println(recipe.isFlag());
//		System.out.println(recipe.getIngredients().size());
		
		kieSession.dispose();
	}
}
