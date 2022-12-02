package com.bosonit.spring_cloud.trips.service;

import com.bosonit.spring_cloud.Exception.EntityNotFoundException;
import com.bosonit.spring_cloud.Exception.UnprocessableEntityException;
import com.bosonit.spring_cloud.cliente.entity.Cliente;
import com.bosonit.spring_cloud.cliente.infrastructure.repository.ClienteRepository;
import com.bosonit.spring_cloud.trips.entity.Trips;
import com.bosonit.spring_cloud.trips.infrastructure.dtos.TripsINputDto;
import com.bosonit.spring_cloud.trips.infrastructure.dtos.TripsOUTputDto;
import com.bosonit.spring_cloud.trips.infrastructure.repository.TripsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceImplTrips implements ServiceTrips {

    @Autowired
    private TripsRepository tripsRepository;

    @Autowired
    private ClienteRepository clienteRepository;



    @Override
    public TripsOUTputDto viewIdTrips(Integer id) {
        Trips trips= tripsRepository.findById(id).orElseThrow(()-> {throw new EntityNotFoundException("The trip with id: "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});
        return new TripsOUTputDto(trips);
    }


    @Override
    public TripsOUTputDto updateTrips(Integer id, TripsINputDto tripsINputDto) throws Exception{

        Optional<Trips> tripsActu= Optional.ofNullable(tripsRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("The trips with Id: " + id + " does not exist in the database", HttpStatus.FOUND, new Date());
        }));
        if(tripsActu.isEmpty())
            throw new EntityNotFoundException("Client no exist",HttpStatus.FOUND,new Date());
        if(tripsINputDto.getOrigin()== null)
            throw new UnprocessableEntityException("Origin can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(tripsINputDto.getDestination() == null)
            throw new UnprocessableEntityException("Destination can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
         if(tripsINputDto.getDepartureDate() == null)
            throw new UnprocessableEntityException("date is not null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(tripsINputDto.getArrivalDate() == null)
            throw new UnprocessableEntityException("Arrival can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
//        if(tripsINputDto.getPassenger() == null)
//            throw new UnprocessableEntityException("Passengeer can not be null",HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(tripsINputDto.getStatus() == null)
            throw new UnprocessableEntityException("Status can not be null",HttpStatus.UNPROCESSABLE_ENTITY,new Date());

        Trips trips = tripsActu.get();

        trips.setOrigin(tripsINputDto.getOrigin());
        trips.setDestination(tripsINputDto.getDestination());
        trips.setDepartureDate(tripsINputDto.getDepartureDate());
        trips.setArrivalDate(tripsINputDto.getArrivalDate());
//        trips.setPassenger(tripsINputDto.getPassenger());
        trips.setStatus(tripsINputDto.getStatus());

        tripsRepository.save(trips);

        return new TripsOUTputDto(trips);
    }

    @Override
    public void deleteTrips(Integer id) throws Exception {

        Trips trips= tripsRepository.findById(id).orElseThrow(()-> {throw new EntityNotFoundException("The trips with Id: "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});
        tripsRepository.delete(trips);
    }

    @Override
    public List<TripsOUTputDto> viewallTrips() {
        List<TripsOUTputDto> listatrips=new ArrayList<>();
        tripsRepository.findAll().stream().map(TripsOUTputDto::new).forEach(tripsOutputDto -> listatrips.add(tripsOutputDto));
        return listatrips;
    }

    @Override
    public TripsOUTputDto loadTrips(TripsINputDto tripsINputDto){
        Trips trips= tripsINputDto.transformIntoTrips();
        tripsRepository.save(trips);
        return new TripsOUTputDto(trips);
    }

    @Override
    public Integer countPassengers(Integer id) {
        Trips trips= tripsRepository.findById(id).orElseThrow(()-> {throw new EntityNotFoundException("The trips with Id: "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});
        return trips.getPassenger().size();
    }

    @Override
    public TripsOUTputDto addPassenger(Integer id, Integer client_id) {
        Trips trips = tripsRepository.findById(id).orElseThrow(()-> {
            throw new EntityNotFoundException("The trips with Id: "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});

        if(trips.getPassenger().size() == 40)
            throw new UnprocessableEntityException("The trip has the maximum number of passengers",HttpStatus.UNPROCESSABLE_ENTITY,new Date());

        if(trips.getPassenger().stream().filter(c->c.getId_cliente()==client_id).toList().size()==1)
            throw new UnprocessableEntityException("The passenger is already registered for that trip",HttpStatus.UNPROCESSABLE_ENTITY,new Date());

        Cliente cliente= clienteRepository.findById(client_id).orElseThrow(()-> new EntityNotFoundException("The trips with Id: " + id + " does not exist in the database", HttpStatus.FOUND, new Date()));
        trips.getPassenger().add(cliente);
        tripsRepository.save(trips);

        return new TripsOUTputDto(tripsRepository.save(trips));
    }
    @Override
    public TripsOUTputDto changeStatus(Integer id_trips, String status) {
        Trips trips= tripsRepository.findById(id_trips).orElseThrow(()-> {
            throw new EntityNotFoundException("The trips with Id: "+id_trips+" does not exist in the database", HttpStatus.FOUND,new Date());});
        return new TripsOUTputDto( tripsRepository.save(trips));
    }

}
