/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.dtos.request;

import com.reparame.demo.exception.MiException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class RegisterRequestDTO {
    @NotBlank(message = "El nombre completo no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El nombre completo debe contener solo letras y tener un máximo de 30 caracteres")
    private String nombreCompleto;
    
    @NotBlank(message = "El apellido completo no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El apellido completo debe contener solo letras y tener un máximo de 30 caracteres")
    private String apellidoCompleto;
    
    @NotBlank(message = "El correo electronico no debe estar en blanco o nulo")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "La dirección de correo electrónico no es válida")
    private String username;
    
    @NotBlank(message = "La contrase\u00F1a no debe estar en blanco o nulo")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,15}$", message = "La contrase\u00F1a no cumple con los requisitos, ingrese letras mayusculas y minusculas, numeros, un caracter especial y maximo 15")
    private String password;
    
    @NotBlank(message = "El DNI no debe estar en blanco o nulo")
    @Pattern(regexp = "^[0-9]{8}$", message = "El DNI debe ser una cadena de 8 dígitos numéricos")
    private String DNI;
    
    @NotBlank(message = "La dirección no debe estar en blanco o nula")
    @Pattern(regexp = "^(?=.*\\d)[a-zA-ZÀ-ÿ\\d\\s']{1,30}$", message = "La dirección debe contener letras y dígitos numéricos y tener un máximo de 30 caracteres")
    private String direccion;
    
    @NotBlank(message = "El numero de telefono no debe estar en blanco o nulo")
    @Pattern(regexp = "^[0-9]{10,}$", message = "El número telefónico debe ser una cadena de al menos 10 dígitos numéricos")
    private String numeroTelefonico;
    
    @NotBlank(message = "El nombre de la provincia no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El nombre de la provincia debe contener solo letras y tener un máximo de 30 caracteres")
    private String provincia;
    
    @NotBlank(message = "El nombre de la localidad no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "El nombre de la localidad debe contener solo letras y tener un máximo de 30 caracteres")
    private String localidad;
    
    @NotBlank(message = "La fecha de nacimiento no debe estar en blanco o nulo")
    private String fechaNacimiento;
    
    @NotBlank(message = "El rol no debe estar en blanco o nulo")
    private String rol;
    
    @NotBlank(message = "La zona no debe estar en blanco o nulo")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s']{1,30}$", message = "La zona debe contener solo letras y tener un máximo de 30 caracteres")
    private String zona;
    
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
