package com.bosonit.spring_cloud_ticket.trips;

import com.bosonit.spring_cloud_ticket.cliente.infrastructue.ClienteOUTputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link Trips} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
        this.status = trips.getStatus();
    }
}