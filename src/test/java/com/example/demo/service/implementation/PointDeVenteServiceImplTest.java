package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.PointDeVente;
import com.example.demo.repository.PointDeVenteRepository;
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
class PointDeVenteServiceImplTest {
    private PointDeVenteServiceImpl underTest;
    @Mock
    private PointDeVenteRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new PointDeVenteServiceImpl(repository);

    }

    @Test
    void findAllPointDeVentes() {
        List<PointDeVente> pointDeVentes = List.of(new PointDeVente(), new PointDeVente());
        when(repository.findAll()).thenReturn(pointDeVentes);
        assertEquals(2,  underTest.findAllPointDeVentes().size());
    }
}