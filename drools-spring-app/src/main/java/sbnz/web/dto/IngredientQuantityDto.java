package sbnz.web.dto;

public class IngredientQuantityDto {

	private IngredientDto ingredient;
		
	private double quantity;

	public IngredientQuantityDto() {}
	
	public IngredientQuantityDto(IngredientDto ingredient, double quantity) {
		this.ingredient = ingredient;
		this.quantity = quantity;
	}

	public IngredientDto getIngredient() {
		return ingredient;
	}


	public void setIngredient(IngredientDto ingredient) {
		this.ingredient = ingredient;
	}


	public double getQuantity() {
		return quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
