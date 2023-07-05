package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Admin  {

public Admin(){

}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Admin(String login, String password, String role, List<Users> users) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.users = users;
    }


    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
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
}