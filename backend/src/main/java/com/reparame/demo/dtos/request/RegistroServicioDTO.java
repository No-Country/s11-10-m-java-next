package com.reparame.demo.dtos.request;

import com.reparame.demo.enumeradores.Rubros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroServicioDTO {
    private String descripcion;
    private Integer añosSector;
    private Integer precio;
    private Rubros rubro;
}
