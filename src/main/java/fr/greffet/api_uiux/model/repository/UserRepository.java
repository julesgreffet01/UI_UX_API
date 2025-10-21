package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByEmail(String email);
}
