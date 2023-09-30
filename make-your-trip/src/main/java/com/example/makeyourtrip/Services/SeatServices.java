package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.ENUMS.SeatType;
import com.example.makeyourtrip.Models.Seat;
import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.Repository.SeatRepository;
import com.example.makeyourtrip.Repository.TransportRepository;
import com.example.makeyourtrip.RequestDto.AddFlightSeatsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServices {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TransportRepository transportRepository;

    public String addFlightSeats(AddFlightSeatsDto seatsDto) {

       Transport transport = transportRepository.findById(seatsDto.getTransportId()).get();


        for(int i = 1; i < seatsDto.getNoOfEconomySeats(); i++){

            Seat seat = Seat.builder().seatNo("E" + i).seatType(SeatType.ECONOMY)
                    .price(seatsDto.getPriceOfEconomySeat()).transport(transport).build();



            //bcz of the bidirectional setting in the parent class
            transport.getSeatList().add(seat);
        }

        for(int i = 1; i < seatsDto.getNoOfBusinessSeats(); i++){

            Seat seat = Seat.builder().seatNo("B" + i).seatType(SeatType.ECONOMY)
                    .price(seatsDto.getPriceOfBusinessSeat()).transport(transport).build();



            //bcz of the bidirectional setting in the parent class
            transport.getSeatList().add(seat);
        }

        transportRepository.save(transport);

        return "Defined Seats have been added";

    }
}
