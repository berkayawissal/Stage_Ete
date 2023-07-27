package com.example.demo.controller;


import com.example.demo.dto.AdminDto;
import com.example.demo.dto.UsersDto;
import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.service.AdminService;
import com.example.demo.service.UsersService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userses")
public class UsersController {
    private final UsersService service;
    private final AdminService adminService;

    public UsersController(UsersService service, AdminService adminService) {
        this.service = service;
        this.adminService = adminService;
    }
    @PostMapping("/save")
    @RolesAllowed("ADMIN")
    public UsersDto saveUser(@RequestBody UsersDto usersDto) {

        return service.saveUser(usersDto);
    }
    @GetMapping("/allUsers")
    public List<UsersDto> findAllUsers(){
        return service.findAllUsers();
    }
    @GetMapping("/findByLogin/{email}")
    public UsersDto findByLogin(@PathVariable String email) {
        return service.findByLogin(email);
    }
    @GetMapping("/findById/{id}")
    public UsersDto findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @GetMapping("/findByRole/{role}")
    public UsersDto findByRole(@PathVariable String role) {
        return service.findByRole(role);
    }
}

