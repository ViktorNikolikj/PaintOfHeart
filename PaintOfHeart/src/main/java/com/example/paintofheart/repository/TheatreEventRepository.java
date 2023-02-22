package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.TheatreEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreEventRepository extends JpaRepository<TheatreEvent, Integer> {
}
