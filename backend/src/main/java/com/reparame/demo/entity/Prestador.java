/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    
    // Getters y setters específicos de Prestador
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
     
    public Double calcularCalificacion(){
        double sum = 0;
        int count = 0;
        
        for (Servicio servicio : servicios){
            for (Ticket ticket: servicio.getTickets()){
                if (ticket.getCalificacion() != null){
                    sum += ticket.getCalificacion().getPuntuacion();
                    count++;
                }
            }
        }
//        servicios.forEach(s ->{
//            s.getTickets().forEach(t->{
//                if(t.getCalificacion() != null){
//                sum +=t.getCalificacion().getPuntuacion();
//                count++;
//                }
//            });
//        });
        if (count > 0){
            return sum/count;
        }else{
            return 0.0;
        }
    }
}
