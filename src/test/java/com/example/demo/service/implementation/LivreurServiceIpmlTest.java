package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.Livreur;
import com.example.demo.repository.LivreurRepository;
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
class LivreurServiceIpmlTest {
    private LivreurServiceIpml underTest;
    @Mock
    private LivreurRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new LivreurServiceIpml(repository);

    }

    @Test
    void findAllLivreurs() {
        List<Livreur> livreurs = List.of(new Livreur() , new Livreur());
        when(repository.findAll()).thenReturn(livreurs);
        assertEquals(2,  underTest.findAllLivreurs().size());
    }
}