package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.EndUsers;
import com.example.demo.repository.EndUsersRepository;
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
class EndUsersServiceImplTest {

    private EndUsersServiceImpl underTest;
    @Mock
    private EndUsersRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new EndUsersServiceImpl(repository);

    }

    @Test
    void findAllEndUsers() {
        List<EndUsers> endUsers = List.of(new EndUsers("EndUser", "nomEndUser","prenomEndUser","email@EndUser","addressEndUser","localisationEndUser","numTelEndUser", "loginEndUser", "passwordEndUser", new Admin(10)), new EndUsers("EndUser", "nomEndUser1","prenomEndUser1","email@EndUser1","addressEndUser1","localisationEndUser1","numTelEndUser1", "loginEndUser1", "passwordEndUser1", new Admin(11)));
        when(repository.findAll()).thenReturn(endUsers);
        assertEquals(2,  underTest.findAllEndUsers().size());
    }
}