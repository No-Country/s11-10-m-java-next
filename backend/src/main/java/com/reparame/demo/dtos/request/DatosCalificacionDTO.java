package com.reparame.demo.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosCalificacionDTO {
    private String descripcion;
    private Integer puntuacion;
}
