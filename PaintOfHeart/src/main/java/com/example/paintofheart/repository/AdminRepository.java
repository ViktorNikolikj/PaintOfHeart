package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
