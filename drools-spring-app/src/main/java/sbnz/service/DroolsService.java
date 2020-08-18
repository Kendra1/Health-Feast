package sbnz.service;

import java.util.List;

import sbnz.web.dto.IngredientDto;
import sbnz.web.dto.RecipeDto;

public interface DroolsService {
	
	List<RecipeDto> getRecipesByIngridients(List<IngredientDto> ingredients);

}
