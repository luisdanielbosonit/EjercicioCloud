package com.bosonit.spring_cloud_ticket.ticket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "ticket")
public class Ticket {

    private static final String fechtype = null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_ticket")
    private Integer id_ticket;

    @Column(nullable = false)
    private Integer passengerId;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private String passengerLastname;

    @Column(nullable = false)
    private String passgenerEmail;

    @Column(nullable = false)
    private String tripOrigin;

    @Column(nullable = false)
    private String tripDestination;

    @Column(nullable = false)
    private String departureDate;

    @Column(nullable = false)
    private String arrivalDate;



}






