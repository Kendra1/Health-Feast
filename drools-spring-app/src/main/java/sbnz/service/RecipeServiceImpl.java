package sbnz.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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

	@Override
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe findRecipeById(Long id) {
		return recipeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<String> getRecipes() {
		List<Recipe> recipes = recipeRepository.findAll();
		
		return recipes.stream().map(recipe -> recipe.getName()).collect(Collectors.toList());
	}

}
