package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Organizer;
import com.example.paintofheart.model.exceptions.InvalidAdminIdException;
import com.example.paintofheart.repository.OrganizerRepository;
import com.example.paintofheart.service.OrganizerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    public OrganizerServiceImpl(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    private final OrganizerRepository organizerRepository;

    @Override
    public List<Organizer> findAllAdmins() {
        return organizerRepository.findAll();
    }

    @Override
    public Organizer findById(int id) {
        return organizerRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
    }

    @Override
    public Organizer create(String username, String email, String surname, String name, String phoneNumber, String password) {
        Organizer organizer = new Organizer(username, email, surname, name, phoneNumber, password);
        return this.organizerRepository.save(organizer);
    }

    @Override
    public Organizer update(int id, String username, String email, String surname, String name, String phoneNumber, String password) {
        Organizer organizer = this.organizerRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
        organizer.setUsername(username);
        organizer.setEmail(email);
        organizer.setSurname(surname);
        organizer.setName(name);
        organizer.setPhoneNumber(phoneNumber);
        organizer.setPassword(password);
        return this.organizerRepository.save(organizer);
    }

    @Override
    public Organizer delete(int id) {
        Organizer organizer = this.organizerRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
        this.organizerRepository.delete(organizer);
        return organizer;
    }
}
