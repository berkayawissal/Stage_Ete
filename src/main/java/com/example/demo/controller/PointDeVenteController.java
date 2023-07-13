package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.PointDeVente;
import com.example.demo.service.AdminService;
import com.example.demo.service.PointDeVenteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/pointDeVente")
public class PointDeVenteController {

    private final PointDeVenteService service;

    public PointDeVenteController(PointDeVenteService service) {
        this.service = service;
    }
    @PostMapping
    public PointDeVente savePointDeVente(@Valid @RequestBody PointDeVente pointDeVente) {
        LOGGER.info("saved");
        return (PointDeVente) service.savePointDeVente(pointDeVente);
    }
    @GetMapping("/pointDeVentes")
    public List<PointDeVente> findAllAdmins (){
        return service.findAllPointDeVentes();
    }
}
