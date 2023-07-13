package com.example.demo.service;

import com.example.demo.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<Users> findAllUsers();

    Object saveUser(Users users);
}
