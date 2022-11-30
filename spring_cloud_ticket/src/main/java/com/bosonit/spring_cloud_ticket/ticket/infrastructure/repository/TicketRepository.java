package com.bosonit.spring_cloud_ticket.ticket.infrastructure.repository;



import com.bosonit.spring_cloud_ticket.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
//    List<Ticket> findByname(String name);
}
