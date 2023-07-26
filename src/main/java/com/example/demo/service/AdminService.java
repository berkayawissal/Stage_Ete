package com.example.demo.service;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {

    List<AdminDto> findAllAdmins();

    AdminDto saveAdmin(AdminDto dto);

    AdminDto findById(Integer idAdmin);

    //Object updateAdminbyId(Integer id, Admin admin);

}

