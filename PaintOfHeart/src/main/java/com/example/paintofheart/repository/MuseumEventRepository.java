package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.MuseumEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseumEventRepository extends JpaRepository<MuseumEvent, Integer> {
}
