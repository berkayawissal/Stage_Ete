package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Physique;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhysiqueService {
    List<Physique> findAllPhysiques();

    Object savePhysique(Physique physique);
}
