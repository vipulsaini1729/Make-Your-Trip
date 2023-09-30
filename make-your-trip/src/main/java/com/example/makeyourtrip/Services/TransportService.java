package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.ENUMS.ModeOfTransport;
import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.Repository.RouteRepository;
import com.example.makeyourtrip.Repository.TransportRepository;
import com.example.makeyourtrip.RequestDto.AddTransportDto;
import com.example.makeyourtrip.RequestDto.SearchFlightsDto;
import com.example.makeyourtrip.ResponseDtos.FlightResult;
import com.example.makeyourtrip.Transformers.TransportTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private RouteRepository routeRepository;

    public String addTransport(AddTransportDto addTransportDto) throws Exception{

        Transport transportObj = TransportTransformer.convertDtoToEntity(addTransportDto);


        Optional<Routes> optionalRoutes = routeRepository.findById(addTransportDto.getRouteId());

        if(!optionalRoutes.isPresent())
            throw new Exception("Route Id is not Present");

        Routes route = optionalRoutes.get();

        //FK column we are setting
        transportObj.setRoute(route);

        // Bidirectional mapping also needs to be taken care of
        route.getTransportList().add(transportObj);

        //because of bidirectional mapping i am only saving the parent
        //entity and child will automatically get saved

        routeRepository.save(route);

        return "Transport has been added successfully";

    }

    public List<FlightResult> searchForFlights(SearchFlightsDto searchFlightsDto){

        List<Routes> routes = routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightsDto.getFromCity(), searchFlightsDto.getToCity(), ModeOfTransport.FLIGHT);

        List<FlightResult> flightResults = new ArrayList<>();

        for (Routes route : routes) {
        List<Transport> transportList = route.getTransportList();

        // I should put a Date Filter here

            for (Transport transport : transportList) {
                if(transport.getJourneyDate().equals(searchFlightsDto.getJourneyDate())){

                FlightResult flightResult = TransportTransformer.convertEntityToFlightResult(transport);

                flightResult.setListOfStopsInBetween(route.getListOfStopsInBetween());

                flightResults.add(flightResult);
                }
            }
        }
        return flightResults;
    }


}
