package com.example.demo.model;


import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;



@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "role")
    private String role;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "localisation")
    private String localisation;
    @Column(name = "numTel")
    private String numTel;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAdmin")
    private Admin admin;
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

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

    public Users() {
    }

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

    public void setIdUser(Integer id) {
        this.id = id;
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

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Users(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.localisation = localisation;
        this.numTel = numTel;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", localisation='" + localisation + '\'' +
                ", numTel='" + numTel + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}

