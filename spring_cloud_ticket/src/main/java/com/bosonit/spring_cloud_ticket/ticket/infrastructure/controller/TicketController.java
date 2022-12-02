package com.bosonit.spring_cloud_ticket.ticket.infrastructure.controller;


import com.bosonit.spring_cloud_ticket.cliente.infrastructue.ClienteOUTputDto;
import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketINputDto;
import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketOUTputDto;
import com.bosonit.spring_cloud_ticket.ticket.service.ServiceTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    ServiceTicket serviceTicket;


    @PostMapping("/addticket/{id_cliente}/{id_trips}")
    public Object guardarticket(@PathVariable Integer id_cliente, @PathVariable Integer id_trips) throws Exception {
        return serviceTicket.TicketCliente(id_cliente);
    }



//    @PostMapping("addticket/{id_cliente}/{id_trips}")
//    public ResponseEntity<ClienteOUTputDto> saveCliente(@PathVariable Integer id_cliente, @RequestBody ClienteOUTputDto clienteOUTputDto ){
//        ClienteOUTputDto clienteOUTputDto1= null;
//        try {
//            clienteOUTputDto1 = serviceTicket.loadTicket(id_cliente,clienteOUTputDto);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return ResponseEntity.ok(clienteOUTputDto1);
//    }

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

    @GetMapping("cliente/get/{id}")
    public ResponseEntity<ClienteOUTputDto> getClieById(@PathVariable Integer id) throws Exception {
        ClienteOUTputDto clienteOUTputDto= (ClienteOUTputDto) serviceTicket.TicketCliente(id);
        return ResponseEntity.ok(clienteOUTputDto);
    }
}

