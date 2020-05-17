package sbnz.integracija.dtos;

public class IngredientDTO {
	
	private String name;
	private int quantity;
	
	public IngredientDTO() {}
	
	public IngredientDTO(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
