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
@Table(name="calificaciones")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Calificacion;
    private Integer puntuacion;
    private String descripcion;
    
    @OneToOne
    @JoinColumn(name="id_Tiket")
    private Ticket ticket;
    
    public Integer getPuntuacion(){
        return puntuacion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    
}
