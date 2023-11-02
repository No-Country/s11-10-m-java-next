package com.reparame.demo.dtos.response;

import com.reparame.demo.enumeradores.Rubros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicioListadoDTO {
    private Long id;
    private String descripcion;
    private Integer añosSector; 
    private Integer precio; 
    private Rubros rubro; 
    private PrestadorServicioListadoDTO prestador;
}
