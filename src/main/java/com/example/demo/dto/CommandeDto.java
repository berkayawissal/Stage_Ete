package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Jacksonized
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeDto {
    private Integer idCommande;
    private double total;
    private EtatCommande etat;
    private Date createdDate;
    private LocalDate dateLivree;
    private LocalDate dateRamassee;
    private LocalTime tempsLivree;
    private String description;

    private EndUsers endUser;
    private Livreur livreurs;

    @JsonIgnore
    private List<Produit> produits;

    public static  CommandeDto fromEntity (Commande commande){
        if (commande== null){
            return null;
        }
        return  CommandeDto.builder()
                .idCommande(commande.getIdCommande())
                .total(commande.getTotal())
                .createdDate(commande.getCreatedDate())
                .dateLivree(commande.getDateLivree())
                .dateRamassee(commande.getDateRamassee())
                .tempsLivree(commande.getTempsLivree())
                .etat(commande.getEtat())
                .endUser(commande.getEndUser())
                .livreurs(commande.getLivreurs())
                .description(commande.getDescription())
                .build();
    }

    public static Commande toEntity (CommandeDto dto){
        if (dto == null) {
            return null;
        }

        return Commande.builder()
                .total(dto.getTotal())
                .etat(dto.getEtat())
                .endUser(dto.getEndUser())
                .livreurs(dto.getLivreurs())
                .description(dto.getDescription())
                .build();
    }

}
