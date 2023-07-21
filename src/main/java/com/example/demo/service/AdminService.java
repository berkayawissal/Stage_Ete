package com.example.demo.service;

import com.example.demo.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {

    List<Admin> findAllAdmins();

    Object saveAdmin(Admin adminEntity);

    Admin findById(Integer idAdmin);

    //Object updateAdminbyId(Integer id, Admin admin);

}

