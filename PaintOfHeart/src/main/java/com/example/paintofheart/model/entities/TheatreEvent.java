package com.example.paintofheart.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "theatre", schema = "project")
@PrimaryKeyJoinColumn(name = "id_event")
public class TheatreEvent extends Event{

    @Column(name="director", nullable = false, length = 50)
    String director;

    @Column(name="genre", nullable = false, length = 50)
    String genre;

    @Column(name="duration", nullable = false)
    Integer duration;

    public TheatreEvent(String director, String genre, Integer duration) {
        this.director = director;
        this.genre = genre;
        this.duration = duration;
    }

    public TheatreEvent(String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer, String director, String genre, Integer duration) {
        super(name, price, city, date, phoneNumber, artist, organizer);
        this.director = director;
        this.genre = genre;
        this.duration = duration;
    }
}
