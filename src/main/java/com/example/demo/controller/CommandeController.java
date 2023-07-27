package com.example.demo.controller;

import com.example.demo.dto.CommandeDto;
import com.example.demo.model.Commande;
import com.example.demo.model.EtatCommande;
import com.example.demo.service.CommandeService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    private final CommandeService service;

    public CommandeController(CommandeService service) {
        this.service = service;
    }
    @PostMapping
    public CommandeDto saveCommande (@Valid @RequestBody Commande commande){
        System.out.println("saved");
        return (CommandeDto) service.saveCommande(CommandeDto.fromEntity(commande));
    }
    @GetMapping("/commandes")
    public List<CommandeDto> findAllCommandes(){
        return service.findAllCommandes();
    }

    @GetMapping("/{id}")
    public Optional<CommandeDto> findCommandeById (@PathVariable(value = "idCommande") Integer idCommande){
        return  service.findCommandeById(idCommande);
    }
    @GetMapping("/{etat}")
    public Optional<CommandeDto> findCommandeByEtat(@PathVariable(value = "etat") EtatCommande etat){
        return service.findCommandeByEtat(etat);
    }

    @GetMapping("/livrees")
    public List<Integer> getDeliveredCommandId(@RequestParam("startDate") LocalDate startDate,
                                               @RequestParam("endDate") LocalDate endDate,
                                               @RequestParam("etat") EtatCommande etat) {
        return service.getDeliveredCommand(etat , startDate, endDate);
    }
}
