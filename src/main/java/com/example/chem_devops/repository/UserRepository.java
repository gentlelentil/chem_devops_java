package com.example.chem_devops.repository;

import com.example.chem_devops.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    //query by username
    Optional<User> findByUsername(String username);
}