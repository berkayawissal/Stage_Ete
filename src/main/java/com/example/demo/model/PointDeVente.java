package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
public class PointDeVente extends Users {


    public PointDeVente() {
    }
    @OneToMany(mappedBy = "pointDeVente", cascade=CascadeType.PERSIST)
    @JsonManagedReference
    private List<EndUsers> endUsers;

    @OneToMany(mappedBy = "pointDeVente",cascade=CascadeType.PERSIST)
    @JsonManagedReference
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


    public PointDeVente(Integer id, Set<Role> roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        super(id, roles, nom, prenom, email, address, localisation, numTel, password);
    }

    @Override
    public String toString() {
        return "PointDeVente{" +
                "endUsers=" + endUsers +
                ", produits=" + produits +
                '}';
    }
}

