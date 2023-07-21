package com.example.demo.model;


import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "end_users")
public class EndUsers extends Users {
public EndUsers(){

}
    @ManyToOne( cascade=CascadeType.PERSIST)
    @JoinColumn(name = "point_de_vente_id")
    private PointDeVente pointDeVente;
    @OneToMany(mappedBy = "endUser",cascade=CascadeType.PERSIST)
    private List<Commande> commandes;
    @OneToMany(mappedBy = "endUsers", cascade = CascadeType.PERSIST)
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


    public EndUsers(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin) {
        super(role, nom, prenom, email, address, localisation, numTel, login, password, admin);
//        this.pointDeVente = pointDeVente;   , PointDeVente pointDeVente, List<Commande> commandes, List<Livreur> livreurs
//        this.commandes = commandes;
//        this.Livreurs = livreurs;
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

