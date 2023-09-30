package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.Repository.RouteRepository;
import com.example.makeyourtrip.RequestDto.AddRouteDto;
import com.example.makeyourtrip.Transformers.RouteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    public String addRoute(AddRouteDto addRouteDto){

        Routes routeObj = RouteTransformer.convertDtoToEntity(addRouteDto);
        routeRepository.save(routeObj);

        return "Route has been successfully added to DB";
    }
}
