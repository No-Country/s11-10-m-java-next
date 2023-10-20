package com.reparame.demo.dtos.requets;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;

import com.reparame.demo.entity.Clasificacion;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Servicio;
import com.reparame.demo.exception.MiException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroTicketDto(
		
		
		Boolean estado,
		
		@NotBlank(message = "El campo no debe estar vacio o null")
	    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "Debe contener solo letras y tener un máximo de 150 caracteres")
		String descripcion,
		
		@NotBlank(message = "No debe estar en blanco o nulo formato de fecha YYYY-MM-DD")
		@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe estar en el formato 'YYYY/MM/DD'")
		String fechaInicio,
		
		@NotBlank(message = "No debe estar en blanco o nulo formato de fecha YYYY-MM-DD")
		@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe estar en el formato 'YYYY-MM-DD'")
		String fechaRequerida,
		
		Servicio servicio,
		
		Clasificacion clasificacion,
		
		Cliente cliente) {
	
	

    

}
