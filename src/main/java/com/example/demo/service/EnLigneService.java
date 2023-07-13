package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.EnLigne;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EnLigneService {

    List<EnLigne> findAllEnLignes();

    Object saveEnLigne(EnLigne enLigne);
}
