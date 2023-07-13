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
    public Object saveCommande(Commande commandeEntity) {
        return repository.save(commandeEntity);
    }

    @Override
    public Optional<Commande> findCommandeById(Integer idCommande) {
        return repository.findById(idCommande);
    }

    @Override
    public Optional<Commande> findCommandeByEtat(EtatCommande etat) {
        return Optional.ofNullable(repository.findByEtat(EtatCommande.LIVREE).orElseThrow(() -> new RuntimeException("no delivered command found")));
    }

    @Override
    public List<Integer> getDeliveredCommand(EtatCommande etat , LocalDate startDate, LocalDate endDate) {
        List<Commande> deliveredCommands = repository.findByEtatDateBetween(startDate, endDate);

        return deliveredCommands.stream()
                .filter(a->a.getEtat()==EtatCommande.LIVREE)
                .map(a->a.getIdCommande())
                .collect(Collectors.toList());
    }



}
