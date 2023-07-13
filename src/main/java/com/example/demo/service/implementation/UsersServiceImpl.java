package com.example.demo.service.implementation;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {
    private UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Users> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public Object saveUser(Users users) {
        return repository.save(users);
    }
}
