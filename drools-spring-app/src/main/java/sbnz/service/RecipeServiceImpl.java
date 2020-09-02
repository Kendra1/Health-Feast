package sbnz.service;

import org.springframework.stereotype.Service;

import sbnz.model.Recipe;
import sbnz.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl (RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@Override
	public Recipe findRecipeByName(String name) {
		return recipeRepository.findByName(name);
	}

}
