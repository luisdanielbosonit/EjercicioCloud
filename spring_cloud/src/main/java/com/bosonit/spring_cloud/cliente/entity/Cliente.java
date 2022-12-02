package com.bosonit.spring_cloud.cliente.entity;

import com.bosonit.spring_cloud.trips.entity.Trips;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "cliente")
public class Cliente {

    private static final String fechtype = null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cliente")
    private Integer id_cliente;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer age;
    @Column
    private String email;
    @Column
    private Integer telefono;

    @ManyToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    @JsonBackReference
    List<Trips> trips = new ArrayList<>();


}






