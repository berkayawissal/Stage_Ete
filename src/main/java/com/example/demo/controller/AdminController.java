package com.example.demo.controller;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public AdminDto saveAdmin(@RequestBody AdminDto admin) {
        System.out.println("saved");
        return (AdminDto) service.saveAdmin(admin);
    }
    @GetMapping("/AllAdmins")
    public List <AdminDto> findAllAdmins (){
        return service.findAllAdmins();
    }

//    @PutMapping("update/{id}")
//    public Admin updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
//        admin.setLogin(admin.getLogin());
//        admin.setRole(admin.getRole());
//        admin.setPassword(admin.getRole());
//        return (Admin) service.updateAdminbyId(id, admin);
//    }
}


