/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
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
@Table(name="prestadores")
public class Prestador extends Persona{
    private String zona;
    
    @OneToMany(mappedBy = "prestador")
    private List<Servicio> servicios;
    
    @OneToMany(mappedBy = "prestador")
    private List<Clasificacion> clasificaciones;
 
    @OneToOne
    private Imagen foto;
}
