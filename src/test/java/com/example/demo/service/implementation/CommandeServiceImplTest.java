package com.example.demo.service.implementation;

import com.example.demo.model.Commande;
import com.example.demo.model.EtatCommande;
import com.example.demo.repository.CommandeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommandeServiceImplTest {
    private  CommandeServiceImpl underTest;
    @Mock
    private CommandeRepository repository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new CommandeServiceImpl(repository);
    }

    @Test
    void findAllCommandes() {
        List<Commande> commandes = List.of(new Commande( 12220, EtatCommande.DEBUT, "commande livree"), new Commande(13320, EtatCommande.LIVREE, "commande ramassee"));
        when(repository.findAll()).thenReturn(commandes);
        assertEquals(2,  underTest.findAllCommandes().size());

    }


    @Test
    void saveCommande() {

            Commande commande = new Commande( 12220, EtatCommande.LIVREE, "commande livree");
            underTest.saveCommande(commande);
            ArgumentCaptor<Commande> commandeArgumentCaptor = ArgumentCaptor.forClass(Commande.class);
            verify(repository).save(commandeArgumentCaptor.capture());
            Commande capturedCommande = commandeArgumentCaptor.getValue();
            assertThat(capturedCommande).isEqualTo(commande);
    }


    @Test
    void findCommandeByEtatAndDateBetween() {
        Commande commande = new Commande( 12220, EtatCommande.LIVREE, "commande LIVREE");
        Commande commande1 = new Commande(512, EtatCommande.RAMASSEE, "commande RAMASSEE");
        Commande commande2 = new Commande(3654, EtatCommande.DEBUT, "commande DEBUT");

        LocalDate startDate = LocalDate.of(2023, 7, 1);
        LocalDate endDate = LocalDate.of(2023, 7, 8);
        //liste(commande1,commande2)->Optional
       when(repository.findByEtatDateBetween(startDate, endDate)).thenReturn(Optional.of(commande));

        List<Integer> result = underTest.getDeliveredCommand(EtatCommande.valueOf("LIVREE"),startDate, endDate);

        assertEquals(1, result.size());
    }

    @Test
    void findCommandeByEtat() {
        Commande commande = new Commande( 12220, EtatCommande.LIVREE, "commande LIVREE");
        when(repository.findByEtat(EtatCommande.LIVREE)).thenReturn(Optional.of((commande)));
        assertEquals(Optional.of(commande), underTest.findCommandeByEtat(commande.getEtat()));
    }
}
