package sbnz.model.drools;

import java.util.ArrayList;
import java.util.List;

public class Recipes {
	
	private List<PrioritizedRecipe> recipes = new ArrayList<>();
	
	public Recipes() {}

	public List<PrioritizedRecipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<PrioritizedRecipe> recipes) {
		this.recipes = recipes;
	}
	
	

}
