package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "end_users")
public class EndUsers extends Users {
public EndUsers(){

}
//    @Id
//    private Integer idEndUser;

    @ManyToOne( cascade=CascadeType.PERSIST)
    @JoinColumn(name = "point_de_vente_id")
    @JsonBackReference
    private PointDeVente pointDeVente;
    @OneToMany(mappedBy = "endUser",cascade=CascadeType.PERSIST)
    @JsonManagedReference
    private List<Commande> commandes;
    @OneToMany(mappedBy = "endUsers", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Livreur> Livreurs;



    public PointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(PointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Livreur> getLivreurs() {
        return Livreurs;
    }

    public void setLivreurs(List<Livreur> livreurs) {
        Livreurs = livreurs;
    }

    public EndUsers(Integer id, ERoles roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        super(id, roles, nom, prenom, email, address, localisation, numTel, password);
    }

    @Override
    public String toString() {
        return "EndUsers{" +
                ", pointDeVente=" + pointDeVente +
                ", commandes=" + commandes +
                ", Livreurs=" + Livreurs +
                '}';
    }
}

