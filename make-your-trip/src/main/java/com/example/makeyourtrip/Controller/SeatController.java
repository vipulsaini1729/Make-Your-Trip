package com.example.makeyourtrip.Controller;

import com.example.makeyourtrip.RequestDto.AddFlightSeatsDto;
import com.example.makeyourtrip.Services.SeatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatServices seatServices;

    @PostMapping("addFlightSeat")

    public String addFlightSeats(@RequestBody AddFlightSeatsDto seatsDto ){
        return seatServices.addFlightSeats(seatsDto);
    }
}
