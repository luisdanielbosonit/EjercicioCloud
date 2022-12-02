package com.bosonit.spring_cloud_ticket.trips;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name= "Trips-frond", url="http://localhost:8088/viajes")
public interface TripsFeignTrips {
    @GetMapping("get/{id}")
    TripsOUTputDto viewTripById(@PathVariable Integer id);

    @PutMapping("/addPassenger/{idTrip}/{idClient}")
    TripsOUTputDto addPassengerTrips(@PathVariable Integer idTrip,@PathVariable Long idClient);

}
