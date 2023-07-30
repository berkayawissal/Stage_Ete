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

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "nom")
    private String username;
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

    public Users( String nom, String prenom, String email, String address, String localisation, String numTel, String password) {

        this.username = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.localisation = localisation;
        this.numTel = numTel;
        this.password = password;
    }



    public Users(String nom,String email, String password) {
        this.username = nom;
        this.email=email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id + '\'' +
                ", nom='" + username + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", localisation='" + localisation + '\'' +
                ", numTel='" + numTel + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getName()))
                .collect(Collectors.toList());
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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

