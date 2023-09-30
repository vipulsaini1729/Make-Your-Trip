package com.example.makeyourtrip.Controller;

import com.example.makeyourtrip.RequestDto.BookingRequest;
import com.example.makeyourtrip.RequestDto.GetAvailableSeatsDto;
import com.example.makeyourtrip.ResponseDtos.AvailableSeatResponseDto;
import com.example.makeyourtrip.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

   @Autowired
   private BookingService bookingService;

    @GetMapping("/getAvailableSeat")
    public ResponseEntity getAvailableSeats(@RequestBody GetAvailableSeatsDto getAvailableSeatsDto){

        List<AvailableSeatResponseDto> result =  bookingService.getAvailableSeatsResponse(getAvailableSeatsDto);

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/bookFlight")
    public ResponseEntity bookFlight(@RequestBody BookingRequest bookingRequest){

    return null;
    }
}
