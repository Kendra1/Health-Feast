package sbnz.web.dto;

import java.util.List;

import sbnz.enumeration.Category;
import sbnz.enumeration.Diet;
import sbnz.enumeration.Kitchen;

public class RecipeDto {
	
	private String name;
	private int preparationTime;
	private String instructions;
	private int noOfPeople;
	private Category mealType;
	private Kitchen kitchenType;
	private double calories;
	private List<Diet> dietTypes;
	
	private List<IngredientDto> ingredients;
	
	public RecipeDto() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public Category getMealType() {
		return mealType;
	}

	public void setMealType(Category mealType) {
		this.mealType = mealType;
	}

	public Kitchen getKitchenType() {
		return kitchenType;
	}

	public void setKitchenType(Kitchen kitchenType) {
		this.kitchenType = kitchenType;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public List<Diet> getDietTypes() {
		return dietTypes;
	}

	public void setDietTypes(List<Diet> dietTypes) {
		this.dietTypes = dietTypes;
	}

	public List<IngredientDto> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDto> ingredients) {
		this.ingredients = ingredients;
	}

}
