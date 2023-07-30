package com.example.demo.service;

import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {
    List<Users> findAllUsers();

    Users saveUser(Users usersDto);

    Optional<Users> findByLogin(String email);
    Users findById(Integer id);
    Users findByRole(String role);

    Optional<Users> findByEmail(String email);
    Users getUserByNameAndPassword(String name, String password) throws AdminNotFoundException;
}
