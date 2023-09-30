package com.example.makeyourtrip.Repository;

import com.example.makeyourtrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value ="select * from booking where journeyDate=:journeyDateInput and transportId=:transportIdInput",nativeQuery = true)
    List<Booking> findBookings(LocalDate journeyDateInput, Integer transportIdInput);
}
