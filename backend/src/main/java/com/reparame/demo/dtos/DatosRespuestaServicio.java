/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.dtos;

import com.reparame.demo.entity.Servicio;
import com.reparame.demo.enumeradores.Rubros;
import java.util.List;

/**
 *
 * @author Admin
 */
public record DatosRespuestaServicio(Long id, String descripcion, Integer añosSector, Integer precio, Boolean alta, Rubros rubro, String nombrePrestador) {

    public DatosRespuestaServicio(Servicio servicio) {
        this(servicio.getId_Servicio(), servicio.getDescripcion(), servicio.getAñosSector(), servicio.getPrecio(), servicio.getAlta(), servicio.getRubro(), servicio.getPrestador().getNombreCompleto());
        
    }

   
    
}
