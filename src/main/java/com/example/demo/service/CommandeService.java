package com.example.demo.service;

import com.example.demo.model.Commande;
import com.example.demo.model.EtatCommande;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface CommandeService {
    List<Commande> findAllCommandes();

    Commande saveCommande(Commande dto);

    Optional<Commande> findCommandeById(Integer idCommande);

    Optional<Commande> findCommandeByEtat(EtatCommande etat);

    List<Integer> getDeliveredCommand(EtatCommande etat, LocalDate startDate, LocalDate endDate);
}
