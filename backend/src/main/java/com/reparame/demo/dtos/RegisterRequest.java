/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.dtos;

import com.reparame.demo.exception.MiException;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "El nombre completo no debe estar en blanco o nulo")
    
    private String nombreCompleto;
    
    @NotBlank(message = "El apellido completo no debe estar en blanco o nulo")
    
    private String apellidoCompleto;
    
    @NotBlank(message = "El correo electronico no debe estar en blanco o nulo")
    
    private String ussername;
    
    @NotBlank(message = "La contrase\u00F1a no debe estar en blanco o nulo")
    
    private String password;
    
    @NotBlank(message = "El DNI no debe estar en blanco o nulo")
    
    private String DNI;
    
    @NotBlank(message = "La direccion no debe estar en blanco o nulo")
    
    private String direccion;
    
    @NotBlank(message = "El numero de telefono no debe estar en blanco o nulo")
    
    private String numeroTelefonico;
    
    @NotBlank(message = "El nombre de la provincia no debe estar en blanco o nulo")
    
    private String provincia;
    
    @NotBlank(message = "El nombre de la localidad no debe estar en blanco o nulo")
    
    private String localidad;
    
    @NotBlank(message = "La fecha de nacimiento no debe estar en blanco o nulo")
    
    private String fechaNacimiento;
    
    @NotBlank(message = "El rol no debe estar en blanco o nulo")
    
    private String rol;
    
    public LocalDate validarFecha(String fechaNacimiento) throws MiException  {
        try {
            //Si la fecha que recibe es en formato corrrecto devuelve la fecha como localdate
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento);
            
            // Verifica si la fecha de nacimiento es del pasado
            LocalDate fechaActual = LocalDate.now();
            if (fechaNac.isAfter(fechaActual)) {
                throw new MiException("La fecha de nacimiento debe ser del pasado", HttpStatus.BAD_REQUEST);
            }
            return fechaNac; 
            
        } catch (DateTimeParseException  e) {
            throw new MiException("El formato de fecha debe ser yyyy-MM-dd", HttpStatus.BAD_REQUEST);
        }
        
    }
}
