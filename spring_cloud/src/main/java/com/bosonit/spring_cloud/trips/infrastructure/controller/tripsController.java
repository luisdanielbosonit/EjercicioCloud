package com.bosonit.spring_cloud.trips.infrastructure.controller;


import com.bosonit.spring_cloud.trips.infrastructure.dtos.TripsINputDto;
import com.bosonit.spring_cloud.trips.infrastructure.dtos.TripsOUTputDto;
import com.bosonit.spring_cloud.trips.service.ServiceTrips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")
@CrossOrigin
public class tripsController {

    @Autowired
    ServiceTrips serviceTrips;


    @PostMapping("/addtrips")
    public TripsOUTputDto guardarTrips(@RequestBody TripsINputDto tripsINputDto) throws Exception {
        return serviceTrips.loadTrips(tripsINputDto);
    }

    @GetMapping("get/{id}")
    public TripsOUTputDto show(@PathVariable Integer id) throws Exception {

        return serviceTrips.viewIdTrips(id);

    }

    @PutMapping("/put/{id}")
    public TripsOUTputDto modificarTrips(@PathVariable Integer id, @RequestBody TripsINputDto tripsINputDto) throws Exception{

        return serviceTrips.updateTrips(id,tripsINputDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTrips(@PathVariable Integer id) throws Exception {
        serviceTrips.deleteTrips(id);
        }

    @GetMapping("/getall")
    public List<TripsOUTputDto> viewall(){
        return (List<TripsOUTputDto>) serviceTrips.viewallTrips();
    }

    @GetMapping("/trip/addPassenger/{trip_id}/{client_id}")
    public TripsOUTputDto addPassenger(@PathVariable Integer trip_id, @PathVariable Integer client_id){
        return  serviceTrips.addPassenger(trip_id,client_id);
    }
    @GetMapping("/passenger/count/{id}")
    public ResponseEntity<String> countPassengers(@PathVariable Integer id){
        return new ResponseEntity<>("Numero de pasajeros del viaje con id " + id
                + ": " + serviceTrips.countPassengers(id), HttpStatus.OK);
    }

    @GetMapping("/trip/{trip_id}/{status}")
    public TripsOUTputDto changeStatus(@PathVariable Integer trip_id, @PathVariable String status){
        return serviceTrips.changeStatus(trip_id,status);
    }
}

