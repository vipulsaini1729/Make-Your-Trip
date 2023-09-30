package com.example.makeyourtrip.Controller;

import com.example.makeyourtrip.RequestDto.AddTransportDto;
import com.example.makeyourtrip.RequestDto.SearchFlightsDto;
import com.example.makeyourtrip.ResponseDtos.FlightResult;
import com.example.makeyourtrip.Services.TransportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/transport")
@RestController
@Slf4j
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping("/add")
    public ResponseEntity addTransport(@RequestBody AddTransportDto addTransportDto){
        try{
            String result = transportService.addTransport(addTransportDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
        log.error("Transport add failed{}", e.getMessage());

        System.out.printf("We are in the print statement{}", e.getMessage());

        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchFlights")
    public ResponseEntity searchFlights(@RequestBody SearchFlightsDto searchFlightsDto){

        List<FlightResult> flightResultList = transportService.searchForFlights(searchFlightsDto);

        return new ResponseEntity<>(flightResultList, HttpStatus.OK);
    }
}
