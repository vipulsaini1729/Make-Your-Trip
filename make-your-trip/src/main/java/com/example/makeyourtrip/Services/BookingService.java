package com.example.makeyourtrip.Services;


import com.example.makeyourtrip.Models.*;
import com.example.makeyourtrip.Repository.BookingRepository;
import com.example.makeyourtrip.Repository.TransportRepository;
import com.example.makeyourtrip.Repository.UserRepository;
import com.example.makeyourtrip.RequestDto.BookingRequest;
import com.example.makeyourtrip.RequestDto.GetAvailableSeatsDto;
import com.example.makeyourtrip.ResponseDtos.AvailableSeatResponseDto;
import com.example.makeyourtrip.Transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AvailableSeatResponseDto> getAvailableSeatsResponse(GetAvailableSeatsDto entryDto){

        List<Booking> doneBookings = bookingRepository.findBookings(entryDto.getJourneyDate(), entryDto.getTransportId());

        Set<String> bookedSeats = new TreeSet<>();

        for (Booking booking : doneBookings) {

            String str = booking.getSeatNos();

            String [] bookedSeatsInThatBooking = str.split(",");

            for (String seatNo : bookedSeatsInThatBooking ) {
                bookedSeats.add(seatNo);
            }
        }

        Transport transport = transportRepository.findById(entryDto.getTransportId()).get();

        List<Seat> seatList = transport.getSeatList();

        //Total seats - booked seats

        List<AvailableSeatResponseDto> finalAvailableSeats = new ArrayList<>();

        for(Seat seat : seatList){

            if(bookedSeats.contains(seat.getSeatNo())){
                continue;
            }
            else {
                // we will be building that response object

                AvailableSeatResponseDto availableSeat = AvailableSeatResponseDto.builder().seatNo(seat.getSeatNo())
                        .seatPrice(seat.getPrice()).seatType(seat.getSeatType()).build();

                finalAvailableSeats.add(availableSeat);
            }
        }
        return finalAvailableSeats;
    }

    public String makeABooking(BookingRequest bookingRequest){

        User userObj = userRepository.findById(bookingRequest.getUserId()).get();

        Transport transportObj = transportRepository.findById(bookingRequest.getTransportId()).get();

        Booking booking = BookingTransformer.convertRequestToEntity(bookingRequest);

        //Create the ticket Entity

        TicketEntity ticketEntity = createTicketEntity(transportObj, bookingRequest);

        // Set the FK

        booking.setTransport(transportObj);
        booking.setUser(userObj);
        booking.setTicketEntity(ticketEntity);

        //Setting the bidirectional mapping
        //Setting for ticket
        ticketEntity.setBooking(booking);

        //Setting the booking obj in the transport
        transportObj.getBookings().add(booking);

        //Setting the booking obj in the user

        userObj.getBookingList().add(booking);

        //Save all



        return null;

    }

    private TicketEntity createTicketEntity(Transport transport, BookingRequest bookingRequest){

        Integer totalPricePaid = findTotalPricePaid(transport, bookingRequest.getSeatNos());

        String routeDetails = getRouteDetails(transport);

        TicketEntity ticketEntity = TicketEntity.builder()
                .allSeatNos(bookingRequest.getSeatNos()).journeyDate(bookingRequest.getJourneyDate())
                .startTime(transport.getStartTime())
                .routeDetails(routeDetails)
                .totalCostPaid(totalPricePaid)
                .build();

        return ticketEntity;
    }

    private String getRouteDetails(Transport transport){

        // "DELHI TO BANGALORE

        Routes routes = transport.getRoute();

        String result = routes.getFromCity() + " TO " + routes.getToCity();

        return result;
    }

    private Integer findTotalPricePaid(Transport transport, String seatNos){

        //Todo function to find the total price paid for all the booked seat


        return 0;
    }
}

