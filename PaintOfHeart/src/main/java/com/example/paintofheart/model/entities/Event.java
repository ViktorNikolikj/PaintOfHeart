package com.example.paintofheart.model.entities;

import jakarta.persistence.*;
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
@Table(name = "events", schema = "project")
@Inheritance(strategy = InheritanceType.JOINED)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_event")
    Integer id;

    @Column(name="name", nullable = false, length = 50)
    String name;

    @Column(name="price", nullable = false)
    Integer price;

    @Column(name="city", nullable = false, length = 50)
    String city;

    @Column(name="date", nullable = false)
    Date date;

    @Column(name="phone_number", nullable = false, length = 20)
    String phoneNumber;

    @ManyToOne
    @JoinColumn(name="id_user_artist")
    Artist artist;

    @ManyToOne
    @JoinColumn(name="id_user_organizer")
    Organizer organizer;


    public Event(String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer) {
        this.name = name;
        this.price = price;
        this.city = city;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.artist = artist;
        this.organizer = organizer;
    }

    public String getLocationAndDate(){
        return String.format("%s - %s", this.city, this.date.toString());
    }

}
