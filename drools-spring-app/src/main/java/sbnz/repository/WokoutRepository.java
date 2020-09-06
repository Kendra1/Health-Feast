package sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.model.Workout;

public interface WokoutRepository extends JpaRepository<Workout, Long>{

}
