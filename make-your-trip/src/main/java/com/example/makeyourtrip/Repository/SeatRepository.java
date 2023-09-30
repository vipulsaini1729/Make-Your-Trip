package com.example.makeyourtrip.Repository;

import com.example.makeyourtrip.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
