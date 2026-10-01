package online.threadly.user_authentication.controller;

import online.threadly.user_authentication.dao.AuthResponse;
import online.threadly.user_authentication.dao.SignUpRequest;
import online.threadly.user_authentication.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
     final private AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping ("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest signUpRequest){
        return  ResponseEntity.ok(authService.registerUser(signUpRequest));
    }
}
