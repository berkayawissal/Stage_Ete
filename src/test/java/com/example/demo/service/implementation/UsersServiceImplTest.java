package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsersServiceImplTest {

    private UsersServiceImpl underTest;
    @Mock
    private UsersRepository repository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new UsersServiceImpl(repository);
    }

    @Test
    void findAllUsers() {
        List<Users> users = List.of(new Users() , new Users());
        when(repository.findAll()).thenReturn(users);
        assertEquals(2,  underTest.findAllUsers().size());
    }
}