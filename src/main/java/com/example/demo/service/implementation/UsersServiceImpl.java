package com.example.demo.service.implementation;

import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;
    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Users> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    @Override
    public Optional<Users> findByLogin(String email) {
        Optional<Users> user =repository.findByEmail(email);
        if (user!= null) {
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public Users findById(Integer id) {
        Optional<Users> users =repository.findById(id);
        return users.orElse(null);
    }

    @Override
    public Users findByRole(String roles) {
        Optional<Users> users =repository.findByRoles(roles);
        return users.orElse(null);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        Optional<Users> user =repository.findByEmail(email);
        if (user!= null) {
            return user;
        }
        else {
            return null;
        }
    }
    @Override
    public Users getUserByNameAndPassword(String name, String password) throws AdminNotFoundException{
        Users user = repository.findByUsernameAndPassword(name, password);
        if(user == null){
            throw new AdminNotFoundException("Invalid id and password");
        }
        return user;
    }

}
