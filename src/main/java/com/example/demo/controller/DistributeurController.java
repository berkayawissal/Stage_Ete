package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Distributeur;
import com.example.demo.service.AdminService;
import com.example.demo.service.DistributeurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/distributeurs")
public class DistributeurController {
    private final DistributeurService service;

    public DistributeurController(DistributeurService service) {
        this.service = service;
    }

    @PostMapping
    public Distributeur saveDistributeur(@Valid @RequestBody Distributeur distributeur) {
        LOGGER.info("saved");
        return (Distributeur) service.saveDistributeur(distributeur);
    }
    @GetMapping("/distributeurs")
    public List<Distributeur> findAllDistributeurs (){
        return service.findAllDistributeurs();
    }
}
