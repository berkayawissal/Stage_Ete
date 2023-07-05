package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Commandes")
public class Commande {

    public Commande(Date date, double total, String etat, String description, PointDeVente pointDeVente, ChaineDeDistribution chaineDeDistribution, EndUsers endUser) {
        this.date = date;
        this.total = total;
        this.etat = etat;
        this.description = description;
        this.pointDeVente = pointDeVente;
        this.chaineDeDistribution = chaineDeDistribution;
        this.endUser = endUser;
    }
public Commande(){

}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommande;

    private Date date;
    private double total;
    private String etat;
    private String description;

    @ManyToOne(fetch=FetchType.EAGER, optional=true, cascade=CascadeType.ALL,targetEntity = PointDeVente.class)
    @JoinColumn(name = "idPointDeVente")
    private PointDeVente pointDeVente;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private ChaineDeDistribution chaineDeDistribution;

    @ManyToOne
    @JoinColumn(name = "endUserId")
    private EndUsers endUser;

    public Integer getIdCommande() {
        return idCommande;
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

    public ChaineDeDistribution getChaineDeDistribution() {
        return chaineDeDistribution;
    }

    public void setChaineDeDistribution(ChaineDeDistribution chaineDeDistribution) {
        this.chaineDeDistribution = chaineDeDistribution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EndUsers getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUsers endUser) {
        this.endUser = endUser;
    }
}
