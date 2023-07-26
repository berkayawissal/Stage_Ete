package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Users implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "role")
    private String role;
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
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @ManyToOne( cascade=CascadeType.PERSIST)
    @JoinColumn(name = "idAdmin")
    @JsonBackReference
    private Admin admin;

    public Users(String role, String nom, String prenom, String email, String address, String localisation, String numTel, String login, String password, Admin admin) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.localisation = localisation;
        this.numTel = numTel;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", localisation='" + localisation + '\'' +
                ", numTel='" + numTel + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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

