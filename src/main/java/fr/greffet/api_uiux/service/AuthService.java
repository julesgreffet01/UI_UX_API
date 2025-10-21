package fr.greffet.api_uiux.service;

import fr.greffet.api_uiux.dto.UserDTO;
import fr.greffet.api_uiux.exception.BadCredentialsException;
import fr.greffet.api_uiux.model.entity.User;
import fr.greffet.api_uiux.model.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String authenticate(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email.toLowerCase());
        if(optionalUser.isEmpty()){
            passwordEncoder.matches(password, "aaaa");
            throw new BadCredentialsException("Mot de passe incorrect");
        }
        User user = optionalUser.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Mot de passe incorrect");
        }
        return this.jwtService.generateToken(user);
    }

    public User register(UserDTO userDTO) {
        if(userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            throw new RuntimeException("Email existente");
        }
        User user = new User();
        user.setEmail(userDTO.getEmail().toLowerCase());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        user =  userRepository.save(user);
        return user;
    }
}
