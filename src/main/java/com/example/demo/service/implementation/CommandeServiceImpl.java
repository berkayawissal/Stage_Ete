package com.example.demo.service.implementation;

import com.example.demo.model.Commande;
import com.example.demo.model.EtatCommande;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.service.CommandeService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CommandeServiceImpl implements CommandeService {
    private CommandeRepository repository;

    public CommandeServiceImpl(CommandeRepository repository) {
        this.repository=repository;
    }

    public CommandeServiceImpl() {
    }

    @Override
    public List<Commande> findAllCommandes() {
        return repository.findAll();
    }

    @Override
    public Commande saveCommande(Commande commande) {
        return repository.save(commande);
    }

    @Override
    public Optional<Commande> findCommandeById(Integer idCommande) {
        Optional<Commande> commandes = repository.findById(idCommande);
        return commandes.map(Optional::of).orElse(null);
    }
    @Override
    public Optional<Commande> findCommandeByEtat(EtatCommande etat) {
        Optional<Commande> commnades = repository.findByEtat(EtatCommande.LIVREE);
        if (commnades.isPresent()){
            return Optional.ofNullable(commnades.orElseThrow(() -> new RuntimeException("no delivered command found")));
    } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Integer> getDeliveredCommand(EtatCommande etat , LocalDate startDate, LocalDate endDate) {
        Optional<Commande> deliveredCommands = repository.findByEtatDateBetween(startDate, endDate);
       // if (deliveredCommands.isPresent()){}
        return deliveredCommands.stream()
                .filter(a->a.getEtat()==EtatCommande.LIVREE)
                .map(Commande::getIdCommande)
                .collect(Collectors.toList());
    }



}
