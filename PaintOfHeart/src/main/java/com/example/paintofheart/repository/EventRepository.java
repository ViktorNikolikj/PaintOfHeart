package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
