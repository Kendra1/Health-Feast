package sbnz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.service.IngredientService;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("/ingredients")
	public List<String> getIngredients() {
		return ingredientService.getIngredients();
	}

}
