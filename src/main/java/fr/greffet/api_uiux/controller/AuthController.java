package fr.greffet.api_uiux.controller;

import fr.greffet.api_uiux.dto.LoginDTO;
import fr.greffet.api_uiux.dto.UserDTO;
import fr.greffet.api_uiux.model.entity.User;
import fr.greffet.api_uiux.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<String> authenticate(@RequestBody LoginDTO loginDTO) {
        String token  = authService.authenticate(loginDTO.getEmail(), loginDTO.getPassword());
        return ResponseEntity.ok(token);
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDTO userDTO) {
        User user = authService.register(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
