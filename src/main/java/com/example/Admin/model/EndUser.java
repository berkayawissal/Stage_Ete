package com.example.Admin.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class EndUser extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "point_de_vente_id")
    private PointDeVente pointDeVente;
    @OneToMany(mappedBy = "endUser")
    private List<Commande> commandes;

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(PointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public EndUser(String role, String nom, String prenom, String email, String address, String type, String numTel, String username, String password, PointDeVente pointDeVente, List<Commande> commandes) {
        super(role, nom, prenom, email, address, type, numTel);
        this.username = username;
        this.password = password;
        this.pointDeVente = pointDeVente;
        this.commandes = commandes;
    }
}
