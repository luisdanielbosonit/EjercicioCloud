package com.bosonit.spring_cloud_ticket.trips;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Trips {

    private Integer id_trips;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private String status;
}
