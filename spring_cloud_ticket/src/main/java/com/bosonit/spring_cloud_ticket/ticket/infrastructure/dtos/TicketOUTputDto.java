package com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos;


import com.bosonit.spring_cloud_ticket.ticket.entity.Ticket;
import lombok.Data;

/**
 * A DTO for the {@link Ticket} entity
 */
@Data
public class TicketOUTputDto {

    private Integer id_ticket;
    private Integer passengerId;
    private String passengerName;
    private String passengerLastname;
    private String passgenerEmail;
    private String tripOrigin;
    private String tripDestination;
    private String departureDate;
    private String arrivalDate;


    public TicketOUTputDto(Ticket ticket){
        this.id_ticket = ticket.getId_ticket();
        this.passengerId = ticket.getPassengerId();
        this.passengerName = ticket.getPassengerName();
        this.passengerLastname= ticket.getPassengerLastname();
        this.passgenerEmail = ticket.getPassgenerEmail();
        this.tripOrigin = ticket.getTripOrigin();
        this.tripDestination = ticket.getTripDestination();
        this.departureDate = ticket.getDepartureDate();
        this.arrivalDate = ticket.getArrivalDate();
    }
}