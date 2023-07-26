package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue
    public Integer id;
    @Column(unique = true)
    public String token;
    public String tokenType = "Bearer ";
    public boolean revoked;
    public boolean expired;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public Users user;

}

