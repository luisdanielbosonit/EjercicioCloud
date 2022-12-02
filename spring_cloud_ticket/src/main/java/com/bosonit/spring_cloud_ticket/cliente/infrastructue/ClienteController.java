package com.bosonit.spring_cloud_ticket.cliente.infrastructue;

import com.bosonit.spring_cloud_ticket.cliente.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ServiceCliente seviceCliente;

    @GetMapping("/client/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable("id")Integer id){
        Object  client = seviceCliente.findbyId(id);
        if(client == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

}
