package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Admin;
import com.example.paintofheart.model.entities.Artist;
import com.example.paintofheart.model.exceptions.InvalidArtistIdException;
import com.example.paintofheart.repository.ArtistRepository;
import com.example.paintofheart.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public List<Artist> allArtists() {
        return this.artistRepository.findAll();
    }

    @Override
    public Artist create(String username, String email, String surname, String name, String phoneNumber, String password, String type, Admin admin) {
        return this.artistRepository.save(new Artist(username, email, surname, name, phoneNumber, password, type, admin));
    }

    @Override
    public Artist update(int id, String username, String email, String surname, String name, String phoneNumber, String password, String type, Admin admin) {
        Artist artist = this.artistRepository.findById(id).orElseThrow(() -> new InvalidArtistIdException());
        artist.setUsername(username);
        artist.setEmail(email);
        artist.setSurname(surname);
        artist.setName(name);
        artist.setPhoneNumber(phoneNumber);
        artist.setPassword(password);
        artist.setType(type);
        artist.setAdmin(admin);
        return this.artistRepository.save(artist);
    }

    @Override
    public Artist delete(int id) {
        Artist artist = this.artistRepository.findById(id).orElseThrow(() -> new InvalidArtistIdException());
        this.artistRepository.delete(artist);
        return artist;
    }

    @Override
    public Artist findById(int id) {
        return this.artistRepository.findById(id).orElseThrow(() -> new InvalidArtistIdException());
    }


}
