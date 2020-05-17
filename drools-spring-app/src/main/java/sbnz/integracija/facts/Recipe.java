package sbnz.integracija.facts;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import sbnz.integracija.enumeration.Category;
import sbnz.integracija.enumeration.Diet;
import sbnz.integracija.enumeration.Kitchen;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany
	private List<IngredientQuantity> ingredients;
	
	private int preparationTime;
	private String instructions;
	private int noOfPeople;
	private Category mealType;
	private Kitchen kitchenType;
	private Diet dietType;
	
	@OneToOne
	@JoinColumn(name = "specificIngredient_id")
	private Ingredient specificIngredient;

	public Recipe(String name, List<IngredientQuantity> ingredients, int preparationTime, String instructions,
			int noOfPeople, Category mealType, Kitchen kitchenType, Diet dietType,
			Ingredient specificIngredient) {
		this.name = name;
		this.ingredients = ingredients;
		this.preparationTime = preparationTime;
		this.instructions = instructions;
		this.noOfPeople = noOfPeople;
		this.mealType = mealType;
		this.kitchenType = kitchenType;
		this.dietType = dietType;
		this.specificIngredient = specificIngredient;
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

	public Diet getDietType() {
		return dietType;
	}

	public void setDietType(Diet dietType) {
		this.dietType = dietType;
	}

	public Ingredient getSpecificIngredient() {
		return specificIngredient;
	}

	public void setSpecificIngredient(Ingredient specificIngredient) {
		this.specificIngredient = specificIngredient;
	}
}
