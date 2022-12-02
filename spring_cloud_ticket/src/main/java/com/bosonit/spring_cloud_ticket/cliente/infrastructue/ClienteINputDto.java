package com.bosonit.spring_cloud_ticket.cliente.infrastructue;

import com.bosonit.spring_cloud_ticket.cliente.Cliente;
import lombok.Data;

/**
 * A DTO for the {@link Cliente} entity
 */
@Data
public class ClienteINputDto {

    private Integer id_cliente;
    private String name;
    private String surname;
    private Integer age;

    private String email;
    private Integer telefono;


    public Cliente transformIntoCliente() {
        Cliente cliente = new Cliente();
        cliente.setId_cliente(this.id_cliente);
        cliente.setName(this.name);
        cliente.setSurname(this.surname);
        cliente.setAge(this.age);
        cliente.setEmail(this.email);
        cliente.setTelefono(this.telefono);

        return cliente;
    }

    public ClienteINputDto(Integer id, String name, String surname, String email, Integer age, Integer telefono) {
        this.id_cliente = id;
        this.name = name;
        this.surname = surname;
        this.age= age;
        this.email= email;
        this.telefono=telefono;

    }
}