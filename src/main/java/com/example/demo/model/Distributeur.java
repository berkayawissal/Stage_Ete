package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Distributeur extends Users{
    @OneToMany(mappedBy = "distributeurs", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Produit> produits;

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }


    public Distributeur(Integer id, ERoles roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        super(id, roles, nom, prenom, email, address, localisation, numTel, password);

    }
}
