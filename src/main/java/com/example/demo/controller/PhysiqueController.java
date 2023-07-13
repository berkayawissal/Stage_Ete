package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Physique;
import com.example.demo.service.PhysiqueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/physique")
public class PhysiqueController {
    private final PhysiqueService service;

    public PhysiqueController(PhysiqueService service) {
        this.service = service;
    }
    @PostMapping
    public Physique savePhysique(@Valid @RequestBody Physique physique) {
        LOGGER.info("saved");
        return (Physique) service.savePhysique(physique);
    }
    @GetMapping("/physiques")
    public List<Physique> findAllPhysiques (){
        return service.findAllPhysiques();
    }
}
