package com.example.demo.model;


import javax.persistence.*;
import java.util.List;


@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
public class ChaineDeDistribution extends Users {
    public ChaineDeDistribution(){

    }
    public ChaineDeDistribution(String role, String nom, String prenom, String email, String address, String type, String numTel) {
        super(role, nom, prenom, email, address, type, numTel);
    }
    @OneToMany(mappedBy = "chaineDeDistribution", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    @ManyToMany(mappedBy = "chaineDeDistributions")
    private List<PointDeVente> pointsDeVente;

    public List<PointDeVente> getPointsDeVente() {
        return pointsDeVente;
    }

    public void setPointsDeVente(List<PointDeVente> pointsDeVente) {
        this.pointsDeVente = pointsDeVente;
    }



    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }


    public ChaineDeDistribution(String role, String nom, String prenom, String email, String address, String type, String numTel, List<Commande> commandes, List<PointDeVente> pointsDeVente) {
        super(role, nom, prenom, email, address, type, numTel);
        this.commandes = commandes;
        this.pointsDeVente = pointsDeVente;
    }
}
