package com.example.makeyourtrip.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data

public class GetAvailableSeatsDto {

    private LocalDate journeyDate;

    private int transportId;

}
