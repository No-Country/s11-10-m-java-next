/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.dtos.response;

import com.reparame.demo.entity.Prestador;
import com.reparame.demo.enumeradores.Roles;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author JuanCruz
 */

@Data
public class DetallePrestadorDTO {

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
    private Double calificacion;
    private String zona;

    @Enumerated(EnumType.STRING)
    private Roles rol;

    public DetallePrestadorDTO(Prestador prestador) {
        this.id = prestador.getId();
        this.nombreCompleto = prestador.getNombreCompleto();
        this.apellidoCompleto = prestador.getApellidoCompleto();
        this.username = prestador.getUsername();
        this.DNI = prestador.getDNI();
        this.direccion = prestador.getDireccion();
        this.numeroTelefonico = prestador.getNumeroTelefonico();
        this.provincia = prestador.getProvincia();
        this.localidad = prestador.getLocalidad();
        this.fechaNacimiento = prestador.getFechaNacimiento();
        this.calificacion= prestador.getCalificacion();
        this.zona = prestador.getZona();
        this.rol = prestador.getRol();
    }

    
}

