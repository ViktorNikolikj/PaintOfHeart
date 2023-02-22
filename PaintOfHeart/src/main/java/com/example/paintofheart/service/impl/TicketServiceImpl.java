package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Cart;
import com.example.paintofheart.model.entities.Seat;
import com.example.paintofheart.model.entities.Ticket;
import com.example.paintofheart.model.exceptions.InvalidTicketIdException;
import com.example.paintofheart.repository.TicketRepository;
import com.example.paintofheart.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> allEvents() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Ticket create(Integer price, Date date, String location, String eventType, Seat seat, Cart cart) {
        Ticket ticket = new Ticket(price, date, location, eventType, seat, cart);
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(int id, Integer price, Date date, String location, String eventType, Seat seat, Cart cart) {
       Ticket ticket = this.ticketRepository.findById(id).orElseThrow(() -> new InvalidTicketIdException());
        ticket.setPrice(price);
        ticket.setDate(date);
        ticket.setLocation(location);
        ticket.setEventType(eventType);
        ticket.setSeat(seat);
        ticket.setCart(cart);
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Ticket delete(int id) {
        Ticket ticket = this.ticketRepository.findById(id).orElseThrow(() -> new InvalidTicketIdException());
        this.ticketRepository.delete(ticket);
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
        return this.ticketRepository.findById(id).orElseThrow(() -> new InvalidTicketIdException());
    }

    @Override
    public Ticket findByCart(Cart cart) {
        return this.ticketRepository.findByCart(cart);
    }
}
