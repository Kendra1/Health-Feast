package sbnz.integracija.service;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtos.IngredientDto;
import sbnz.integracija.facts.Ingredient;

@Service
public class RecipeService {

	private final KieContainer kieContainer;

	@Autowired
	public RecipeService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public String recipes(List<IngredientDto> ingredients) {		
		KieSession kieSession = kieContainer.newKieSession();
		ingredients.forEach(ingredient -> kieSession.insert(ingredient));
		kieSession.insert(ingredients);
		
		kieSession.getAgenda().getAgendaGroup("recipes").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return "";
	}
	
}
