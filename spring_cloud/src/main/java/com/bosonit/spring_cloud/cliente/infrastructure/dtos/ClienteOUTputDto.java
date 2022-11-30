package com.bosonit.spring_cloud.cliente.infrastructure.dtos;

import com.bosonit.spring_cloud.cliente.entity.Cliente;
import lombok.Data;

import java.util.Date;

/**
 * A DTO for the {@link Cliente} entity
 */
@Data
public class ClienteOUTputDto {

    private Integer id_cliente;
    private String name;
    private String surname;
    private Integer age;

    private String email;
    private Integer telefono;


    public ClienteOUTputDto(Cliente cliente){
        this.id_cliente = cliente.getId_cliente();
        this.name = cliente.getName();
        this.surname = cliente.getSurname();
        this.email = cliente.getEmail();
        this.age = cliente.getAge();
        this.telefono = cliente.getTelefono();
    }
}