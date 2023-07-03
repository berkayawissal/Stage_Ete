package com.example.Admin.model;

import jakarta.persistence.*;
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "pointDeVenteId")
    private PointDeVente pointDeVente;

    public Produit(String nom, double prix, PointDeVente pointDeVente) {
        this.nom = nom;
        this.prix = prix;
        this.pointDeVente = pointDeVente;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public PointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(PointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
    }
}
