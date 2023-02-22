package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Cart;
import com.example.paintofheart.model.entities.Customer;

import java.util.List;

public interface CartService {
    List<Cart> allCarts();
    Cart create(Customer customer, Integer total);
    Cart update(int id,Customer customer, Integer total);
    Cart delete(int id);
    Cart findById(int id);
    Cart findByCustomer(Customer customer);
}
