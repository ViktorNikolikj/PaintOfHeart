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
@Table(name = "review", schema = "project")
public class Review {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_review")
    Integer id;

    @Column(name="content", nullable = false, length = 500)
    String content;

    @Column(name = "rating", nullable = false)
    Integer rating;

    @Column(name = "created_at", nullable = false)
    Date createdAt;

    @ManyToOne
    @JoinColumn(name="id_user_artist")
    Artist artist;

    @ManyToOne
    @JoinColumn(name="id_user_customer")
    Customer customer;

    public Review(String content, Integer rating, Date createdAt, Artist artist, Customer customer) {
        this.content = content;
        this.rating = rating;
        this.createdAt = createdAt;
        this.artist = artist;
        this.customer = customer;
    }
}
