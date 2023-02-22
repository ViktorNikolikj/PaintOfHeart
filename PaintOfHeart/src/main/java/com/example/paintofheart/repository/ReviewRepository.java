package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Artist;
import com.example.paintofheart.model.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByArtist(Artist artist);
}
