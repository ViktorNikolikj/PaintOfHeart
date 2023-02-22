package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Artist;
import com.example.paintofheart.model.entities.Customer;
import com.example.paintofheart.model.entities.Review;

import java.util.List;

public interface ReviewService {

    Review addReview(Artist artist, Customer customer, int rating, String content);

    List<Review> findAllByArtist(Artist artist);
}
