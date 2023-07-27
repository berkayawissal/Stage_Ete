package com.example.demo.repository;

import com.example.demo.dto.UsersDto;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail (String email);

    Optional<Users> findByRoles(String roles);
}
