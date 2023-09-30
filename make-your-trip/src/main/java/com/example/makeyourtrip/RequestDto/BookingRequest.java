package com.example.makeyourtrip.RequestDto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BookingRequest {

    private String seatNos;

    private LocalDate journeyDate;

    private Integer transportId;

    private Integer userId;
}
