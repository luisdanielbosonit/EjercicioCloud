package com.bosonit.spring_cloud.cliente.service;


import com.bosonit.spring_cloud.cliente.infrastructure.dtos.ClienteINputDto;
import com.bosonit.spring_cloud.cliente.infrastructure.dtos.ClienteOUTputDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public interface ServiceCliente {

    public ClienteOUTputDto viewId(Integer id) throws Exception; //ok

    public List<ClienteOUTputDto> viewPerson(String name) throws Exception ; //ok

    ClienteOUTputDto update(Integer id, ClienteINputDto clienteINputDto) throws Exception;//ok

    public void delete(Integer id) throws Exception; //ok

    public List<ClienteOUTputDto> viewall();

    public ClienteOUTputDto loadClient(ClienteINputDto clienteINputDto)throws Exception; //ok

}
