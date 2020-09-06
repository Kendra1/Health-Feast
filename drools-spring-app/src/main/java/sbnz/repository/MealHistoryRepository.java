package sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.model.MealHistory;

public interface MealHistoryRepository extends JpaRepository<MealHistory, Long> {

}
