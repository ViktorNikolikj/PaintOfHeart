package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.*;

import java.util.Date;
import java.util.List;

public interface TicketService {
    List<Ticket> allEvents();
    Ticket create(Integer price, Date date, String location, String eventType, Seat seat, Cart cart);
    Ticket update(int id, Integer price, Date date, String location, String eventType, Seat seat, Cart cart);
    Ticket delete(int id);
    Ticket findById(int id);
    Ticket findByCart(Cart cart);
}
