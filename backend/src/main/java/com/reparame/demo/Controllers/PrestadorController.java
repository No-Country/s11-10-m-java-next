package com.reparame.demo.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reparame.demo.Services.PrestadorService;
import com.reparame.demo.Services.ServicioService;
import com.reparame.demo.dtos.Prestador.DetallePrestadorDTO;
import com.reparame.demo.entity.Prestador;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;


import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/prestadores")
@RequiredArgsConstructor
public class PrestadorController {
	
    private final PrestadorService prestadorService;
	
    @PostMapping("")
    public ResponseEntity<Prestador> nuevoPrestador(@RequestBody Prestador prestador){
    	try {
        	Prestador nuevoPrestador = prestadorService.nuevoPrestador(prestador);    	
        	return new ResponseEntity<>(nuevoPrestador, HttpStatus.OK);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    }
	
    @GetMapping("")
    public ResponseEntity<List<DetallePrestadorDTO>> listarPrestadores(){
        List<Prestador> prestadores = prestadorService.listarPrestadoresActivos();
        if (!prestadores.isEmpty()) {
            List<DetallePrestadorDTO> prestadoresDTO = new ArrayList<>();
            
            for (Prestador prestador : prestadores) {
                DetallePrestadorDTO prestadorDTO = new DetallePrestadorDTO(prestador);
                prestadoresDTO.add(prestadorDTO);
            }
            
            return ResponseEntity.ok(prestadoresDTO);
        } 
        
        return ResponseEntity.notFound().build();
        
    }
    
    
    /*
    @GetMapping("/listarActivos")
    public List<Prestador> listarPrestadoresActivos(){
        return prestadorService.listarPrestadoresActivos();
    }*/
    
    
    @GetMapping("/{id}")
    public ResponseEntity<DetallePrestadorDTO> verPrestador(@PathVariable("id") Long id){
        try {
                Prestador prestador = prestadorService.verPrestador(id);
                DetallePrestadorDTO detallePrestadorDTO = new DetallePrestadorDTO(prestador);
            return new ResponseEntity<>(detallePrestadorDTO, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/darBaja/{id}")
    public ResponseEntity<Prestador> bajaPrestador(@PathVariable("id") Long id){
        try {
        	Prestador prestador = prestadorService.bajaPrestador(id);      	
            return new ResponseEntity<>(prestador, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }    
    
    @DeleteMapping("/{id}")
    public void eliminarPrestador(@PathVariable("id") Long id){
    	prestadorService.eliminarPrestador(id);
    }       
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Prestador> modificarPrestador(@PathVariable("id") Long id, 
    		@RequestBody Prestador prestador){
    	try {
        	Prestador prestadorModificado = prestadorService.modificarPrestador(id, prestador);    	
        	return new ResponseEntity<>(prestadorModificado, HttpStatus.OK);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    	
    }
    
    @PutMapping("/cambiarfoto")
    public ResponseEntity<?> cambiarfoto (@RequestBody Map<String, Long> datos){
    	try {
			Long idImagen = datos.get("idImagen");
			Long idPrestador = datos.get("idPrestador");
        	Prestador prestadorModificado = prestadorService.cambiarFoto(idPrestador, idImagen);
    		return new ResponseEntity<>(prestadorModificado, HttpStatus.OK);
    	} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    	}
    	
    }      
    


    

  


    


}
