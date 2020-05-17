package sbnz.integracija.facts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NonCompatibleIngredients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private Ingredient firstIngredient;
//	private Ingredient secondIngredient;
	private String message;
	
//	public NonCompatibleIngredients(Ingredient firstIngredient, Ingredient secondIngredient, String message) {
//		this.firstIngredient = firstIngredient;
//		this.secondIngredient = secondIngredient;
//		this.message = message;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Ingredient getFirstIngredient() {
//		return firstIngredient;
//	}
//
//	public void setFirstIngredient(Ingredient firstIngredient) {
//		this.firstIngredient = firstIngredient;
//	}
//
//	public Ingredient getSecondIngredient() {
//		return secondIngredient;
//	}
//
//	public void setSecondIngredient(Ingredient secondIngredient) {
//		this.secondIngredient = secondIngredient;
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
