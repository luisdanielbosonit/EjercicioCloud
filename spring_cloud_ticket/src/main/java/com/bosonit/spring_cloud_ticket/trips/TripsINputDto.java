package com.bosonit.spring_cloud_ticket.trips;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Trips} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripsINputDto {

    private Integer id_trips;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private String status;


    public Trips transformIntoTrips() {
        Trips trips = new Trips();
        trips.setOrigin(this.origin);
        trips.setDestination(this.destination);
        trips.setDepartureDate(this.departureDate);
        trips.setArrivalDate(this.arrivalDate);
        trips.setStatus(this.status);

        return trips;
    }

    public TripsINputDto(String origin, String destination,
                         String departureDate, String arrivalDate,
                         String status) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.status = status;
    }
}