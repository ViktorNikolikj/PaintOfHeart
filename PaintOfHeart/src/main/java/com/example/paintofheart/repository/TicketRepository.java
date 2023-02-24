package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Cart;
import com.example.paintofheart.model.entities.Customer;
import com.example.paintofheart.model.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findByCart(Cart cart);
    List<Ticket> findAllByCustomer(Customer customer);
}
