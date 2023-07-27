package com.example.demo.dto;

import com.example.demo.model.Admin;
import com.example.demo.model.ERoles;
import com.example.demo.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.OneToMany;
import java.util.List;
@Jacksonized
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {
    private Integer idAdmin;
    private String loginAdmin;
    private String passwordAdmin;
    private String roles;
    @JsonIgnore
    private static List<UsersDto> users;

    public static Admin toEntity(AdminDto adminDto) {
        if (adminDto==null) {
            return null;
            // TODO exception
        }
        return (Admin) Admin.builder()
                .email(adminDto.getLoginAdmin())
                .password(adminDto.getPasswordAdmin())
                .roles(ERoles.valueOf(adminDto.getRoles()))
                .build();
    }
    public static AdminDto fromEntity(Admin admin) {
        if (admin==null) {
            return null;
            // TODO exception
        }
        return AdminDto.builder()
                .idAdmin(admin.getId())
                .loginAdmin(admin.getEmail())
                .build();
    }

}
