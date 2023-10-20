package com.reparame.demo.Controllers;

import java.util.List;

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
import com.reparame.demo.dtos.requets.DatosActualizarTicketDto;
import com.reparame.demo.dtos.requets.DatosRegistroTicketDto;
import com.reparame.demo.dtos.response.DatosRespuestaTicketDto;
import com.reparame.demo.exception.MiException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketsController {

	private final TicketsService ticketsService;

	// crear los tickets
	@PostMapping("/crear")
	public ResponseEntity<?> nuevoTicket(@RequestBody @Valid DatosRegistroTicketDto nuevoTicket) {

		try {
			DatosRespuestaTicketDto respuestaTicket = ticketsService.crearTicket(nuevoTicket);

			return new ResponseEntity<>(respuestaTicket, HttpStatus.CREATED);
		
		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	
	
	// ver un tiket por id
	@GetMapping("listarPoId/{id}")
	public ResponseEntity<?> listarTicketsPorId(@PathVariable Long id) {

		try {
			DatosRespuestaTicketDto respuestaTicket = ticketsService.buscarPorId(id);
			return new ResponseEntity<>(respuestaTicket, HttpStatus.OK);

		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	// listar todos los tickets
	@GetMapping("listarTodos")
	public ResponseEntity<?> listarTickets() {

		try {
			List<DatosRespuestaTicketDto> listaTickets = ticketsService.listar();
			return new ResponseEntity<List<DatosRespuestaTicketDto>>(listaTickets, HttpStatus.OK);
		
		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//modicicar tickets
	@PostMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarTicket(@RequestBody DatosActualizarTicketDto ticket ,@PathVariable Long id) {

		try {
			DatosRespuestaTicketDto respuestaTicket = ticketsService.actualizarTicket(ticket , id);
			return new ResponseEntity<>(respuestaTicket, HttpStatus.OK);
		
		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	//borrado logico de un ticket de la db
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarTicket(@PathVariable Long id) {

		try {
			 ticketsService.eliminarTicket(id);
			return new ResponseEntity<>("registro eliminado con exito", HttpStatus.OK);
		
		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	//devolver una paginación

    @GetMapping("paginas")
    public ResponseEntity<?> listaPaginaTickets(@PageableDefault(size = 2) Pageable paginacion) {
    	
    	try {
    		Page<DatosRespuestaTicketDto> pageDatosRespuestaTicket = ticketsService.ListadoPaginado(paginacion);
			 return ResponseEntity.ok(pageDatosRespuestaTicket);	
			 
    		} catch (MiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    	
    
        
    }


}
