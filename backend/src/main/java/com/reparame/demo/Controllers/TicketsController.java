package com.reparame.demo.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reparame.demo.Services.TicketsService;
import com.reparame.demo.dtos.request.DatosActualizarTicketDTO;
import com.reparame.demo.dtos.request.DatosRegistroTicketDTO;
import com.reparame.demo.dtos.response.DatosRespuestaTicketDTO;
import com.reparame.demo.entity.Calificacion;
import com.reparame.demo.exception.MiException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor

public class TicketsController {


	private final TicketsService ticketsService;
//	private final TicketsRepository ticketsRepository;

	// crear los tickets
	@PostMapping("{idCliente}")
	public ResponseEntity<?> nuevoTicket(@RequestBody @Valid DatosRegistroTicketDTO nuevoTicket, @PathVariable("idCliente") Long id) {

		try {
			DatosRespuestaTicketDTO respuestaTicket = ticketsService.crearTicket(nuevoTicket, id);

			return new ResponseEntity<>(respuestaTicket, HttpStatus.CREATED);

		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Obtener un ticket por ID
	@GetMapping("/{id}")
    public ResponseEntity<?> listarTicketsPorId(@PathVariable Long id) {

		try {
			DatosRespuestaTicketDTO ticket = ticketsService.buscarPorId(id);
			return new ResponseEntity<DatosRespuestaTicketDTO>(ticket, HttpStatus.OK);
		
		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}	
	
	// Listar todos los tickets
	@GetMapping("")
    public ResponseEntity<?> listarTickets() {
            try {
                    List<DatosRespuestaTicketDTO> listaTickets = ticketsService.listar();

                    return new ResponseEntity<>(listaTickets, HttpStatus.OK);
            } catch (MiException e) {
                    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }



	// modificar tickets
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarTicket(@RequestBody DatosActualizarTicketDTO ticket, @PathVariable Long id) {

		try {
			DatosRespuestaTicketDTO respuestaTicket = ticketsService.actualizarTicket(ticket, id);
			return new ResponseEntity<>(respuestaTicket, HttpStatus.OK);

		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}



	// borrado logico de un ticket de la db
	@PutMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarTicket(@PathVariable Long id) {
		try {
			ticketsService.eliminarTicket(id);
			return new ResponseEntity<>("registro eliminado con exito", HttpStatus.OK);

		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

//	// borra un ticket definitivo de la db
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> eliminarTicket(@PathVariable Long id) {
//
//		try {
//			ticketsService.eliminarTicket(id);
//			return new ResponseEntity<>("registro eliminado con exito", HttpStatus.OK);
//		} catch (MiException e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//
//	}

	@GetMapping("paginas")
	public ResponseEntity<?> listaPaginaTickets(@PageableDefault(size = 2) Pageable paginacion) {

		try {
			Page<DatosRespuestaTicketDTO> pageDatosRespuestaTicket = ticketsService.ListadoPaginado(paginacion);
			return ResponseEntity.ok(pageDatosRespuestaTicket);

		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{id}/calificar")
	public ResponseEntity<String> calificarTicket(@PathVariable Long id, @RequestBody Calificacion calificacion) {
		try {
			ticketsService.calificar(id, calificacion);
			return new ResponseEntity<String>("ticket calificado exitosamente", HttpStatus.OK);
		} catch (MiException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
    @PutMapping("/vincularservicio")
    public ResponseEntity<String> vincularServicio (@RequestBody Map<String, Long> datos){
    	try {
			Long idTicket = datos.get("idTicket");
			Long idServicio = datos.get("idServicio");
			ticketsService.vincularServicio(idServicio, idTicket);
    		return new ResponseEntity<String>("Servicio asignado", HttpStatus.OK);
    	} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    	}
    	
    }    

}