package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EnLigne extends PointDeVente{

   public EnLigne (){

   }

    @Override
    public String toString() {
        return "EnLigne{" +
                "siteWeb='" + siteWeb + '\'' +
                '}';
    }

    private String siteWeb;

    public EnLigne(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public EnLigne(List<EndUsers> endUsers, List<Produit> produits, List<Commande> commandes, String siteWeb) {
        super(endUsers, produits);
        this.siteWeb = siteWeb;
    }

    public EnLigne(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin, List<EndUsers> endUsers, List<Produit> produits,  String siteWeb) {
        super(role, nom, prenom, email, address, localisation, numTel, login, password, admin, endUsers, produits);
        this.siteWeb = siteWeb;
    }
}
