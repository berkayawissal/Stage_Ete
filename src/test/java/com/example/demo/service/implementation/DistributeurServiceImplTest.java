package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.Distributeur;
import com.example.demo.model.ERoles;
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

import static com.example.demo.model.ERoles.DISTRIBUTEUR;
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
        List<Distributeur> admins = List.of(new Distributeur(), new Distributeur());
        when(repository.findAll()).thenReturn(admins);
        assertEquals(2,  underTest.findAllDistributeurs().size());
    }
}/*(Integer id, ERoles roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        super(id, roles, nom, prenom, email, address, localisation, numTel, password);*/
//1, DISTRIBUTEUR, "nomD","prenomD","email@distributeur","address","localisation","numTel", "password"
//2, DISTRIBUTEUR,"prenomD2","email@distributeur2","address2","localisation2","numTel2", "1212", "pass"