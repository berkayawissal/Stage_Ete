package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EnLigne extends PointDeVente{

   public EnLigne (){

   }
    private String siteWeb;
    public EnLigne(String role, String nom, String prenom, String email, String address, String type, String numTel, List<EndUsers> endUsers, List<Produit> produits, List<Commande> commandes, List<ChaineDeDistribution> chaineDeDistributions, String siteWeb) {
        super(role, nom, prenom, email, address, type, numTel, endUsers, produits, commandes, chaineDeDistributions);
        this.siteWeb = siteWeb;
    }


}
