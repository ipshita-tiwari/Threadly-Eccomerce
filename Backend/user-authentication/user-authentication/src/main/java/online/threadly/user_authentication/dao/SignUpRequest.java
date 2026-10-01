package online.threadly.user_authentication.dao;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.threadly.user_authentication.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
