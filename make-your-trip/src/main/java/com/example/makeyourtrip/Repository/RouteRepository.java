package com.example.makeyourtrip.Repository;

import com.example.makeyourtrip.ENUMS.City;
import com.example.makeyourtrip.ENUMS.ModeOfTransport;
import com.example.makeyourtrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Routes, Integer> {

    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCity, City toCity, ModeOfTransport modeOfTransport);


}
