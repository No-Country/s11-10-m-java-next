package com.reparame.demo.dtos.response;

import java.time.LocalDate;

import com.reparame.demo.enumeradores.Roles;

import lombok.Data;

@Data
public class UserDto {
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
    private Roles rol;
}
