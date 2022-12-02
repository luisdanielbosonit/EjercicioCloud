package com.bosonit.spring_cloud.trips.entity;

import com.bosonit.spring_cloud.cliente.entity.Cliente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    @JoinTable(
            name = "rel_client_trip",
            joinColumns = @JoinColumn(name = "id_trip", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_client", nullable = false),
            uniqueConstraints = @UniqueConstraint(columnNames={"id_trip", "id_client"})
    )
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    @JsonManagedReference
    List<Cliente> passenger= new ArrayList<>();
    private String status;

}






