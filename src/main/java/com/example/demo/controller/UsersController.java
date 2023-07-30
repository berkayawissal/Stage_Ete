package com.example.demo.controller;


import com.example.demo.dao.AuthenticationRequest;
import com.example.demo.dao.AuthenticationResponse;
import com.example.demo.dao.RegistrationRequest;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.model.Users;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.UsersService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;
    private final AuthenticationService serviceAuth;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegistrationRequest request
    ) {
        return ResponseEntity.ok(serviceAuth.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(serviceAuth.authenticate(request));
    }

    /* @PostMapping("/save")
    public Users saveUser(@RequestBody Users users) {

        return service.saveUser(users);
    }*/
    @GetMapping("/allUsers")
    public List<Users> findAllUsers(){
        return service.findAllUsers();
    }
    @GetMapping("/findByLogin/{email}")
    public Optional<Users> findByLogin(@PathVariable String email) {
        return service.findByEmail(email);
    }
    @GetMapping("/findById/{id}")
    public Users findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @GetMapping("/findByRole/{role}")
    public Users findByRole(@PathVariable String role) {
        return service.findByRole(role);
    }
}

