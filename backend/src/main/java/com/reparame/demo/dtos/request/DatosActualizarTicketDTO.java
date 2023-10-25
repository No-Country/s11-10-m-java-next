package com.reparame.demo.dtos.request;

import java.time.LocalDate;

import com.reparame.demo.entity.Calificacion;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Servicio;

public record DatosActualizarTicketDTO(Boolean estado, String descripcion, LocalDate fechaInicio, LocalDate fechaRequerida,
		Servicio servicio, Calificacion calificacion, Cliente cliente) {
}
