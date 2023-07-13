package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.EnLigne;
import com.example.demo.repository.EnLigneRepository;
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
class EnLigneServiceImplTest {
    private EnLigneServiceImpl underTest;

    @Mock
    private EnLigneRepository repository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new EnLigneServiceImpl(repository);

    }

    @Test
    void findAllEnLignes() {
        List<EnLigne> list = List.of(new EnLigne(), new EnLigne());
        when(repository.findAll()).thenReturn(list);
        assertEquals(2,  underTest.findAllEnLignes().size());
    }
}