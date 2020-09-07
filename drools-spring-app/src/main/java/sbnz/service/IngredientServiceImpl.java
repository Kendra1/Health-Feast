package sbnz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import sbnz.model.Ingredient;
import sbnz.repository.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService{

	private final IngredientRepository ingredientRepository;
	
	public IngredientServiceImpl(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	@Override
	public List<String> getIngredients() {
		List<Ingredient> ingredients = ingredientRepository.findAll();
		
		return ingredients.stream().map(ingredient -> ingredient.getName()).collect(Collectors.toList());
	}

	@Override
	public Ingredient findByName(String name) {
		return ingredientRepository.findByName(name);
	}

}
