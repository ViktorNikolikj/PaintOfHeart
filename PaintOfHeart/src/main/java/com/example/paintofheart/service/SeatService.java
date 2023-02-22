package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Event;
import com.example.paintofheart.model.entities.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> allSeats();
    Seat create(Event event, Integer number);
    Seat update(int id,Event event, Integer number);
    Seat delete(int id);
    Seat findById(int id);
}
