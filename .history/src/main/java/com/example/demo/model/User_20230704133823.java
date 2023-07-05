package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUser;
        private String role;
        private String nom;
        private String prenom;
        private String email;
        private String address;
        private String type;
        private String numTel;

        // Getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public User(String role, String nom, String prenom, String email, String address, String type, String numTel) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.type = type;
        this.numTel = numTel;
    }

}
