package com.example.demo.dao;

import com.example.demo.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {

    private String fullname;
    private String email;
    private String password;
    private Set<String> role;


    // methode de mappage
    public static Users toEntity(RegistrationRequest request) {
        return Users.builder()
                .username(request.getFullname())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
