package com.example.demo.service.implementation;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.UsersDto;
import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;
    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsersDto> findAllUsers() {
        return repository.findAll().stream().map(UsersDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        Users user=UsersDto.toEntity(usersDto);
        Users userSaved = repository.save(user);
        return UsersDto.fromEntity(userSaved);
    }

    @Override
    public UsersDto findByLogin(String email) {
        Optional<Users> users =repository.findByEmail(email);
        if (users.isPresent()) {
            Users user=users.get();
            return UsersDto.fromEntity(user);
        }
        else {
            return null;
        }
    }

    @Override
    public UsersDto findById(Integer id) {
        Optional<Users> users =repository.findById(id);
        if (users.isPresent()) {
            Users user=users.get();
            return UsersDto.fromEntity(user);
        }
        else {
            return null;
        }
    }

    @Override
    public UsersDto findByRole(String roles) {
        Optional<Users> users =repository.findByRoles(roles);
        if (users.isPresent()) {
            Users user=users.get();
            return UsersDto.fromEntity(user);
        }
        else {
            return null;
        }
    }

}
