package com.reparame.demo.dtos.response;

import com.reparame.demo.enumeradores.Rubros;

import lombok.Data;

@Data
public class ListadoServicioDTO {
    private Long id;
    private String descripcion;
    private Integer añosSector; 
    private Integer precio; 
    private Boolean alta; 
    private Rubros rubro; 
    private String nombrePrestador;
}
