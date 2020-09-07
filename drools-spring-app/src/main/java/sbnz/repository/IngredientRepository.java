package sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	Ingredient findByName(String name);
}
