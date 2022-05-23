package com.example.tutorial_jwt.repository;

import java.util.Optional;

import com.example.tutorial_jwt.models.ERole;
import com.example.tutorial_jwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}