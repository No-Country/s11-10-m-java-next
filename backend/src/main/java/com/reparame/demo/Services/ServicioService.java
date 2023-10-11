/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Services;

import com.reparame.demo.Repositories.ServicioRepository;
import com.reparame.demo.entity.Servicio;
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
public class ServicioService {
    
    private final ServicioRepository servicioRep;
    
    public Servicio nuevoServicio(Servicio servicio){
        Servicio nuevoServicio = new Servicio();
        
        nuevoServicio.setDescripcion(servicio.getDescripcion());
        nuevoServicio.setAñosSector(servicio.getAñosSector());
        nuevoServicio.setPrecio(servicio.getPrecio());
        nuevoServicio.setRubro(servicio.getRubro());
        nuevoServicio.setAlta(true);
        
        return servicioRep.save(nuevoServicio);
    }
    
    public List<Servicio> listarServicios(){
        return servicioRep.findAll();
    }
    
    public Optional<Servicio> buscarPorID(Long id){
        return servicioRep.findById(id);
    }
    
    public void eliminarServicio(Long id){
        servicioRep.deleteById(id);
    }
    
    public Servicio bajaServicio(Long id){
        Servicio servicio = servicioRep.findById(id).get();
        servicio.setAlta(false);
        return servicioRep.save(servicio);
    }
    
    public Servicio modificarServicio(Long id, Servicio servicio){
        Servicio servicioModificado = servicioRep.findById(id).get();
        
        servicioModificado.setDescripcion(servicio.getDescripcion());
        servicioModificado.setAñosSector(servicio.getAñosSector());
        servicioModificado.setPrecio(servicio.getPrecio());
        servicioModificado.setRubro(servicio.getRubro());
        
        return servicioRep.save(servicioModificado);
    }
    
    
    
}
