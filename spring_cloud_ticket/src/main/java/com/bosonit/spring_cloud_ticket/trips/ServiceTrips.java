package com.bosonit.spring_cloud_ticket.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTrips {
    @Autowired
    TripsFeignTrips tripsFeignTrips;

    public TripsOUTputDto finfBYId(Integer id) {
        return tripsFeignTrips.viewTripById(id);

    }
    public TripsOUTputDto addPassengerToTrip(Integer idTrip,Long idClient){
        return tripsFeignTrips.addPassengerTrips(idTrip,idClient);
    }


}
