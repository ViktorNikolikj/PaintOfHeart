package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Admin;
import com.example.paintofheart.model.entities.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> allArtists();
    Artist create(String username, String email, String surname, String name, String phoneNumber,String password, String type, Admin admin);
    Artist update(int id, String username, String email, String surname, String name, String phoneNumber,String password, String type, Admin admin);
    Artist delete(int id);
    Artist findById(int id);
}
