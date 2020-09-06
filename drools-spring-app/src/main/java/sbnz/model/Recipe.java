package sbnz.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import sbnz.enumeration.Category;
import sbnz.enumeration.Diet;
import sbnz.enumeration.Kitchen;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			 name = "recipe_ingredient_quantity", 
			 joinColumns = @JoinColumn(name = "recipe_id"), 
			 inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<IngredientQuantity> ingredients;
	
	private int preparationTime;
	private String instructions;
	private int noOfPeople;
	
	@Enumerated(EnumType.STRING)
	private Category mealType;
	
	@Enumerated(EnumType.STRING)
	private Kitchen kitchenType;
	
	private double calories;
	
	@ElementCollection(targetClass = Diet.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "dietTypes")
	@CollectionTable
	private List<Diet> dietTypes;

	@OneToMany
	private List<Recipe> recommendedRecipes;
	
	public Recipe() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IngredientQuantity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientQuantity> ingredients) {
		this.ingredients = ingredients;
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

	public List<Diet> getDietTypes() {
		return dietTypes;
	}

	public void setDietTypes(List<Diet> dietTypes) {
		this.dietTypes = dietTypes;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public List<Recipe> getRecommendedRecipes() {
		return recommendedRecipes;
	}

	public void setRecommendedRecipes(List<Recipe> recommendedRecipes) {
		this.recommendedRecipes = recommendedRecipes;
	}

	public double calculateCalories() {
		double calories = 0;
		for (IngredientQuantity ing: ingredients) {
			calories += ing.getIngredient().getCalories() * ing.getQuantity();
		}
		
		return calories;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", ingredients=" + ingredients + ", preparationTime="
				+ preparationTime + ", instructions=" + instructions + ", noOfPeople=" + noOfPeople + ", mealType="
				+ mealType + ", kitchenType=" + kitchenType + ", calories=" + calories + ", dietTypes=" + dietTypes
				+ ", recommendedRecipes=" + recommendedRecipes + "]";
	}	
}
