package com.example.demo.model;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames = "email")})
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(name = "role")
    private ERoles roles ;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "localisation")
    private String localisation;
    @Column(name = "numTel")
    private String numTel;
    @Column(name = "password")
    private String password;

    public Users(ERoles roles, String nom, String prenom, String email, String address, String localisation, String numTel, String password) {
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.localisation = localisation;
        this.numTel = numTel;
        this.password = password;
    }



    public Users(String nom,String email, String password) {
        this.nom = nom;
        this.email=email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", localisation='" + localisation + '\'' +
                ", numTel='" + numTel + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public ERoles getRoles() {
        return roles;
    }

    public void setRoles(ERoles roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roles.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

