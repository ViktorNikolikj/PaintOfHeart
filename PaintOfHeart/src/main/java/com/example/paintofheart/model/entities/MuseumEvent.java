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
@Table(name = "museum", schema = "project")
@PrimaryKeyJoinColumn(name = "id_event")
public class MuseumEvent extends Event{

    @Column(name="history", nullable = false, length = 500)
    String history;

    @Column(name="department", nullable = false, length = 50)
    String department;

    @Column(name="workshop", length = 100)
    String workshop;

    public MuseumEvent(String history, String department, String workshop) {
        this.history = history;
        this.department = department;
        this.workshop = workshop;
    }

    public MuseumEvent(String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer, String history, String department, String workshop) {
        super(name, price, city, date, phoneNumber, artist, organizer);
        this.history = history;
        this.department = department;
        this.workshop = workshop;
    }
}
