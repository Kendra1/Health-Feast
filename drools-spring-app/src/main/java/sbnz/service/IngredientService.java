package sbnz.service;

import java.util.List;

import sbnz.model.Ingredient;

public interface IngredientService {

	List<String> getIngredients();
	
	Ingredient findByName(String name);

}
