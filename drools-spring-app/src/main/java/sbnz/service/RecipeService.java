package sbnz.service;

import sbnz.model.Recipe;

public interface RecipeService {

	Recipe findRecipeByName(String name);
}
