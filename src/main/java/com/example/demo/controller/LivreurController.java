package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Livreur;
import com.example.demo.service.LivreurService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/livreurs")
public class LivreurController {

    private final LivreurService service;

    public LivreurController(LivreurService service) {
        this.service = service;
    }
    @PostMapping
    public Livreur saveLivreur(@Valid @RequestBody Livreur livreur) {
        LOGGER.info("saved");
        return (Livreur) service.saveLivreur(livreur);
    }
    @GetMapping("/livreurs")
    public List<Livreur> findAllLivreurs (){
        return service.findAllLivreurs();
    }
}
