package com.example.makeyourtrip.Models;

import com.example.makeyourtrip.ENUMS.City;
import com.example.makeyourtrip.ENUMS.ModeOfTransport;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "routes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    @Enumerated(value = EnumType.STRING)
    private City fromCity;

    @Enumerated(value = EnumType.STRING)
    private City toCity;

    private String listOfStopsInBetween;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    List<Transport> transportList = new ArrayList<>();




}
