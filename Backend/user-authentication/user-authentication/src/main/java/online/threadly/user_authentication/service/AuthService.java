package online.threadly.user_authentication.service;

import online.threadly.user_authentication.dao.AuthResponse;
import online.threadly.user_authentication.dao.SignUpRequest;

import online.threadly.user_authentication.model.User;
import online.threadly.user_authentication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    final  private UserRepository userRepository;
    final private JwtService jwtService;

     public AuthService (UserRepository userRepository , JwtService jwtService){
         this.userRepository=userRepository;
         this.jwtService=jwtService;
     }


    public AuthResponse registerUser(SignUpRequest signUpRequest){
        User user = User.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .role(signUpRequest.getRole())
                .build();



        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
         return  new AuthResponse(jwtToken);

    }
}
