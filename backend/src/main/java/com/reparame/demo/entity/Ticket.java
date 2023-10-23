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

import com.reparame.demo.dtos.DatosActualizarTicket;
import com.reparame.demo.dtos.DatosRegistroTicket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    
    @OneToOne(mappedBy="ticket")
    @JoinColumn(name="id_calificacion")
    private Calificacion calificacion;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    // para crear un ticket a partir de los datos recibidos 
    public Ticket( DatosRegistroTicket ticket) {
    	this.estado = true;
    	this.descripcion = ticket.descripcion();
    	this.fechaInicio = ticket.fechaInicio();
    	this.fechaRequerida = ticket.fechaRequerida();
    	this.servicio = ticket.servicio();
    	this.calificacion = ticket.calificacion();
    	this.cliente =ticket.cliente();
    	
    }
    
    // actualizar tikets
    public void actualizarDatos(DatosActualizarTicket actualizarTicket) {
    	
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
    
    public Calificacion getCalificacion(){
        return calificacion;
    }
    
    public void setCalificacion(Calificacion calificacion){
        this.calificacion = calificacion;
    }

    
}





