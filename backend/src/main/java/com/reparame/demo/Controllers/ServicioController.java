/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Controllers;


import com.reparame.demo.Services.ServicioService;
import com.reparame.demo.dtos.request.DatosRegistroServicioDTO;
import com.reparame.demo.dtos.response.DatosRespuestaServicioDTO;
import com.reparame.demo.entity.Prestador;
import com.reparame.demo.entity.Servicio;
import com.reparame.demo.enumeradores.Rubros;
import com.reparame.demo.exception.MiException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService servicioServ;

    @PostMapping("/{id}")

    public ResponseEntity<?> crearServicio(@RequestBody DatosRegistroServicioDTO nuevoServicio, @PathVariable("id") Long id) {
        try {
            DatosRespuestaServicioDTO respuestaServicio = servicioServ.crearServicio(nuevoServicio, id);
            return new ResponseEntity<>(respuestaServicio, HttpStatus.CREATED);
        } catch (MiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("")
    public ResponseEntity<?> listarServiciosActivos(@RequestParam(name = "categoria", required = false) Rubros categoria) throws MiException {
        List<DatosRespuestaServicioDTO> listaServicios = null;
        if (categoria != null) {
            listaServicios = servicioServ.listarPorCategoria(categoria);
        } else {
            listaServicios = servicioServ.listar();
        }
        return new ResponseEntity<>(listaServicios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorID(@PathVariable("id") Long id) {
        try {
            DatosRespuestaServicioDTO servicioDTO = servicioServ.buscarPorId(id);
            return new ResponseEntity<>(servicioDTO, HttpStatus.OK);
        } catch (MiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/darBaja/{id}")
    public ResponseEntity<Servicio> darBaja(@PathVariable("id") Long id) {
        try {
            Servicio servicio = servicioServ.bajaServicio(id);
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestador(@PathVariable("id") Long id) {
        servicioServ.eliminarServicio(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> modificar(@PathVariable("id") Long id, @RequestBody Servicio servicio) {
        try {
            Servicio servicioModificado = servicioServ.modificarServicio(id, servicio);
            return new ResponseEntity<>(servicioModificado, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

   
}


