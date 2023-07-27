package com.example.demo.dto;

import com.example.demo.model.Admin;
import com.example.demo.model.ERoles;
import com.example.demo.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.springframework.security.core.userdetails.User;

@Jacksonized
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {
    private Integer id;
    private String role;
    private String nom;
    private String prenom;
    private String address;
    private String localisation;
    private String numTel;
    private String email;
    private String password;

    private AdminDto adminDto;

    public static UsersDto fromEntity(Users user) {
        if (user == null) {
            return null;
            // TODO exception
        }
        return UsersDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRoles().toString())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .localisation(user.getLocalisation())
                .build();
    }

    public static Users toEntity(UsersDto usersDto) {
        if (usersDto == null) {
            return null;
        // TODO exception
        }
        Users user = new Users();
        user.setId(usersDto.getId());
        user.setEmail(usersDto.getEmail());
        user.setPassword(usersDto.getPassword());
        user.setRoles(ERoles.valueOf(usersDto.getRole()));
        user.setNom(usersDto.getNom());
        user.setPrenom(usersDto.getPrenom());
        user.setLocalisation(usersDto.getLocalisation());
        return user;

    }

}