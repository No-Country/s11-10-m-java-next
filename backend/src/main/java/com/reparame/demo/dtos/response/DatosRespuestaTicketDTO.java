package com.reparame.demo.dtos.response;

import java.time.LocalDate;


import com.reparame.demo.entity.Calificacion;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Servicio;
import com.reparame.demo.entity.Ticket;
import com.reparame.demo.enumeradores.ProgresoTicket;

public record DatosRespuestaTicketDTO( Long id , Boolean estado, String descripcion, LocalDate fechaInicio,  LocalDate fechaRequerida, ProgresoTicket progreso) {

	
	public DatosRespuestaTicketDTO(Ticket ticket) {
        this(ticket.getId_Tiket(), ticket.getEstado(), ticket.getDescripcion(), 
        ticket.getFechaInicio(), ticket.getFechaRequerida(), ticket.getProgreso() );
    }
	

	
}
