package com.reparame.demo.dtos;

import java.time.LocalDate;

import com.reparame.demo.entity.Clasificacion;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Servicio;

public record DatosActualizarTicket(Boolean estado, String descripcion, LocalDate fechaInicio, LocalDate fechaRequerida,
		Servicio servicio, Clasificacion clasificacion, Cliente cliente) {

}
