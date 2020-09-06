package sbnz.service;

import java.util.List;

import sbnz.model.Recipe;

public interface RecipeService {

	Recipe findRecipeByName(String name);

	List<Recipe> findAll();

	Recipe findRecipeById(Long id);

	List<String> getRecipes();
}
