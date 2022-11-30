package com.bosonit.spring_cloud.cliente.infrastructure.controller;


import com.bosonit.spring_cloud.cliente.infrastructure.dtos.ClienteINputDto;
import com.bosonit.spring_cloud.cliente.infrastructure.dtos.ClienteOUTputDto;
import com.bosonit.spring_cloud.cliente.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    ServiceCliente serviceCliente;


    @PostMapping("/addclient")
    public ClienteOUTputDto guardarCliente(@RequestBody ClienteINputDto personaINputDto) throws Exception {
        return serviceCliente.loadClient(personaINputDto);
    }

    @GetMapping("get/{id}")
    public ClienteOUTputDto show(@PathVariable Integer id) throws Exception {

        return serviceCliente.viewId(id);

    }
    @GetMapping("/view/{name}")
    public List<ClienteOUTputDto> getclientByUsername(@PathVariable String name) throws Exception {
        return serviceCliente.viewPerson(name);
    }


    @PutMapping("/put/{id}")
    public ClienteOUTputDto modificarpersona(@PathVariable Integer id, @RequestBody ClienteINputDto clienteINputDto) throws Exception{

        return serviceCliente.update(id,clienteINputDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deletepersona(@PathVariable Integer id) throws Exception {
        serviceCliente.delete(id);
        }

    @GetMapping("/getall")
    public List<ClienteOUTputDto> viewall(){
        return (List<ClienteOUTputDto>) serviceCliente.viewall();
    }


}

