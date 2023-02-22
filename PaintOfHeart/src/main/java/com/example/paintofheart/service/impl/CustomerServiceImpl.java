package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Customer;
import com.example.paintofheart.model.exceptions.InvalidAdminIdException;
import com.example.paintofheart.model.exceptions.InvalidCustomerIdException;
import com.example.paintofheart.repository.CustomerRepository;
import com.example.paintofheart.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(int customerId) {
        return this.customerRepository.findById(customerId).orElseThrow(InvalidCustomerIdException::new);
    }

    @Override
    public List<Customer> findAllAdmins() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(String username, String email, String surname, String name, String phoneNumber, String password, String transaction) {
        Customer customer = new Customer(username, email, surname, name, phoneNumber, password, transaction);
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer update(int id, String username, String email, String surname, String name, String phoneNumber, String password, String transaction) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setSurname(surname);
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setPassword(password);
        customer.setTransactionAccount(transaction);
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer delete(int id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
        this.customerRepository.delete(customer);
        return customer;
    }
}
