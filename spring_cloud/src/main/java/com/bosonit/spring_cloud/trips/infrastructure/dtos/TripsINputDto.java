package com.bosonit.spring_cloud.trips.infrastructure.dtos;

import com.bosonit.spring_cloud.cliente.entity.Cliente;
import com.bosonit.spring_cloud.trips.entity.Trips;
import lombok.Data;

import java.util.List;

/**
 * A DTO for the {@link Trips} entity
 */
@Data
public class TripsINputDto {

    private Integer id_trips;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
//    List<Cliente> passenger;
    private String status;


    public Trips transformIntoTrips() {
        Trips trips = new Trips();
        trips.setOrigin(this.origin);
        trips.setDestination(this.destination);
        trips.setDepartureDate(this.departureDate);
        trips.setArrivalDate(this.arrivalDate);
//        trips.setPassenger(this.passenger);
        trips.setStatus(this.status);

        return trips;
    }

    public TripsINputDto(String origin,
                         String destination,
                         String departureDate,
                         String arrivalDate,
//                         List<Cliente> passenger,
                         String status) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
//        this.passenger = passenger;
        this.status = status;
    }
}