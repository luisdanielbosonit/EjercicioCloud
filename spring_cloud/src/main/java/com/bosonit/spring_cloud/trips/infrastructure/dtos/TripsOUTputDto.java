package com.bosonit.spring_cloud.trips.infrastructure.dtos;

import com.bosonit.spring_cloud.cliente.entity.Cliente;
import com.bosonit.spring_cloud.cliente.infrastructure.dtos.ClienteOUTputDto;
import com.bosonit.spring_cloud.trips.entity.Trips;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link Trips} entity
 */
@Data
public class TripsOUTputDto {

    private Integer id_trips;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    List<ClienteOUTputDto> passenger= new ArrayList<>();
    private String status;


    public TripsOUTputDto(Trips trips) {
        this.id_trips = trips.getId_trips();
        this.origin = trips.getOrigin();
        this.destination = trips.getDestination();
        this.departureDate = trips.getDepartureDate();
        this.arrivalDate = trips.getArrivalDate();
        this.passenger=trips.getPassenger().stream().map(ClienteOUTputDto::new).toList();
        this.status = trips.getStatus();
    }
}