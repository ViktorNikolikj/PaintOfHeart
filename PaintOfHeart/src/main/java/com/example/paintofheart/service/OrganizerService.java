package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Organizer;

import java.util.List;

public interface OrganizerService {
    List<Organizer> findAllAdmins();
    Organizer findById(int id);
    Organizer create(String username, String email, String surname, String name, String phoneNumber, String password);
    Organizer update(int id,String username, String email, String surname, String name, String phoneNumber, String password);
    Organizer delete(int id);
}
