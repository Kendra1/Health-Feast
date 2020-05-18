package sbnz.integracija.facts;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class RelatedRecipes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Recipe Recipe;
	
	@OneToMany
	private List<Recipe> relatedRecipes;


	public RelatedRecipes() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return Recipe;
	}

	public void setRecipe(Recipe recipe) {
		Recipe = recipe;
	}

	public List<Recipe> getRelatedRecipes() {
		return relatedRecipes;
	}

	public void setRelatedRecipes(List<Recipe> relatedRecipes) {
		this.relatedRecipes = relatedRecipes;
	}
	
	
}
