package com.bosonit.spring_cloud.trips.service;

import com.bosonit.spring_cloud.trips.infrastructure.dtos.TripsINputDto;
import com.bosonit.spring_cloud.trips.infrastructure.dtos.TripsOUTputDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public interface ServiceTrips {

    public TripsOUTputDto viewIdTrips(Integer id) throws Exception; //ok

    TripsOUTputDto updateTrips(Integer id, TripsINputDto tripsINputDto) throws Exception;//ok

    public void deleteTrips(Integer id) throws Exception; //ok

    public List<TripsOUTputDto> viewallTrips();

    public TripsOUTputDto loadTrips(TripsINputDto tripsINputDto)throws Exception; //ok

}
