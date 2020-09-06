package sbnz.model.drools;

import sbnz.model.Recipe;

public class PrioritizedRecipe{

	private Recipe recipe;
	private int priority;
	
	public PrioritizedRecipe(Recipe recipe, int priority) {
		this.recipe = recipe;
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}


	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
