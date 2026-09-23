package online.threadly.user_authentication.controller;

import online.threadly.user_authentication.model.User;
import online.threadly.user_authentication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
 private  final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping("/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email){
        Optional<User> user =this.userService.findByEmail(email);
//        if(user.isPresent())
//            return ResponseEntity.ok(user.get());
//        else
//            return ResponseEntity.notFound().build();
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping
    public User CreateUser(  @RequestBody User user){
        User CreatedUser = this.userService.CreateUser(user);
        return CreatedUser;
    }


}
