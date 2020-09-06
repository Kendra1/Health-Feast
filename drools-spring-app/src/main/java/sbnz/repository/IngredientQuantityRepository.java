package sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.model.IngredientQuantity;

public interface IngredientQuantityRepository extends JpaRepository<IngredientQuantity, Long>{

}
