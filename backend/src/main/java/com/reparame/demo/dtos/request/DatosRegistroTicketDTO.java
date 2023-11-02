package com.reparame.demo.dtos.request;


import com.reparame.demo.entity.Calificacion;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Servicio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroTicketDTO(
		
	
	@NotBlank(message = "El campo no debe estar vacio o null")
	@Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "Debe contener solo letras y tener un máximo de 150 caracteres")
	String descripcion,
	
	@NotBlank(message = "No debe estar en blanco o nulo formato de fecha YYYY-MM-DD")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe estar en el formato 'YYYY/MM/DD'")
	String fechaInicio,
	
	@NotBlank(message = "No debe estar en blanco o nulo formato de fecha YYYY-MM-DD")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe estar en el formato 'YYYY-MM-DD'")
	String fechaRequerida
	) {
	
}
