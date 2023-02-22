package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Artist;
import com.example.paintofheart.model.entities.Event;
import com.example.paintofheart.model.entities.Organizer;
import com.example.paintofheart.model.exceptions.InvalidEventIdException;
import com.example.paintofheart.repository.EventRepository;
import com.example.paintofheart.service.EventService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> allEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new InvalidEventIdException());
    }

    @Override
    public Event create(String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer) {
        Event event = new Event(name, price, city, date, phoneNumber, artist, organizer);
        return this.eventRepository.save(event);
    }

    @Override
    public Event update(int id, String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer) {
        Event event = this.eventRepository.findById(id).orElseThrow(() -> new InvalidEventIdException());
        event.setName(name);
        event.setPrice(price);
        event.setCity(city);
        event.setDate(date);
        event.setPhoneNumber(phoneNumber);
        event.setArtist(artist);
        event.setOrganizer(organizer);
        return this.eventRepository.save(event);
    }

    @Override
    public Event delete(int id) {
        Event event = this.eventRepository.findById(id).orElseThrow(() -> new InvalidEventIdException());
        this.eventRepository.delete(event);
        return event;
    }
}
