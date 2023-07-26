package com.example.demo.controller.auth;

import com.example.demo.model.Users;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private  String email;
    private String password;
    private String role;
    public static Users toEntity(RegisterRequest request) {
        return Users.builder()
                .nom(request.getFirstname())
                .prenom(request.getLastname())
                .login(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }

}
