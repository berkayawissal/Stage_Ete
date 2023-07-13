package com.example.demo.service.implementation;

import com.example.demo.model.EnLigne;
import com.example.demo.repository.EnLigneRepository;
import com.example.demo.service.EnLigneService;

import java.util.List;

public class EnLigneServiceImpl implements EnLigneService {

    private EnLigneRepository repository;

    public EnLigneServiceImpl(EnLigneRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<EnLigne> findAllEnLignes() {

            return repository.findAll();
    }

    @Override
    public Object saveEnLigne (EnLigne enLigne) {
            return repository.save(enLigne);
    }
}
