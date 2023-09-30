package com.example.makeyourtrip.ResponseDtos;

import com.example.makeyourtrip.ENUMS.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableSeatResponseDto {

    private String seatNo;
    private SeatType seatType;
    private Integer seatPrice;
}
