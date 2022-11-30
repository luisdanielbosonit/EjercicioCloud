package com.bosonit.spring_cloud_ticket.ticket.service;


import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketINputDto;
import com.bosonit.spring_cloud_ticket.ticket.infrastructure.dtos.TicketOUTputDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public interface ServiceTicket {

    public TicketOUTputDto viewIdTicket(Integer id) throws Exception; //ok

    TicketOUTputDto updateTicket(Integer id, TicketINputDto ticketINputDto) throws Exception;//ok

    public void deleteTicket(Integer id) throws Exception; //ok

    public List<TicketOUTputDto> viewallTicket();

    public TicketOUTputDto loadTicket(TicketINputDto ticketINputDto)throws Exception; //ok

}
