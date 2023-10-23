/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.dtos;

import com.reparame.demo.entity.Prestador;
import com.reparame.demo.entity.Ticket;
import com.reparame.demo.enumeradores.Rubros;

/**
 *
 * @author Admin
 */
public record DatosRegistroServicio(String descripcion, Integer añosSector, Integer precio, Boolean alta, Rubros rubro, Ticket tiket, Prestador prestador) {
    
}
