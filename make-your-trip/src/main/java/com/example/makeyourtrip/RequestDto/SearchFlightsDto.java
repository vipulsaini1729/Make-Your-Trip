package com.example.makeyourtrip.RequestDto;

import com.example.makeyourtrip.ENUMS.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlightsDto {

    private City fromCity;

    private  City toCity;

    private LocalDate journeyDate;
}
