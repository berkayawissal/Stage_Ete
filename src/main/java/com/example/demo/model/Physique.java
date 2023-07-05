package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Physique extends PointDeVente{
    public Physique(){

    }

    public Physique(String role, String nom, String prenom, String email, String address, String type, String numTel, List<EndUsers> endUsers, List<Produit> produits, List<Commande> commandes, List<ChaineDeDistribution> chaineDeDistributions) {
        super(role, nom, prenom, email, address, type, numTel, endUsers, produits, commandes, chaineDeDistributions);
    }
}
