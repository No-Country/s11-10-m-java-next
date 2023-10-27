/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Services;

import com.reparame.demo.JWT.JwtService;
import com.reparame.demo.Repositories.ClienteRepository;
import com.reparame.demo.Repositories.PrestadorRepository;
import com.reparame.demo.dtos.request.LoginRequestDTO;
import com.reparame.demo.dtos.request.RegisterRequestDTO;
import com.reparame.demo.dtos.response.TokenResponseDTO;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Prestador;
import com.reparame.demo.enumeradores.Roles;
import com.reparame.demo.exception.MiException;
import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

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
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    
    public ResponseEntity<?> registro(RegisterRequestDTO registerRequest) throws MiException{
        Prestador prestador = new Prestador();
        Cliente cliente = new Cliente();
        TokenResponseDTO tokenDTO = new TokenResponseDTO();
        String rolCliente = Roles.CLIENTE.name();
        String rolPrestador = Roles.PRESTADOR.name();
        String rolRequest = registerRequest.getRol();
        
        LocalDate fechaNacimiento = registerRequest.validarFecha(registerRequest.getFechaNacimiento());
        
        if (prestadorService.prestadorExiste(registerRequest.getUsername()) ||
                clienteService.clienteExiste(registerRequest.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario existente");
        }
        
        if (rolRequest.equalsIgnoreCase(rolPrestador)) {
            
            prestador.setNombreCompleto(registerRequest.getNombreCompleto());
            prestador.setApellidoCompleto(registerRequest.getApellidoCompleto());
            prestador.setUsername(registerRequest.getUsername());
            prestador.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            prestador.setDNI(registerRequest.getDNI());
            prestador.setDireccion(registerRequest.getDireccion());
            prestador.setNumeroTelefonico(registerRequest.getNumeroTelefonico());
            prestador.setProvincia(registerRequest.getProvincia());
            prestador.setLocalidad(registerRequest.getLocalidad());
            prestador.setFechaNacimiento(fechaNacimiento);
            prestador.setZona(registerRequest.getZona());
            prestador.setRol(Roles.PRESTADOR);
            prestador.setAlta(true);
            
            prestadorRepository.save(prestador);
            tokenDTO.setToken(jwtService.getToken(prestador));
            return ResponseEntity.ok(tokenDTO);
        
        } else if(rolRequest.equalsIgnoreCase(rolCliente)){
            cliente.setNombreCompleto(registerRequest.getNombreCompleto());
            cliente.setApellidoCompleto(registerRequest.getApellidoCompleto());
            cliente.setUsername(registerRequest.getUsername());
            cliente.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            cliente.setDNI(registerRequest.getDNI());
            cliente.setDireccion(registerRequest.getDireccion());
            cliente.setNumeroTelefonico(registerRequest.getNumeroTelefonico());
            cliente.setProvincia(registerRequest.getProvincia());
            cliente.setLocalidad(registerRequest.getLocalidad());
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setZona(registerRequest.getZona());
            cliente.setRol(Roles.CLIENTE);
            cliente.setAlta(true);
            
            clienteRepository.save(cliente);
            tokenDTO.setToken(jwtService.getToken(cliente));
            
            return ResponseEntity.ok(tokenDTO);
        }
        
        throw new MiException("Ingrese un rol de Prestador o Cliente", HttpStatus.BAD_REQUEST);

    }
    
    public ResponseEntity<?> login(LoginRequestDTO loginRequest) throws MiException{
        try {
            Optional<Prestador> prestador = prestadorRepository.findByUsername(loginRequest.getUsername());
            Optional<Cliente> cliente = clienteRepository.findByUsername(loginRequest.getUsername());
            
            if (prestador.isPresent() && cliente.isPresent()) {
                //Verifica si el prestador y cliente esta en la db. Si el prestador me da falso, y el cliente me da falso,
                //los usuarios no estan registrados y larga esa exception. Si alguno me da true sigue con el metodo
                throw new UsernameNotFoundException("usuarios no registrados");
            }
            
            UserDetails user = (prestador.isPresent()) ? prestador.get() : cliente.get();
            System.out.println(loginRequest.getUsername() + loginRequest.getPassword());
            authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            String token = jwtService.getToken(user);
            
            TokenResponseDTO tokenDTO = new TokenResponseDTO();
            tokenDTO.setToken(token);
            
            return ResponseEntity.ok(tokenDTO);
        } catch (Exception e) {
            throw new MiException("Error de autenticacion clave o password incorrectos", HttpStatus.BAD_REQUEST);
        }
        
        
    }
    
}
