package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
