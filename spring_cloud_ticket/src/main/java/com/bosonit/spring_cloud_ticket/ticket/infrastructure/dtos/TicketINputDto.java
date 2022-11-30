package com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos;

import com.bosonit.spring_cloud_ticket.ticket.entity.Ticket;
import lombok.Data;

/**
 * A DTO for the {@link Ticket} entity
 */
@Data
public class TicketINputDto {

    private Integer id_ticket;
    private Integer passengerId;
    private String passengerName;
    private String passengerLastname;
    private String passgenerEmail;
    private String tripOrigin;
    private String tripDestination;
    private String departureDate;
    private String arrivalDate;


    public Ticket transformIntoTicket() {
        Ticket ticket = new Ticket();
        ticket.setId_ticket(this.id_ticket);
        ticket.setPassengerId(this.passengerId);
        ticket.setPassengerName(this.passengerName);
        ticket.setPassengerLastname(this.passengerLastname);
        ticket.setPassgenerEmail(this.passgenerEmail);
        ticket.setTripOrigin(this.tripOrigin);
        ticket.setTripDestination(this.tripDestination);
        ticket.setDepartureDate(this.departureDate);
        ticket.setArrivalDate(this.arrivalDate);

        return ticket;
    }

    public TicketINputDto(Integer id_ticket, Integer passengerId
                        , String passengerName, String passengerLastname
                        , String passgenerEmail, String tripOrigin, String tripDestination
                        , String departureDate, String arrivalDate) {
        this.id_ticket = id_ticket;
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerLastname = passengerLastname;
        this.passgenerEmail = passgenerEmail;
        this.tripOrigin = tripOrigin;
        this.tripDestination = tripDestination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }
}