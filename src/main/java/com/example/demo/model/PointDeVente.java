package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
public class PointDeVente extends Users {


    public PointDeVente() {
    }
    @OneToMany(mappedBy = "pointDeVente")
    private List<EndUsers> endUsers;

    @OneToMany(mappedBy = "pointDeVente")
    private List<Produit> produits;

    public List<EndUsers> getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(List<EndUsers> endUsers) {
        this.endUsers = endUsers;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public PointDeVente(List<EndUsers> endUsers, List<Produit> produits) {
        this.endUsers = endUsers;
        this.produits = produits;
    }

    public PointDeVente(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin, List<EndUsers> endUsers, List<Produit> produits) {
        super(role, nom, prenom, email, address, localisation, numTel, login, password, admin);
        this.endUsers = endUsers;
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "PointDeVente{" +
                "endUsers=" + endUsers +
                ", produits=" + produits +
                '}';
    }
}

