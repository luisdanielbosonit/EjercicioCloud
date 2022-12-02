package com.bosonit.spring_cloud_ticket.cliente;

import com.bosonit.spring_cloud_ticket.cliente.infrastructue.ClienteOUTputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCliente {
    @Autowired
    ClienteFeignTicket clienteFeignTicket;

    public ClienteOUTputDto findbyId(Integer id){
        return clienteFeignTicket.findByIdCliente(id);
    }


}
