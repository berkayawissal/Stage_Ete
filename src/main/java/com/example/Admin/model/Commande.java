package com.example.Admin.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Commande {

    public Commande(Date date, double total, String etat, String description, PointDeVente pointDeVente, Livreur livreur, EndUser endUser) {
        this.date = date;
        this.total = total;
        this.etat = etat;
        this.description = description;
        this.pointDeVente = pointDeVente;
        this.livreur = livreur;
        this.endUser = endUser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private double total;
    private String etat;
    private String description;

    @ManyToOne
    private PointDeVente pointDeVente;

    @ManyToOne
    private Livreur livreur;

    @ManyToOne
    @JoinColumn(name = "endUserId")
    private EndUser endUser;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public PointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(PointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
