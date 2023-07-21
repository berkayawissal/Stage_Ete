package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Livreur extends Users{
    public Livreur(){

    }
    @OneToMany(mappedBy = "livreurs", cascade = CascadeType.PERSIST)
    private List<Commande> commandes;
    @ManyToOne( cascade=CascadeType.PERSIST)
    @JoinColumn(name = "idEndUser")
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


    public Livreur(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin, List<Commande> commandes, EndUsers endUsers) {
        super(role, nom, prenom, email, address, localisation, numTel, login, password, admin);
        this.commandes = commandes;
        this.endUsers = endUsers;
    }

    @Override
    public String toString() {
        return "Livreur{" +
                "commandes=" + commandes +
                ", endUsers=" + endUsers +
                '}';
    }
}
