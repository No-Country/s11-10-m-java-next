package com.reparame.demo.dtos.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetalleClienteDTO {
    private Long id;
    private String nombreCompleto;
    private String apellidoCompleto;
    private String username;
    private String DNI;
    private String direccion;
    private String numeroTelefonico;
    private String provincia;
    private String localidad;
    private LocalDate fechaNacimiento;
    private String zona;
}