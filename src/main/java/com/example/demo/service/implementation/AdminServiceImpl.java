package com.example.demo.service.implementation;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AdminDto> findAllAdmins() {

       return repository.findAll().stream().map(AdminDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public AdminDto saveAdmin(AdminDto dto) {
        Admin admin= AdminDto.toEntity(dto);
        Admin adminSaved = repository.save(admin);
        return AdminDto.fromEntity(adminSaved);
    }

    @Override
    public AdminDto findById(Integer idAdmin) {
        Optional<Admin> optionalAdmin =repository.findById(idAdmin);
        if (optionalAdmin.isPresent()) {
            Admin admin=optionalAdmin.get();
            return AdminDto.fromEntity(admin);
        }
        else {
            return null;
        }
    }


}
