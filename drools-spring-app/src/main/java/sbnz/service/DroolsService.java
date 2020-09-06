package sbnz.service;

import java.util.List;
import java.util.Map;

import sbnz.web.dto.RecipeFilterDto;
import sbnz.web.dto.WorkoutDto;
import sbnz.web.dto.WorkoutFilterDto;
import sbnz.web.dto.RecipeDto;

public interface DroolsService {
	
	List<RecipeDto> getRecipesByIngridients(RecipeFilterDto recipeFilterDto);
	
	List<RecipeDto> getRecipesByName(String name);

	Map<String, String> getWarningForRecipe(Long id);

	List<RecipeDto> getRecommendedRecipes(Long id);

	List<WorkoutDto> getWorkoutsByExercises(WorkoutFilterDto workoutFilterDto);

}
