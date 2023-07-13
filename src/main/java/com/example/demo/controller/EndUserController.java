package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.EndUsers;
import com.example.demo.service.EndUsersService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/endUsers")
public class EndUserController {
    private final EndUsersService service;

    public EndUserController(EndUsersService service) {
        this.service = service;
    }
    @PostMapping
    public EndUsers saveEndUser(@Valid @RequestBody EndUsers endUsers) {
        LOGGER.info("saved");
        return (EndUsers) service.saveEndUser(endUsers);
    }
    @GetMapping("/endUsers")
    public List<EndUsers> findAllEndUsers (){
        return service.findAllEndUsers();
    }
}
