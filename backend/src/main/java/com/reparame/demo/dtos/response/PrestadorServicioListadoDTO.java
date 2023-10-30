package com.reparame.demo.dtos.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrestadorServicioListadoDTO {
    private Long id;
    private String nombreCompleto;
    private String apellidoCompleto;
    private String username;
    private String direccion;
    private String numeroTelefonico;
    private Double calificacion;
    private String zona;
    private String descripcion;
}
