package com.bosonit.spring_cloud_ticket.ticket.service;

import com.bosonit.spring_cloud_ticket.Exception.EntityNotFoundException;
import com.bosonit.spring_cloud_ticket.Exception.UnprocessableEntityException;
import com.bosonit.spring_cloud_ticket.ticket.entity.Ticket;
import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketINputDto;
import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketOUTputDto;
import com.bosonit.spring_cloud_ticket.ticket.infrastructure.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceImplTicket implements ServiceTicket {

    @Autowired
    private TicketRepository ticketRepository ;



    @Override
    public TicketOUTputDto viewIdTicket(Integer id) {
        Ticket ticket= ticketRepository.findById(id).orElseThrow(()-> {throw new EntityNotFoundException("The ticket with : "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});
        return new TicketOUTputDto(ticket);
    }

    @Override
    public TicketOUTputDto updateTicket(Integer id, TicketINputDto ticketINputDto) throws Exception{

        Optional<Ticket> ticketActu= Optional.ofNullable(ticketRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("The ticket with Id: " + id + " does not exist in the database", HttpStatus.FOUND, new Date());
        }));
        if(ticketActu.isEmpty())
            throw new EntityNotFoundException("Client no exist",HttpStatus.FOUND,new Date());
        if(ticketINputDto.getPassengerName() == null)
            throw new UnprocessableEntityException(" PassengerName can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(ticketINputDto.getPassengerLastname() == null)
            throw new UnprocessableEntityException("LastName can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(!ticketINputDto.getPassgenerEmail().contains("@"))
            throw new UnprocessableEntityException("email can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
         if(ticketINputDto.getTripOrigin() == null)
            throw new UnprocessableEntityException("origin is not null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(ticketINputDto.getTripDestination()== null)
            throw new UnprocessableEntityException("Email format is not correct", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(ticketINputDto.getDepartureDate() == null)
            throw new UnprocessableEntityException("departureDate can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(ticketINputDto.getArrivalDate() == null)
            throw new UnprocessableEntityException("ArrivalDate can not be null",HttpStatus.UNPROCESSABLE_ENTITY,new Date());

       Ticket ticket = ticketActu.get();

        ticket.setPassengerName(ticketINputDto.getPassengerName());
        ticket.setPassengerLastname(ticketINputDto.getPassengerLastname());
        ticket.setPassgenerEmail(ticketINputDto.getPassgenerEmail());
        ticket.setTripOrigin(ticketINputDto.getTripOrigin());
        ticket.setTripDestination(ticketINputDto.getTripDestination());
        ticket.setDepartureDate(ticketINputDto.getDepartureDate());
        ticket.setArrivalDate(ticketINputDto.getArrivalDate());

        ticketRepository.save(ticket);

        return new TicketOUTputDto(ticket);
    }

    @Override
    public void deleteTicket(Integer id) throws Exception {

        Ticket ticket= ticketRepository.findById(id).orElseThrow(()-> {throw new EntityNotFoundException("The ticket with Id: "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});
        ticketRepository.delete(ticket);
    }

    @Override
    public List<TicketOUTputDto> viewallTicket() {
        List<TicketOUTputDto> listacliente=new ArrayList<>();
        ticketRepository.findAll().stream().map(TicketOUTputDto::new).forEach(clienteOutputDto -> listacliente.add(clienteOutputDto));
        return listacliente;
    }

    @Override
    public TicketOUTputDto loadTicket(TicketINputDto ticketINputDto){
        Ticket ticket= ticketINputDto.transformIntoTicket();
        ticketRepository.save(ticket);
        return new TicketOUTputDto(ticket);
    }

}
