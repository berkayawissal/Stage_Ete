package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;
    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Users> findAllUsers() {
        return (List<Users>) repository.findAll();
    }
AdminRepository adminRepository;
    @Override
    public Users saveUser(Users users) {
        Integer adminId = users.getAdmin().getIdAdmin();
        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + adminId));
        users.setAdmin(admin);
        return repository.save(users);
    }
}
