package com.example.Admin.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PointDeVente extends User {
    public PointDeVente(String role, String nom, String prenom, String email, String address, String type, String numTel, List<EndUser> endUsers, List<Produit> produits, List<Commande> commandes, List<Livreur> livreurs) {
        super(role, nom, prenom, email, address, type, numTel);
        this.endUsers = endUsers;
        this.produits = produits;
        this.commandes = commandes;
        this.livreurs = livreurs;
    }

    @OneToMany(mappedBy = "pointDeVente")
    private List<EndUser> endUsers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "pointDeVente")
    private List<Produit> produits;

    @OneToMany(mappedBy = "pointDeVente")
    private List<Commande> commandes;

    @ManyToMany
    @JoinTable(
            name = "pointDeVente_livreurs",
            joinColumns = @JoinColumn(name = "pointDeVenteId"),
            inverseJoinColumns = @JoinColumn(name = "livreurId")
    )
    private List<Livreur> livreurs;

    //Getter - Setter

    public List<EndUser> getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(List<EndUser> endUsers) {
        this.endUsers = endUsers;
    }

    public Long getId() {
        return id;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Livreur> getLivreurs() {
        return livreurs;
    }

    public void setLivreurs(List<Livreur> livreurs) {
        this.livreurs = livreurs;
    }
}
