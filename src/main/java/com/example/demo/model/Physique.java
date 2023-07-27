package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Physique extends PointDeVente{
    public Physique(){

    }



    public Physique(Integer id, ERoles roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        super(id, roles, nom, prenom, email, address, localisation, numTel, password);
    }

}
