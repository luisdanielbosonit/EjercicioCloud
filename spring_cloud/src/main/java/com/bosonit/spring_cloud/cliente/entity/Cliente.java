package com.bosonit.spring_cloud.cliente.entity;

import com.bosonit.spring_cloud.trips.entity.Trips;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "cliente")
@RequestMapping("add")
public class Cliente {

    private static final String fechtype = null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cliente")
    private Integer id_cliente;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer telefono;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_trips")
    Trips trips;


}






