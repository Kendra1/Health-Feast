package sbnz.web.dto;

import java.util.List;

public class RecipeFilterDto {

	private List<String> ingredients;
	private List<String> dietTypes;
	private List<String> allergens;
	private String kitchenType;
	private String mealType;
	private int fromKcal;
	private int toKcal;
	private int fromMins;
	private int toMins;
	private int fromPpl;
	private int toPpl;

	public RecipeFilterDto() {
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getDietTypes() {
		return dietTypes;
	}

	public void setDietTypes(List<String> dietTypes) {
		this.dietTypes = dietTypes;
	}

	public List<String> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<String> allergens) {
		this.allergens = allergens;
	}

	public String getKitchenType() {
		return kitchenType;
	}

	public void setKitchenType(String kitchenType) {
		this.kitchenType = kitchenType;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public int getFromKcal() {
		return fromKcal;
	}

	public void setFromKcal(int fromKcal) {
		this.fromKcal = fromKcal;
	}

	public int getToKcal() {
		return toKcal;
	}

	public void setToKcal(int toKcal) {
		this.toKcal = toKcal;
	}

	public int getFromMins() {
		return fromMins;
	}

	public void setFromMins(int fromMins) {
		this.fromMins = fromMins;
	}

	public int getToMins() {
		return toMins;
	}

	public void setToMins(int toMins) {
		this.toMins = toMins;
	}

	public int getFromPpl() {
		return fromPpl;
	}

	public void setFromPpl(int fromPpl) {
		this.fromPpl = fromPpl;
	}

	public int getToPpl() {
		return toPpl;
	}

	public void setToPpl(int toPpl) {
		this.toPpl = toPpl;
	}
}
