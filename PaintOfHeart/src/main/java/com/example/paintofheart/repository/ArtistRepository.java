package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
