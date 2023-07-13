package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.Distributeur;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DistributeurRepository;
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
class DistributeurServiceImplTest {
    private DistributeurServiceImpl underTest;

    @Mock
    private DistributeurRepository repository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new DistributeurServiceImpl(repository);

    }

    @Test
    void findAllDistributeurs() {
        //role, nom, prenom, email, address, localisation, numTel, login, password, admin
        List<Distributeur> admins = List.of(new Distributeur("Distributeur", "nomD","prenomD","email@distributeur","address","localisation","numTel", "login", "password", new Admin(10)), new Distributeur("Distributeur2", "nomD2","prenomD2","email@distributeur2","address2","localisation2","numTel2", "login2", "pass", new Admin(11)));
        when(repository.findAll()).thenReturn(admins);
        assertEquals(2,  underTest.findAllDistributeurs().size());
    }
}