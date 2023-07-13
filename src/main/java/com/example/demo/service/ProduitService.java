package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProduitService {
    List<Produit> findAllProduits();

    Object saveProduit(Produit produit);
}
