package com.bosonit.spring_cloud.cliente.service;

import com.bosonit.spring_cloud.Exception.EntityNotFoundException;
import com.bosonit.spring_cloud.Exception.UnprocessableEntityException;
import com.bosonit.spring_cloud.cliente.entity.Cliente;
import com.bosonit.spring_cloud.cliente.infrastructure.dtos.ClienteINputDto;
import com.bosonit.spring_cloud.cliente.infrastructure.dtos.ClienteOUTputDto;
import com.bosonit.spring_cloud.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceImplCliente implements ServiceCliente {

    @Autowired
    private ClienteRepository clienteRepository;



    @Override
    public ClienteOUTputDto viewId(Integer id) {
        Cliente cliente= clienteRepository.findById(id).orElseThrow(()-> {throw new EntityNotFoundException("The client with username: "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});
        return new ClienteOUTputDto(cliente);
    }

    @Override
    public List<ClienteOUTputDto> viewPerson(String name) {
        List<Cliente> persona= clienteRepository.findByname(name);
        if (persona.isEmpty())
            throw new EntityNotFoundException("The client with name: "+name+" does not exist in the database", HttpStatus.FOUND,new Date());

        return persona.stream().map(ClienteOUTputDto::new).collect(Collectors.toList());
    }

    @Override
    public ClienteOUTputDto update(Integer id, ClienteINputDto clienteINputDto) throws Exception{

        Optional<Cliente> personaActu= Optional.ofNullable(clienteRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("The client with Id: " + id + " does not exist in the database", HttpStatus.FOUND, new Date());
        }));
        if(personaActu.isEmpty())
            throw new EntityNotFoundException("Client no exist",HttpStatus.FOUND,new Date());
        if(clienteINputDto.getName() == null)
            throw new UnprocessableEntityException("Name can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(clienteINputDto.getSurname() == null)
            throw new UnprocessableEntityException("Surname can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
         if(clienteINputDto.getEmail() == null)
            throw new UnprocessableEntityException("Email is not null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(!clienteINputDto.getEmail().contains("@"))
            throw new UnprocessableEntityException("Email format is not correct", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(clienteINputDto.getAge() == null)
            throw new UnprocessableEntityException("age can not be null", HttpStatus.UNPROCESSABLE_ENTITY,new Date());
        if(clienteINputDto.getTelefono() == null)
            throw new UnprocessableEntityException("phone can not be null",HttpStatus.UNPROCESSABLE_ENTITY,new Date());

        Cliente cliente = personaActu.get();

        cliente.setName(clienteINputDto.getName());
        cliente.setSurname(clienteINputDto.getSurname());
        cliente.setAge(clienteINputDto.getAge());
        cliente.setEmail(clienteINputDto.getEmail());
        cliente.setTelefono(clienteINputDto.getTelefono());

        clienteRepository.save(cliente);

        return new ClienteOUTputDto(cliente);
    }

    @Override
    public void delete(Integer id) throws Exception {

        Cliente cliente= clienteRepository.findById(id).orElseThrow(()-> {throw new EntityNotFoundException("The client with Id: "+id+" does not exist in the database", HttpStatus.FOUND,new Date());});
        clienteRepository.delete(cliente);
    }

    @Override
    public List<ClienteOUTputDto> viewall() {
        List<ClienteOUTputDto> listacliente=new ArrayList<>();
        clienteRepository.findAll().stream().map(ClienteOUTputDto::new).forEach(clienteOutputDto -> listacliente.add(clienteOutputDto));
        return listacliente;
    }

    @Override
    public ClienteOUTputDto loadClient(ClienteINputDto clienteINputDto){
        Cliente cliente= clienteINputDto.transformIntoCliente();
        clienteRepository.save(cliente);
        return new ClienteOUTputDto(cliente);
    }

}
