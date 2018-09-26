package com.example.springdiary.repository;

import com.example.springdiary.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Owner, Long>{

    Owner findByUsername(String username);
}
