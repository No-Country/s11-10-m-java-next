/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Services;

import com.reparame.demo.Repositories.ClienteRepository;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.enumeradores.Roles;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepo;
    
    public Cliente nuevoCliente(Cliente cliente){
        Cliente nuevoCliente = new Cliente();
        
        nuevoCliente.setRol(Roles.CLIENTE);
        nuevoCliente.setAlta(true);
        
        nuevoCliente.setNombreCompleto(cliente.getNombreCompleto());
        nuevoCliente.setApellidoCompleto(cliente.getApellidoCompleto());
        nuevoCliente.setUsername(cliente.getUsername());
        nuevoCliente.setPassword(cliente.getPassword());
        nuevoCliente.setDNI(cliente.getDNI());
        nuevoCliente.setDireccion(cliente.getDireccion());
        nuevoCliente.setNumeroTelefonico(cliente.getNumeroTelefonico());
        nuevoCliente.setProvincia(cliente.getProvincia());
        nuevoCliente.setLocalidad(cliente.getLocalidad());
        nuevoCliente.setFechaNacimiento(cliente.getFechaNacimiento());
        nuevoCliente.setZona(cliente.getZona());
        
        return clienteRepo.save(nuevoCliente);
    }
    
    public List<Cliente> listarClientes() {
	return clienteRepo.findAll();
    }
    
    public Optional<Cliente> buscarPorID(Long id){
        return clienteRepo.findById(id);
    }
    
    public void eliminarCliente(Long id){
        clienteRepo.deleteById(id);
    }
    
    public Cliente bajaCliente(Long id){
        Cliente cliente = clienteRepo.findById(id).get();
        cliente.setAlta(false);
        return clienteRepo.save(cliente);
    }
    
    public Cliente modificarCliente(Long id, Cliente cliente) {
	Cliente clienteModificado = clienteRepo.findById(id).get();	
		
	clienteModificado.setNombreCompleto(cliente.getNombreCompleto());
	clienteModificado.setApellidoCompleto(cliente.getApellidoCompleto());
	clienteModificado.setUsername(cliente.getUsername());
	clienteModificado.setPassword(cliente.getPassword());
	clienteModificado.setDNI(cliente.getDNI());
	clienteModificado.setDireccion(cliente.getDireccion());
	clienteModificado.setNumeroTelefonico(cliente.getNumeroTelefonico());
	clienteModificado.setProvincia(cliente.getProvincia());
	clienteModificado.setLocalidad(cliente.getLocalidad());	
	clienteModificado.setFechaNacimiento(cliente.getFechaNacimiento());
	clienteModificado.setZona(cliente.getZona());
		
	return clienteRepo.save(clienteModificado);	
    }
}
