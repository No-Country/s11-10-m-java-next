package com.reparame.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reparame.demo.Services.PrestadorService;
import com.reparame.demo.entity.Prestador;



@RestController
public class PrestadorController {
	
    @Autowired
    private PrestadorService prestadorService;
	
	
    @GetMapping("/prestadores")
    public List<Prestador> listarPrestadores(){
        return prestadorService.listarPrestadores();
    }
    
    
    @GetMapping("/prestadores/{id}")
    public ResponseEntity<Prestador> verPrestador(@PathVariable("id") Long id){
        try {
        	Prestador prestador = prestadorService.verPrestador(id);      	
            return new ResponseEntity<>(prestador, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }
    
    
    
    
    @DeleteMapping("/prestadores/{id}")
    public void eliminarPrestador(@PathVariable("id") Long id){
    	prestadorService.eliminarPrestador(id);
    }    
    
    @GetMapping("/baja-prestador/{id}")
    public ResponseEntity<Prestador> bajaPrestador(@PathVariable("id") Long id){
        try {
        	Prestador prestador = prestadorService.bajaPrestador(id);      	
            return new ResponseEntity<>(prestador, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    } 
  
    @PostMapping("/prestadores")
    public ResponseEntity<Prestador> nuevoPrestador(@RequestBody Prestador prestador){
    	try {
        	Prestador nuevoPrestador = prestadorService.nuevoPrestador(prestador);    	
        	return new ResponseEntity<>(nuevoPrestador, HttpStatus.OK);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    }

    
    @PutMapping("/prestadores/{id}")
    public ResponseEntity<Prestador> modificarPrestador(@PathVariable("id") Long id, 
    		@RequestBody Prestador prestador){
    	try {
        	Prestador prestadorModificado = prestadorService.modificarPrestador(id, prestador);    	
        	return new ResponseEntity<>(prestadorModificado, HttpStatus.OK);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    	
    }

}
