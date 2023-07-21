package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAdmin;
    private String loginAdmin;
    private String passwordAdmin;
    private String roles;
    @OneToMany(mappedBy = "admin")
    private List<Users> users;

    public Admin(Integer idAdmin, String loginAdmin, String passwordAdmin, String roles) {
        this.idAdmin = idAdmin;
        this.loginAdmin = loginAdmin;
        this.passwordAdmin = passwordAdmin;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", login='" + loginAdmin + '\'' +
                ", password='" + passwordAdmin + '\'' +
                ", role='" + roles + '\'' +
                '}';
    }

}