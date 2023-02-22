package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(int customerId);
    List<Customer> findAllAdmins();
    Customer create(String username, String email, String surname, String name, String phoneNumber, String password, String transactionAccount);
    Customer update(int id,String username, String email, String surname, String name, String phoneNumber, String password, String transactionAccount);
    Customer delete(int id);
}
