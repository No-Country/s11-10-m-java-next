/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Controllers;

import com.reparame.demo.Services.ServicioService;
import com.reparame.demo.entity.Servicio;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/servicio")
public class ServicioController {
    private final ServicioService servicioServ;
    
    @PostMapping("/crear")
    public ResponseEntity<Servicio> nuevoServicio(@RequestBody Servicio servicio){
        try {
            Servicio servicioNuevo = servicioServ.nuevoServicio(servicio);
            return new ResponseEntity<>(servicioNuevo, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @GetMapping("/listar")
    public List<Servicio> listarServicios(){
        return servicioServ.listarServicios();
    }
    
    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<Servicio> buscarPorID(@PathVariable("id") Long id){
        try {
            Servicio servicio = servicioServ.buscarPorID(id).get();
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @PutMapping("/darBaja/{id}")
    public ResponseEntity<Servicio> darBaja(@PathVariable("id") Long id){
        try {
            Servicio servicio = servicioServ.bajaServicio(id);
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @PutMapping("/finalizado/{id}")
    public ResponseEntity<Servicio> finalizado(@PathVariable("id") Long id){
        try {
            Servicio servicio = servicioServ.finalizarServicio(id);
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPrestador(@PathVariable("id") Long id){
    	servicioServ.eliminarServicio(id);
    } 

}
