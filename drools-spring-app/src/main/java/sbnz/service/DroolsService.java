package sbnz.service;

import java.util.List;

import sbnz.web.dto.RecipeFilterDto;
import sbnz.web.dto.RecipeDto;

public interface DroolsService {
	
	List<RecipeDto> getRecipesByIngridients(RecipeFilterDto recipeFilterDto);
	
	List<RecipeDto> getRecipesByName(String name);

}
