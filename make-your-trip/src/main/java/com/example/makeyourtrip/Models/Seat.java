package com.example.makeyourtrip.Models;

import com.example.makeyourtrip.ENUMS.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name = "seats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    private Integer seatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    @ManyToOne
    @JoinColumn
    private Transport transport;
}
