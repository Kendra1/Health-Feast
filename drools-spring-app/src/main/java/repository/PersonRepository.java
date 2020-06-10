package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.facts.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	Person findByEmail(String email);
}
