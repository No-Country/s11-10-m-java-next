package com.reparame.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reparame.demo.Repositories.PrestadorRepository;
import com.reparame.demo.entity.Prestador;
import com.reparame.demo.enumeradores.Roles;
import com.reparame.demo.exception.MiException;



@Service
public class PrestadorService {
	
    @Autowired
    PrestadorRepository prestadorRepo;

	public Prestador nuevoPrestador(Prestador prestador) {
		Prestador nuevoPrestador = new Prestador();
		
		nuevoPrestador.setRol(Roles.PRESTADOR);
		nuevoPrestador.setAlta(true);	
		
		nuevoPrestador.setNombreCompleto(prestador.getNombreCompleto());
		nuevoPrestador.setApellidoCompleto(prestador.getApellidoCompleto());
		nuevoPrestador.setUsername(prestador.getUsername());
		nuevoPrestador.setPassword(prestador.getPassword());
		nuevoPrestador.setDNI(prestador.getDNI());
		nuevoPrestador.setDireccion(prestador.getDireccion());
		nuevoPrestador.setNumeroTelefonico(prestador.getNumeroTelefonico());
		nuevoPrestador.setProvincia(prestador.getProvincia());
		nuevoPrestador.setLocalidad(prestador.getLocalidad());	
		nuevoPrestador.setFechaNacimiento(prestador.getFechaNacimiento());
		nuevoPrestador.setZona(prestador.getZona());

	    return prestadorRepo.save(nuevoPrestador);			
	}

	
	public List<Prestador> listarPrestadores() {
		return prestadorRepo.findAll();
	}

	
	public List<Prestador> listarPrestadoresActivos() {
		List<Prestador> listaPrestadores = prestadorRepo.buscarActivos();
		return listaPrestadores;

	}

	
	public Prestador verPrestador(Long id) {
		return prestadorRepo.findById(id).get();
	}

	
	public void eliminarPrestador(Long id) {
		prestadorRepo.deleteById(id);
	}
	

	public Prestador bajaPrestador(Long id) {
		Prestador prestador = prestadorRepo.findById(id).get();
		prestador.setAlta(false);	
	    return prestadorRepo.save(prestador);	
	}

	
	public Prestador modificarPrestador(Long id, Prestador prestador) {
		Prestador prestadorModificado = prestadorRepo.findById(id).get();	
		
		System.out.println(prestador.getNombreCompleto());
		
		prestadorModificado.setNombreCompleto(prestador.getNombreCompleto());
		prestadorModificado.setApellidoCompleto(prestador.getApellidoCompleto());
		prestadorModificado.setUsername(prestador.getUsername());
		prestadorModificado.setPassword(prestador.getPassword());
		prestadorModificado.setDNI(prestador.getDNI());
		prestadorModificado.setDireccion(prestador.getDireccion());
		prestadorModificado.setNumeroTelefonico(prestador.getNumeroTelefonico());
		prestadorModificado.setProvincia(prestador.getProvincia());
		prestadorModificado.setLocalidad(prestador.getLocalidad());	
		prestadorModificado.setFechaNacimiento(prestador.getFechaNacimiento());
		prestadorModificado.setZona(prestador.getZona());
		
	    return prestadorRepo.save(prestadorModificado);	
	}


}
