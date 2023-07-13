package com.example.demo.controller;


import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }
    @PostMapping
    public Users saveUser(@Valid @RequestBody Users users) {
        LOGGER.info("saved");
        return (Users) service.saveUser(users);
    }
    @GetMapping("/allUsers")
    public List<Users> findAllUsers(){
        return service.findAllUsers();
    }

}

