package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Admin> findAllAdmins() {
        List<Admin> admins = (List<Admin>) repository.findAll();
        return admins;
    }

    @Override
    public Admin saveAdmin(Admin adminEntity) {
        return repository.save(adminEntity);
    }

//    @Override
//    public Admin updateAdminbyId(Integer id, Admin admin) {
//        return (Admin) repository.updateAdmin(admin);
//    }
    @Override
    public Admin findById(Integer idAdmin) {
        return repository.findById(idAdmin).orElse(null);
    }


}
