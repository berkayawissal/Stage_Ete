package com.example.Admin.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Livreur extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "livreur")
    private List<Commande> commandes;
    @ManyToMany(mappedBy = "livreurs")
    private List<PointDeVente> pointsDeVente;

    public List<PointDeVente> getPointsDeVente() {
        return pointsDeVente;
    }

    public void setPointsDeVente(List<PointDeVente> pointsDeVente) {
        this.pointsDeVente = pointsDeVente;
    }

    public Long getId() {
        return id;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }


    public Livreur(String role, String nom, String prenom, String email, String address, String type, String numTel, List<Commande> commandes, List<PointDeVente> pointsDeVente) {
        super(role, nom, prenom, email, address, type, numTel);
        this.commandes = commandes;
        this.pointsDeVente = pointsDeVente;
    }
}
