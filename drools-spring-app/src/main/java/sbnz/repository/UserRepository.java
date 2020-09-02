package sbnz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByPasswordAndEmail(String password, String email);

	Optional<User> findByEmail(String email);
}
