package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Produit;
import com.example.demo.service.AdminService;
import com.example.demo.service.ProduitService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @PostMapping
    public Produit saveProduit(@Valid @RequestBody Produit produit) {
        LOGGER.info("saved");
        return (Produit) service.saveProduit(produit);
    }
    @GetMapping("/produit")
    public List<Produit> findAllProduits (){
        return service.findAllProduits();
    }
}

