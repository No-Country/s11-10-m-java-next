/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;

import com.reparame.demo.dtos.requets.DatosActualizarTicketDto;
import com.reparame.demo.dtos.requets.DatosRegistroTicketDto;
import com.reparame.demo.exception.MiException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Admin
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tikets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Tiket;
    private Boolean estado;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaRequerida;
    
    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;
    
    @OneToOne
    @JoinColumn(name="id_clasificacion")
    private Clasificacion clasificacion;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    // para crear un ticket a partir de los datos recibidos 
    public Ticket( DatosRegistroTicketDto ticket) throws MiException {
    	this.estado = true;
    	this.descripcion = ticket.descripcion();
    	
    	this.fechaInicio = this.validarFecha(ticket.fechaInicio());
    	this.fechaRequerida = this.validarFecha(ticket.fechaRequerida());
    	this.servicio = ticket.servicio();
    	this.clasificacion = ticket.clasificacion();
    	this.cliente =ticket.cliente();
    	
    }
    
    // actualizar tikets
    public void actualizarDatos(DatosActualizarTicketDto actualizarTicket) {
    	
    	if (actualizarTicket.estado() != null) {
            this.estado= actualizarTicket.estado();
        }
    	
        if (actualizarTicket.descripcion() != null) {
            this.descripcion = actualizarTicket.descripcion();
        }
        
        if (actualizarTicket.fechaInicio() != null) {
            this.fechaInicio = actualizarTicket.fechaInicio();
        }
        
        if (actualizarTicket.fechaRequerida() != null) {
            this.fechaRequerida = actualizarTicket.fechaRequerida();
        }
    }

    // desactivar ticket
	public void desactivarTicket() {
		this.estado = false;
		
	}
	

    //validar la fecha de nacimiento
    public LocalDate validarFecha(String fechaNacimiento) throws MiException  {
        try {
        	//si la fecha que recibe es en formato corrrecto devuelve la fecha como localdate
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento);
            
            // Verifica si la fecha de nacimiento es del pasado
            LocalDate fechaActual = LocalDate.now();
            if (fechaNac.isAfter(fechaActual)) {
                throw new MiException("La fecha de nacimiento debe ser del pasado", HttpStatus.BAD_REQUEST);
            }
            return fechaNac; 
            
        } catch (DateTimeParseException  e) {
            throw new MiException("El formato de fecha debe ser yyyy-MM-dd", HttpStatus.BAD_REQUEST);
        }
        
    }

    
}





