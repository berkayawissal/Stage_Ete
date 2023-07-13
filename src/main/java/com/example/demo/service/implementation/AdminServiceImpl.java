package com.example.demo.service.implementation;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {
    private  AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Admin> findAllAdmins() {
        List<Admin> admins = repository.findAll();
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

}
