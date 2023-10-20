/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Services;

import com.reparame.demo.Repositories.ClienteRepository;
import com.reparame.demo.Repositories.PrestadorRepository;
import com.reparame.demo.dtos.RegisterRequest;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Prestador;
import com.reparame.demo.enumeradores.Roles;
import com.reparame.demo.exception.MiException;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final ClienteRepository clienteRepository;
    private final PrestadorRepository prestadorRepository;
    private final ClienteService clienteService;
    private final PrestadorService prestadorService;
    
    public ResponseEntity<?> registro(RegisterRequest registerRequest) throws MiException{
        Prestador prestador = new Prestador();
        Cliente cliente = new Cliente();
        String rolCliente = Roles.CLIENTE.name();
        String rolPrestador = Roles.PRESTADOR.name();
        String rolRequest = registerRequest.getRol();
        
        LocalDate fechaNacimiento = registerRequest.validarFecha(registerRequest.getFechaNacimiento());
        
        if (prestadorService.prestadorExiste(registerRequest.getUssername()) || 
                clienteService.clienteExiste(registerRequest.getUssername())) {
            return new ResponseEntity<String>("Usuario existente", HttpStatus.BAD_REQUEST);
        }
        
        if (rolRequest.equalsIgnoreCase(rolPrestador)) {
            //Todavia falta ver q onda con el atributo zona
            prestador.setNombreCompleto(registerRequest.getNombreCompleto());
            prestador.setApellidoCompleto(registerRequest.getApellidoCompleto());
            prestador.setUsername(registerRequest.getUssername());
            prestador.setPassword(registerRequest.getPassword());
            prestador.setDNI(registerRequest.getDNI());
            prestador.setDireccion(registerRequest.getDireccion());
            prestador.setNumeroTelefonico(registerRequest.getNumeroTelefonico());
            prestador.setProvincia(registerRequest.getProvincia());
            prestador.setLocalidad(registerRequest.getLocalidad());
            prestador.setFechaNacimiento(fechaNacimiento);
            prestador.setRol(Roles.PRESTADOR);
            prestador.setAlta(true);
            
            prestadorRepository.save(prestador);
            return new ResponseEntity<String>("Prestador registrado con exito", HttpStatus.OK);
        
        } else if(rolRequest.equalsIgnoreCase(rolCliente)){
            cliente.setNombreCompleto(registerRequest.getNombreCompleto());
            cliente.setApellidoCompleto(registerRequest.getApellidoCompleto());
            cliente.setUsername(registerRequest.getUssername());
            cliente.setPassword(registerRequest.getPassword());
            cliente.setDNI(registerRequest.getDNI());
            cliente.setDireccion(registerRequest.getDireccion());
            cliente.setNumeroTelefonico(registerRequest.getNumeroTelefonico());
            cliente.setProvincia(registerRequest.getProvincia());
            cliente.setLocalidad(registerRequest.getLocalidad());
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setRol(Roles.CLIENTE);
            cliente.setAlta(true);
            
            clienteRepository.save(cliente);
            return new ResponseEntity<String>("Cliente registrado con exito", HttpStatus.OK);
        }
        
        throw new MiException("Ingrese un rol de Prestador o Cliente", HttpStatus.BAD_REQUEST);
        
        
    }
}
