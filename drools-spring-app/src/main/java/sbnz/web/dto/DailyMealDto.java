package sbnz.web.dto;

import java.util.List;

public class DailyMealDto {

	private String date;
	private List<IngredientDto> ingredientsDto;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<IngredientDto> getIngredientsDto() {
		return ingredientsDto;
	}
	public void setIngredientsDto(List<IngredientDto> ingredientsDto) {
		this.ingredientsDto = ingredientsDto;
	}
}
