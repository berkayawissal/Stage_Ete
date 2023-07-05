package com.example.demo.repository;

import com.example.demo.model.Physique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysiqueRepository extends JpaRepository<Physique, Integer> {
}
