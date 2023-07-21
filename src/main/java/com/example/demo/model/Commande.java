package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
@EnableJpaAuditing
@Table(name="Commandes")
@Getter
@Setter
public class Commande {
public Commande()  {
}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommande;

    private double total;

    @Enumerated(EnumType.STRING)
    private EtatCommande etat;

    @Column(name = "createdDate", updatable = false)
    private Date createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        dateLivree = LocalDate.now();
        tempsLivree = LocalTime.now();
    }
    @Column(name = "dateLivree")
    private LocalDate dateLivree;

    @Column(name = "dateRamassee")
    private LocalDate dateRamassee;

    @Column(name = "tempsLivree")
    private LocalTime tempsLivree;

    private String description;

    @ManyToOne
    @JoinColumn(name = "idLivreur")
    private Livreur livreurs;

    @ManyToMany(mappedBy = "commandes")
    private List<Produit> produits;

    @ManyToOne
    @JoinColumn(name = "endUserId")
    private EndUsers endUser;



    public Commande(double total, EtatCommande etat, String description) {
        this.total = total;
        this.etat = etat;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", total=" + total +
                ", etat=" + etat +
                ", createdDate=" + createdDate +
                ", dateLivree=" + dateLivree +
                ", dateRamassee=" + dateRamassee +
                ", tempsLivree=" + tempsLivree +
                ", description='" + description + '\'' +
                ", livreurs=" + livreurs +
                ", produits=" + produits +
                ", endUser=" + endUser +
                '}';
    }
}
