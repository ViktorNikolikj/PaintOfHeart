package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Artist;
import com.example.paintofheart.model.entities.Event;
import com.example.paintofheart.model.entities.Organizer;

import java.util.Date;
import java.util.List;

public interface EventService {
    List<Event> allEvents();
    Event create(String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer);
    Event update(int id, String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer);
    Event delete(int id);
    Event findById(int id);
}
