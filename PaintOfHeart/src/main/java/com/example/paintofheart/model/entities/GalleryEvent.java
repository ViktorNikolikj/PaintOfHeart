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
@Table(name = "gallery", schema = "project")
@PrimaryKeyJoinColumn(name = "id_event")
public class GalleryEvent extends Event{

    @Column(name="style", nullable = false, length = 50)
    String style;

    public GalleryEvent(String name, Integer price, String city, Date date, String phoneNumber, Artist artist, Organizer organizer, String style) {
        super(name, price, city, date, phoneNumber, artist, organizer);
        this.style = style;
    }

}
