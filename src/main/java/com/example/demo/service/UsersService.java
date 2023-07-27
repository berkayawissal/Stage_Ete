package com.example.demo.service;

import com.example.demo.dto.UsersDto;
import com.example.demo.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<UsersDto> findAllUsers();

    UsersDto saveUser(UsersDto usersDto);

    UsersDto findByLogin(String email);
    UsersDto findById(Integer id);
    UsersDto findByRole(String role);

}
