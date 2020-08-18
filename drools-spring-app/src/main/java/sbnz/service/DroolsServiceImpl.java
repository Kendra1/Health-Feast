package sbnz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sbnz.web.dto.IngredientDto;
import sbnz.web.dto.RecipeDto;

@Service
public class DroolsServiceImpl implements DroolsService {

	@Override
	public List<RecipeDto> getRecipesByIngridients(List<IngredientDto> ingredients) {
		// TODO Auto-generated method stub
		return null;
	}

}
