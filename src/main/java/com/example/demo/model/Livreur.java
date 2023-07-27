package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@Entity
public class Livreur extends Users{
    public Livreur(){

    }
    @OneToMany(mappedBy = "livreurs", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Commande> commandes;
    @ManyToOne( cascade=CascadeType.PERSIST)
    @JoinColumn(name = "idEndUser")
    @JsonBackReference
    private EndUsers endUsers;
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public EndUsers getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(EndUsers endUsers) {
        this.endUsers = endUsers;
    }


    public Livreur(Integer id, ERoles roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        super(id, roles, nom, prenom, email, address, localisation, numTel, password);

    }

    @Override
    public String toString() {
        return "Livreur{" +
                "commandes=" + commandes +
                ", endUsers=" + endUsers +
                '}';
    }
}
