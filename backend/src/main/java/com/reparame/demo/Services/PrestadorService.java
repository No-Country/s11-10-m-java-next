package com.reparame.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.reparame.demo.Repositories.PrestadorRepository;
import com.reparame.demo.entity.Imagen;
import com.reparame.demo.entity.Prestador;
import com.reparame.demo.enumeradores.Roles;
import com.reparame.demo.exception.MiException;
import java.util.Optional;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class PrestadorService {
	
    private final PrestadorRepository prestadorRepo;
    
	@Autowired
	private ImagenService imagenService;

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
                Prestador prestador = prestadorRepo.findById(id).get();
		return prestador;
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

	public Prestador cambiarFoto(Long id, Long idImagen)  throws Exception{
		try {
			Prestador prestadorModificado = prestadorRepo.findById(id).get();
			Imagen foto = imagenService.getOne(idImagen).get();
			prestadorModificado.setFoto(foto);	
			return prestadorRepo.save(prestadorModificado);
		} catch (Exception e) {
			throw new Exception("no existe prestador o imagen con ese id");
		}
	}

        public boolean prestadorExiste(String ussername){
            Optional<Prestador> prestador = prestadorRepo.findByUsername(ussername);
            return prestador.isPresent();
        }
        
}
