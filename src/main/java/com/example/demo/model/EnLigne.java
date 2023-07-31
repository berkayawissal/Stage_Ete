package com.example.demo.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class EnLigne extends PointDeVente{
    private String siteWeb;
   public EnLigne (){

   }

    @Override
    public String toString() {
        return "EnLigne{" +
                "siteWeb='" + siteWeb + '\'' +
                '}';
    }



    public EnLigne(String siteWeb) {
        this.siteWeb = siteWeb;
    }


    public EnLigne(Integer id, Set<Role> roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        super(id, roles, nom, prenom, email, address, localisation, numTel, password);
    }
}
