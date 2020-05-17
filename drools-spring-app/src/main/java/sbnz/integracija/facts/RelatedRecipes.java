package sbnz.integracija.facts;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class RelatedRecipes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Recipe firstRecipe;
	
	@OneToOne
	private Recipe secondRecipe;
	

	public RelatedRecipes(Recipe firstRecipe, Recipe secondRecipe) {
		this.firstRecipe = firstRecipe;
		this.secondRecipe = secondRecipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recipe getFirstRecipe() {
		return firstRecipe;
	}

	public void setFirstRecipe(Recipe firstRecipe) {
		this.firstRecipe = firstRecipe;
	}

	public Recipe getSecondRecipe() {
		return secondRecipe;
	}

	public void setSecondRecipe(Recipe secondRecipe) {
		this.secondRecipe = secondRecipe;
	}
}
