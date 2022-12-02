package com.bosonit.spring_cloud_ticket.cliente;

import com.bosonit.spring_cloud_ticket.cliente.infrastructue.ClienteOUTputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "cliente-frond", url="http://localhost:8088/cliente")
public interface ClienteFeignTicket {

    @GetMapping("get/{id}")
    public ClienteOUTputDto findByIdCliente(@PathVariable Integer id);

    @PostMapping("/addclient")
    ClienteOUTputDto save(@RequestBody ClienteOUTputDto clienteOUTputDto);
}
