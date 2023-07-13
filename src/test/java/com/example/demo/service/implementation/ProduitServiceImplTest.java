package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplTest {
        private ProduitServiceImpl underTest;
        @Mock
        private ProduitRepository repository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new ProduitServiceImpl(repository);
    }

    @Test
    void findAllProduits() {
        List<Produit> produits = List.of(new Produit(), new Produit());
        when(repository.findAll()).thenReturn(produits);
        assertEquals(2,  underTest.findAllProduits().size());
    }
}