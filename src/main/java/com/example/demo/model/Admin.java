package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Admin implements Serializable {

public Admin(){

}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;

    public Integer getIdAdmin() {
        return idAdmin;
    }
    private String login;
    private String password;
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(Integer idAdmin, String login, String password, String role) {
        this.idAdmin = idAdmin;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @OneToMany(mappedBy = "admin",targetEntity=Users.class)
    private List<Users> users;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Admin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
}