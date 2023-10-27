/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Services;

import com.reparame.demo.Repositories.PrestadorRepository;
import com.reparame.demo.Repositories.ServicioRepository;
import com.reparame.demo.dtos.request.DatosRegistroServicioDTO;
import com.reparame.demo.dtos.request.RegistroServicioDTO;
import com.reparame.demo.dtos.response.DatosRespuestaServicioDTO;
import com.reparame.demo.dtos.response.PrestadorServicioListadoDTO;
import com.reparame.demo.dtos.response.ServicioListadoDTO;
import com.reparame.demo.entity.Prestador;
import com.reparame.demo.entity.Servicio;
import com.reparame.demo.enumeradores.Rubros;
import com.reparame.demo.exception.MiException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
@RequiredArgsConstructor
public class ServicioService {

    private final ServicioRepository servicioRep;
    private final PrestadorService prestadorService;
    

    @Autowired
    private ModelMapper modelMapper;

    /* public DatosRespuestaServicioDTO crearServicio(DatosRegistroServicioDTO nuevoServicio, Long idPrestador) throws MiException {
        Servicio servicio = new Servicio(nuevoServicio);

        try {
            Prestador prestador = prestadorService.verPrestador(idPrestador);
            servicio.setPrestador(prestador);
            servicioRep.save(servicio);
        } catch (Exception e) {
            throw new MiException(e.getMessage());
        }

        DatosRespuestaServicioDTO respuestaServicio = new DatosRespuestaServicioDTO(servicio);
        return respuestaServicio;
    } */

    public Servicio crear(RegistroServicioDTO registroServicioDTO, String username) throws MiException {
        try {
            Prestador prestador = prestadorService.getByUsername(username);
            Servicio servicio = modelMapper.map(registroServicioDTO, Servicio.class);
            servicio.setPrestador(prestador);
            servicio.setAlta(true);
            servicioRep.save(servicio);
            return servicio;
        } catch (Exception e) {
            throw new MiException(e.getMessage());
        }
    }

    public List<ServicioListadoDTO> listar() throws MiException {
        try {
            List<Servicio> servicioLista = servicioRep.findByEstadoTrue();

            List<ServicioListadoDTO> datosRespuestaList = servicioLista.stream().map(servicio -> {
                ServicioListadoDTO servicioListadoDTO = modelMapper.map(servicio, ServicioListadoDTO.class);
                servicioListadoDTO.setPrestador(modelMapper.map(servicioListadoDTO.getPrestador(), PrestadorServicioListadoDTO.class));
                return servicioListadoDTO;
            }).collect(Collectors.toList());

            return datosRespuestaList;

        } catch (Exception e) {
            throw new MiException(e.getMessage());
        }
    }

    public List<ServicioListadoDTO> listarPorCategoria(Rubros categoria) {
        List<Servicio> servicioLista = servicioRep.findByCategoria(categoria);
        List<ServicioListadoDTO> datosRespuestaList = servicioLista.stream().map(servicio -> {
                ServicioListadoDTO servicioListadoDTO = modelMapper.map(servicio, ServicioListadoDTO.class);
                servicioListadoDTO.setPrestador(modelMapper.map(servicioListadoDTO.getPrestador(), PrestadorServicioListadoDTO.class));
                return servicioListadoDTO;
            }).collect(Collectors.toList());

        return datosRespuestaList;
    }

    public DatosRespuestaServicioDTO buscarPorId(Long id) throws MiException {
        try {
            Servicio servicio = servicioRep.findById(id).get();
            DatosRespuestaServicioDTO respuestaServicio = new DatosRespuestaServicioDTO(servicio);
            return respuestaServicio;

        } catch (Exception e) {
            throw new MiException(e.getMessage());
        }
    }

    public void eliminarServicio(Long id) {
        servicioRep.deleteById(id);
    }

    public Servicio bajaServicio(Long id) {
        Servicio servicio = servicioRep.findById(id).get();
        servicio.setAlta(false);
        return servicioRep.save(servicio);
    }

    public Servicio modificarServicio(Long id, Servicio servicio) {
        Servicio servicioModificado = servicioRep.findById(id).get();

        servicioModificado.setDescripcion(servicio.getDescripcion());
        servicioModificado.setAñosSector(servicio.getAñosSector());
        servicioModificado.setPrecio(servicio.getPrecio());
        servicioModificado.setRubro(servicio.getRubro());

        return servicioRep.save(servicioModificado);
    }


}
