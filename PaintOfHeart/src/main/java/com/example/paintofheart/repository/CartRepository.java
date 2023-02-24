package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Cart;
//import com.example.paintofheart.model.entities.CartId;
import com.example.paintofheart.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByCartId(int id);
    Cart findByCustomer(Customer customer);
}
