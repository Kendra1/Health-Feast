package sbnz.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class IngredientQuantity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Recipe> recipes;
	
	private double quantity;
	
	private boolean specificIngredient;
	
	public IngredientQuantity() {}
	
	public IngredientQuantity(Ingredient ingredient, double quantity) {
		super();
		this.ingredient = ingredient;
		this.quantity = quantity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Ingredient getIngredient() {
		return ingredient;
	}


	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}


	public double getQuantity() {
		return quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public boolean isSpecificIngredient() {
		return specificIngredient;
	}

	public void setSpecificIngredient(boolean specificIngredient) {
		this.specificIngredient = specificIngredient;
	}
}
