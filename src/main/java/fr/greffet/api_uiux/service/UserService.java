package fr.greffet.api_uiux.service;

import fr.greffet.api_uiux.model.entity.User;
import fr.greffet.api_uiux.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);
        return user.orElseThrow(() -> new RuntimeException("pas de user"));
    }
}
