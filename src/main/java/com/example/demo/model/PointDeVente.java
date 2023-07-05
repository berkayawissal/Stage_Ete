package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
public class PointDeVente extends Users {
    public PointDeVente(String role, String nom, String prenom, String email, String address, String type, String numTel, List<EndUsers> endUsers, List<Produit> produits, List<Commande> commandes, List<ChaineDeDistribution> chaineDeDistributions) {
        super(role, nom, prenom, email, address, type, numTel);
        this.endUsers = endUsers;
        this.produits = produits;
        this.commandes = commandes;
        this.chaineDeDistributions = chaineDeDistributions;
    }

    @OneToMany(mappedBy = "pointDeVente")
    private List<EndUsers> endUsers;


public PointDeVente() {
}


    @OneToMany(mappedBy = "pointDeVente")
    private List<Produit> produits;
    @OneToMany(mappedBy="pointDeVente", targetEntity = Commande.class,
            fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Commande> commandes;


    @ManyToMany
    @JoinTable(
            name = "pointDeVente_CDD",
            joinColumns = @JoinColumn(name = "pointDeVenteId"),
            inverseJoinColumns = @JoinColumn(name = "CddId")
    )
    private List<ChaineDeDistribution> chaineDeDistributions;

//    Getter - Setter

    public List<ChaineDeDistribution> getChaineDeDistributions() {
        return chaineDeDistributions;
    }

    public void setChaineDeDistributions(List<ChaineDeDistribution> chaineDeDistributions) {
        this.chaineDeDistributions = chaineDeDistributions;
    }

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

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
  }

}

