package com.example.demo.service;

import com.example.demo.dto.CommandeDto;
import com.example.demo.model.Commande;
import com.example.demo.model.EtatCommande;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface CommandeService {
    List<CommandeDto> findAllCommandes();

    CommandeDto saveCommande(CommandeDto dto);

    Optional<CommandeDto> findCommandeById(Integer idCommande);

    Optional<CommandeDto> findCommandeByEtat(EtatCommande etat);

    List<Integer> getDeliveredCommand(EtatCommande etat, LocalDate startDate, LocalDate endDate);
}
