package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity

public class Distributeur extends Users{
   public Distributeur(){
   }
    @OneToMany(mappedBy = "distributeurs", cascade = CascadeType.ALL)
    private List<Produit> produits;

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }


    public Distributeur(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin) {
        super(role, nom, prenom, email, address, localisation, numTel, login, password, admin);

    }
}
