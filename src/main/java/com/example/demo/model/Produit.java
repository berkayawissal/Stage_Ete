package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "produits")
public class Produit {
    public Produit(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;
    private String nom;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "pointDeVenteId")
    private PointDeVente pointDeVente;
    @ManyToOne
    @JoinColumn(name = "idDistributeur")
    private Distributeur distributeurs;

    @ManyToMany
    @JoinTable(
            name = "produitCommande",
            joinColumns = @JoinColumn(name = "produitId"),
            inverseJoinColumns = @JoinColumn(name = "commandeId")
    )
    private List<Commande> commandes;

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

    public Distributeur getDistributeurs() {
        return distributeurs;
    }

    public void setDistributeurs(Distributeur distributeurs) {
        this.distributeurs = distributeurs;
    }

    public Produit(String nom, double prix, PointDeVente pointDeVente, Distributeur distributeurs) {
        this.nom = nom;
        this.prix = prix;
        this.pointDeVente = pointDeVente;
        this.distributeurs = distributeurs;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", pointDeVente=" + pointDeVente +
                ", distributeurs=" + distributeurs +
                '}';
    }
}
