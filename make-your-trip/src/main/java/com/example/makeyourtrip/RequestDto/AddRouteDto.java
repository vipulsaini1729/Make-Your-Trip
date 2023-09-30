package com.example.makeyourtrip.RequestDto;

import com.example.makeyourtrip.ENUMS.City;
import com.example.makeyourtrip.ENUMS.ModeOfTransport;
import lombok.Data;

@Data
public class AddRouteDto {

    private City fromCity;
    private City toCity;
    private String stopsInBetween;
    private ModeOfTransport modeOfTransport;
}
