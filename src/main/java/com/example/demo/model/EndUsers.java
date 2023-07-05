package com.example.demo.model;


import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "end_users")
public class EndUsers extends Users {
public EndUsers(){

}
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "point_de_vente_id")
    private PointDeVente pointDeVente;
    @OneToMany(mappedBy = "endUser")
    private List<Commande> commandes;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public EndUsers(String role, String nom, String prenom, String email, String address, String type, String numTel, String username, String password, PointDeVente pointDeVente, List<Commande> commandes) {
        super(role, nom, prenom, email, address, type, numTel);
        this.username = username;
        this.password = password;
//        this.pointDeVente = pointDeVente;
//        this.commandes = commandes;
    }

    public EndUsers(String role, String nom, String prenom, String email, String address, String type, String numTel) {
        super(role, nom, prenom, email, address, type, numTel);
    }
}

