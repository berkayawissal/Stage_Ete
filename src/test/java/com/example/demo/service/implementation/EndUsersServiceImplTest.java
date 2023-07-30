package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.ERoles;
import com.example.demo.model.EndUsers;
import com.example.demo.model.Role;
import com.example.demo.repository.EndUsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<EndUsers> endUsers = List.of(new EndUsers(1, new HashSet<>(Collections.singleton(new Role(ERoles.END_USER))), "nomEndUser","prenomEndUser","email@EndUser","addressEndUser","localisationEndUser","numTelEndUser", "passwordEndUser"), new EndUsers(2,new HashSet<>(Collections.singleton(new Role(ERoles.END_USER))), "nomEndUser1","prenomEndUser1","email@EndUser1","addressEndUser1","localisationEndUser1","numTelEndUser1", "passwordEndUser1"));
        when(repository.findAll()).thenReturn(endUsers);
        assertEquals(2,  underTest.findAllEndUsers().size());
    }
}