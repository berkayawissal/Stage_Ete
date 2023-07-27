package com.example.demo.service.implementation;

import com.example.demo.dto.CommandeDto;
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
    public List<CommandeDto> findAllCommandes() {
        return repository.findAll().stream().map(CommandeDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public CommandeDto saveCommande(CommandeDto dto) {
        Commande commande = CommandeDto.toEntity(dto);
        Commande commandeSaved= repository.save(commande);
        return CommandeDto.fromEntity(commandeSaved);
    }

    @Override
    public Optional<CommandeDto> findCommandeById(Integer idCommande) {
        Optional<Commande> commandes = repository.findById(idCommande);
        if (commandes.isPresent()) {
            Commande commande = commandes.get();
            return Optional.ofNullable(CommandeDto.fromEntity(commande));
        }
        else {
            return null;
        }
    }
    @Override
    public Optional<CommandeDto> findCommandeByEtat(EtatCommande etat) {
        Optional<Commande> commnades = repository.findByEtat(EtatCommande.LIVREE);
        if (commnades.isPresent()){
            Commande commande= commnades.get();
            return Optional.ofNullable(Optional.ofNullable(CommandeDto.fromEntity(commande)).orElseThrow(() -> new RuntimeException("no delivered command found")));
    } else {
            return null;
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
