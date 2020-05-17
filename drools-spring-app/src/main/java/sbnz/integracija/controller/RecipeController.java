package sbnz.integracija.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.facts.Recipe;
import sbnz.integracija.service.RecipeService;

@RestController
public class RecipeController {
	private static Logger log = LoggerFactory.getLogger(RecipeController.class);

	private final RecipeService sampleService;

	@Autowired
	public RecipeController(RecipeService sampleService) {
		this.sampleService = sampleService;
	}
	
	@RequestMapping(value = "/recipe", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Void> recipe() {
		System.out.print(">>>>");
		sampleService.app();
		

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
