package com.example.demo.controller;


import com.example.demo.model.Admin;
import com.example.demo.model.EnLigne;
import com.example.demo.service.EnLigneService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/enLigne")
public class EnligneController {
    private final EnLigneService service;


    public EnligneController(EnLigneService service) {
        this.service = service;
    }
    @PostMapping
    public EnLigne saveEnLigne(@Valid @RequestBody EnLigne enLigne) {
        LOGGER.info("saved");
        return (EnLigne) service.saveEnLigne(enLigne);
    }
    @GetMapping("/EnLignes")
    public List<EnLigne> findAllEnLignes (){
        return service.findAllEnLignes();
    }
}
