package sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	
	Recipe findByName(String name);
}
