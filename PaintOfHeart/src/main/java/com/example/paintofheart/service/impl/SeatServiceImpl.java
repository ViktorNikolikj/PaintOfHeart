package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Event;
import com.example.paintofheart.model.entities.Seat;
import com.example.paintofheart.model.exceptions.InvalidSeatIdException;
import com.example.paintofheart.repository.SeatRepository;
import com.example.paintofheart.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private  final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> allSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seat findById(int id) {
        return seatRepository.findById(id).orElseThrow(() -> new InvalidSeatIdException());
    }

    @Override
    public Seat create(Event event, Integer number) {
        Seat seat = new Seat(event, number);
        return this.seatRepository.save(seat);
    }

    @Override
    public Seat update(int id,Event event, Integer number) {
        Seat seat = this.seatRepository.findById(id).orElseThrow(() -> new InvalidSeatIdException());
        seat.setEvent(event);
        seat.setNumber(number);
        return this.seatRepository.save(seat);
    }

    @Override
    public Seat delete(int id) {
        Seat seat = this.seatRepository.findById(id).orElseThrow(() -> new InvalidSeatIdException());
        this.seatRepository.delete(seat);
        return seat;
    }

}
