package com.example.paintofheart.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "seat", schema = "project")
//@IdClass(SeatId.class)
public class Seat {


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_event")
    Event event;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_seat")
    Integer id;

    @Column(name="number", nullable = false)
    Integer number;


    public Seat(Event event, Integer number) {
        this.event = event;
        this.number = number;
    }
}
