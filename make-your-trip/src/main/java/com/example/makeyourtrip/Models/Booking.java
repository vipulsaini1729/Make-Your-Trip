package com.example.makeyourtrip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "bookings")
// this will keep a record of already booked seatNo on a particular date
// of a particular transport id
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private String seatNos;

    private LocalDate journeyDate;

    private Integer transportId;

    @ManyToOne
    @JoinColumn
    private Transport transport;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private TicketEntity ticketEntity;

    @ManyToOne
    @JoinColumn
    private User user;


}
