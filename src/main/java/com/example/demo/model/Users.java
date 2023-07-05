package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;



@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idUser;
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
    @Column(name = "type")
    private String type;
    @Column(name = "numTel")
    private String numTel;

    protected Users() {
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

    public void setIdUser(Integer idUser) {
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

    public Users(String role, String nom, String prenom, String email, String address, String type, String numTel) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.type = type;
        this.numTel = numTel;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @ManyToOne(fetch=FetchType.EAGER, optional=true, cascade=CascadeType.ALL,targetEntity = Admin.class)
    @JoinColumn(name = "idAdmin")
    private Admin admin;

}

