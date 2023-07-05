package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name = "produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;
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

    public Integer getIdProduit() {
        return idProduit;
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
