package com.example.demo.service;

import com.example.demo.model.Distributeur;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DistributeurService {
    List<Distributeur> findAllDistributeurs();

    Object saveDistributeur(Distributeur distributeurEntity);
}
