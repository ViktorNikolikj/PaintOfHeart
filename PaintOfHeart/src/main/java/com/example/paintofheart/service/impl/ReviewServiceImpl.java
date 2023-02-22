package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Artist;
import com.example.paintofheart.model.entities.Customer;
import com.example.paintofheart.model.entities.Review;
import com.example.paintofheart.repository.ReviewRepository;
import com.example.paintofheart.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    private final ReviewRepository reviewRepository;


    @Override
    public Review addReview(Artist artist, Customer customer, int rating, String content) {
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Review review = new Review(content, rating, date, artist, customer);
        return this.reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllByArtist(Artist artist) {
        return this.reviewRepository.findAllByArtist(artist);
    }


}
