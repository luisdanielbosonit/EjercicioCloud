package com.bosonit.spring_cloud_ticket.cliente;

import com.bosonit.spring_cloud_ticket.cliente.infrastructue.ClienteOUTputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Integer id_cliente;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Integer telefono;

    public Cliente(ClienteOUTputDto clienteOUTputDto) {
        clienteOUTputDto.setId_cliente(this.getId_cliente());
        clienteOUTputDto.setName(this.getName());
        clienteOUTputDto.setSurname(this.getSurname());
        clienteOUTputDto.setAge(this.getAge());
        clienteOUTputDto.setEmail(this.getEmail());
        clienteOUTputDto.setTelefono(this.getTelefono());
    }
}






