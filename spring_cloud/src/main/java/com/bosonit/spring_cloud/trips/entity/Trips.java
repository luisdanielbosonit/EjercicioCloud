package com.bosonit.spring_cloud.trips.entity;

import com.bosonit.spring_cloud.cliente.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "viajes")
@RequestMapping("add")
public class Trips {

    private static final String fechtype = null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_viajes")
    private Integer id_trips;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String departureDate;

    @Column(nullable = false)
    private String arrivalDate;

    @OneToMany(mappedBy = "trips")
    List<Cliente> passenger= new ArrayList<>();

    @Column(nullable = false)
    private String status;

}






