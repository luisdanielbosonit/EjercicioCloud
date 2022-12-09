package com.bosonit.spring_cloud_ticket.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viajes")
public class TripsController {
    @Autowired
    ServiceTrips serviceTrips;

    @GetMapping("get/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable("id") Integer id_trip){
        Object  trip = serviceTrips.finfBYId(id_trip);
        if(trip == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip);
    }
}
