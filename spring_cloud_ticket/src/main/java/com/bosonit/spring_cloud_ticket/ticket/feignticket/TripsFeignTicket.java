package com.bosonit.spring_cloud_ticket.ticket.feignticket;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= "Trips-frond", url="http://localhost:8088/viajes")
public interface TripsFeignTicket {



}
