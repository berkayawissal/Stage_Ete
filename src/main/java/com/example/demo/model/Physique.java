package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Physique extends PointDeVente{
    public Physique(){

    }

    public Physique(List<EndUsers> endUsers, List<Produit> produits) {
        super(endUsers, produits);
    }

    public Physique(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin, List<EndUsers> endUsers, List<Produit> produits) {
        super(role, nom, prenom, email, address, localisation, numTel, login, password, admin, endUsers, produits);
    }

}
