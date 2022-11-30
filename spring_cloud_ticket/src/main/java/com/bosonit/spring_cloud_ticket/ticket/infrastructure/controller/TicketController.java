package com.bosonit.spring_cloud_ticket.ticket.infrastructure.controller;


import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketINputDto;
import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketOUTputDto;
import com.bosonit.spring_cloud_ticket.ticket.service.ServiceTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    ServiceTicket serviceTicket;


    @PostMapping("/addticket")
    public TicketOUTputDto guardarticket(@RequestBody TicketINputDto ticketINputDto) throws Exception {
        return serviceTicket.loadTicket(ticketINputDto);
    }

    @GetMapping("get/{id}")
    public TicketOUTputDto show(@PathVariable Integer id) throws Exception {

        return serviceTicket.viewIdTicket(id);

    }
    @PutMapping("/put/{id}")
    public TicketOUTputDto modificarTicket(@PathVariable Integer id, @RequestBody TicketINputDto clienteINputDto) throws Exception{

        return serviceTicket.updateTicket(id,clienteINputDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Integer id) throws Exception {
        serviceTicket.deleteTicket(id);
        }

    @GetMapping("/getall")
    public List<TicketOUTputDto> viewall(){
        return (List<TicketOUTputDto>) serviceTicket.viewallTicket();
    }


}

