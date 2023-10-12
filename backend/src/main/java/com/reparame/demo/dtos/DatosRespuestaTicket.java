package com.reparame.demo.dtos;

import java.time.LocalDate;

import com.reparame.demo.entity.Clasificacion;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Servicio;
import com.reparame.demo.entity.Ticket;

public record DatosRespuestaTicket( Long id , Boolean estado, String descripcion, LocalDate fechaInicio,  LocalDate fechaRequerida) {

	
	public DatosRespuestaTicket(Ticket ticket) {
        this(ticket.getId_Tiket(), ticket.getEstado(), ticket.getDescripcion(), ticket.getFechaInicio(), ticket.getFechaRequerida());
    }
	

	
}
