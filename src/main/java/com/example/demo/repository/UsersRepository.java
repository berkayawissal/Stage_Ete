package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional <Users> findByEmail (String email);
    Users findByUsernameAndPassword(String username, String password);

    Optional<Users> findByRoles(String roles);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

}
