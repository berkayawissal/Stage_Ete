package com.example.Admin.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    private String role;

    // Relations
    @OneToMany(mappedBy = "admin")
    private List<User> users;

    public Admin(String role, String nom, String prenom, String email, String address, String type, String numTel, String role1, List<User> users) {
        super(role, nom, prenom, email, address, type, numTel);
        this.role = role1;
        this.users = users;
    }

    // Getters et setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
