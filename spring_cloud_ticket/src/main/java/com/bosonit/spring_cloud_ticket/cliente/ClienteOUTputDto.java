package com.bosonit.spring_cloud_ticket.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Cliente} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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