package com.example.makeyourtrip.RequestDto;

import lombok.Data;

@Data
public class AddFlightSeatsDto {

    private int noOfEconomySeats;
    private int noOfBusinessSeats;
    private int priceOfBusinessSeat;
    private int priceOfEconomySeat;
    private Integer transportId;
}
