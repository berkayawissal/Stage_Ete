package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.Physique;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.PhysiqueRepository;
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
class PhysiqueServiceImplTest {

    private PhysiqueServiceImpl underTest;

    @Mock
    private PhysiqueRepository repository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new PhysiqueServiceImpl(repository);
    }

    @Test
    void findAllPhysiques() {
        List<Physique> physiques = List.of(new Physique(),new Physique());
        when(repository.findAll()).thenReturn(physiques);
        assertEquals(2,  underTest.findAllPhysiques().size());
    }
}