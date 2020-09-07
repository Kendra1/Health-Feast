package sbnz.web.dto;

import java.util.List;

public class RecipeFilterDto {

	private List<String> ingredients;
	private List<String> dietTypes;
	private List<String> allergens;
	private String kitchenType;
	private String mealType;
	private Integer fromKcal;
	private Integer toKcal;
	private Integer fromMins;
	private Integer toMins;
	private Integer fromPpl;
	private Integer toPpl;

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

	public Integer getFromKcal() {
		return fromKcal;
	}

	public void setFromKcal(Integer fromKcal) {
		this.fromKcal = fromKcal;
	}

	public Integer getToKcal() {
		return toKcal;
	}

	public void setToKcal(Integer toKcal) {
		this.toKcal = toKcal;
	}

	public Integer getFromMins() {
		return fromMins;
	}

	public void setFromMins(Integer fromMins) {
		this.fromMins = fromMins;
	}

	public Integer getToMins() {
		return toMins;
	}

	public void setToMins(Integer toMins) {
		this.toMins = toMins;
	}

	public Integer getFromPpl() {
		return fromPpl;
	}

	public void setFromPpl(Integer fromPpl) {
		this.fromPpl = fromPpl;
	}

	public Integer getToPpl() {
		return toPpl;
	}

	public void setToPpl(Integer toPpl) {
		this.toPpl = toPpl;
	}

	@Override
	public String toString() {
		return "RecipeFilterDto [ingredients=" + ingredients + ", dietTypes=" + dietTypes + ", allergens=" + allergens
				+ ", kitchenType=" + kitchenType + ", mealType=" + mealType + ", fromKcal=" + fromKcal + ", toKcal="
				+ toKcal + ", fromMins=" + fromMins + ", toMins=" + toMins + ", fromPpl=" + fromPpl + ", toPpl=" + toPpl
				+ "]";
	}
	
	
}
