package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.PointDeVente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointDeVenteService {
    List<PointDeVente> findAllPointDeVentes();

    Object savePointDeVente(PointDeVente pointDeVente);
}
