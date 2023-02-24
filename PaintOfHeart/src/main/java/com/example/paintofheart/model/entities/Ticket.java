package com.example.paintofheart.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ticket", schema = "project")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_ticket")
    Integer id;

    @Column (name="price", nullable = false)
    Integer price;

    @Column(name="date", nullable = false)
    Date date;

    @Column(name="location", nullable = false, length = 50)
    String location;

    @Column(name="type_of_event", nullable = false, length = 50)
    String eventType;

    @ManyToOne
    @JoinColumn(name = "id_seat")
    Seat seat;

//    @ManyToOne
//    @JoinColumn(name="id_user_customer") //??
//    Cart cart;

    @ManyToOne
    @JoinColumn(name="id_cart") //??
    Cart cart;

    @ManyToOne
    @JoinColumn(name="id_user_customer") //??
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_event")
    Event event;

    public Ticket(Integer price, Date date, String location, String eventType, Seat seat, Cart cart, Customer customer, Event event) {
        this.price = price;
        this.date = date;
        this.location = location;
        this.eventType = eventType;
        this.seat = seat;
        this.cart = cart;
        this.customer = customer;
        this.event = event;
    }

    public Customer getCustomer(){
        return this.getCart().getCustomer();
    }

//    public Event getEvent(){
//        return this.getSeat().getId()
//    }
}
