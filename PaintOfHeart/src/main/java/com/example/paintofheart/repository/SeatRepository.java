package com.example.paintofheart.repository;

import com.example.paintofheart.model.entities.Seat;
//import com.example.paintofheart.model.entities.SeatId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
