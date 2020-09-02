package sbnz.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, UUID>{

    Optional<ConfirmationToken> findByToken(String token);
}
