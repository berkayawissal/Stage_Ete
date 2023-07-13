package com.example.demo.repository;

import com.example.demo.model.Distributeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributeurRepository extends JpaRepository<Distributeur, Integer> {
}
