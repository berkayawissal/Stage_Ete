package com.example.demo.model;


import javax.persistence.*;
import java.util.List;
@Entity
public class Livreur extends ChaineDeDistribution{
    public Livreur(){

    }
    public Livreur (String role, String nom, String prenom, String email, String address, String type, String numTel, List<Commande> commandes, List<PointDeVente> pointsDeVente) {
        super(role, nom, prenom, email, address, type, numTel, commandes, pointsDeVente);
    }
}
