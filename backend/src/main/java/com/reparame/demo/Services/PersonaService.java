/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Services;

import com.reparame.demo.Repositories.ClienteRepository;
import com.reparame.demo.Repositories.PrestadorRepository;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Prestador;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
@RequiredArgsConstructor
public class PersonaService {

    private final ClienteRepository clienteRepository;
    private final PrestadorRepository prestadorRepository;

    public UserDetails findUserByUsername(String username) {
        UserDetails user;
        Optional<Prestador> prestadorOptional = prestadorRepository.findByUsername(username);
        if (prestadorOptional.isPresent()) {
            user = prestadorOptional.get();
            return user;
        } else {
            Optional<Cliente> clienteOptional = clienteRepository.findByUsername(username);
            if (clienteOptional.isPresent()) {
                user = clienteOptional.get();
                return user;
            } else {
                return null;
            }
        }
    }
    
    
}
