package com.reparame.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reparame.demo.Repositories.TicketsRepository;
import com.reparame.demo.dtos.requets.DatosActualizarTicketDto;
import com.reparame.demo.dtos.requets.DatosRegistroTicketDto;
import com.reparame.demo.dtos.response.DatosRespuestaTicketDto;
import com.reparame.demo.entity.Ticket;
import com.reparame.demo.exception.MiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketsService {

	private final TicketsRepository ticketRepository;

	// crear un ticket
	public DatosRespuestaTicketDto crearTicket(DatosRegistroTicketDto nuevoTicket) throws MiException {
		
		Ticket ticket = new Ticket(nuevoTicket);
		
		try {
			

			ticketRepository.save(ticket);
		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}

		DatosRespuestaTicketDto respuestaTicket = new DatosRespuestaTicketDto(ticket);

		return respuestaTicket;
	}

	// listar todos los tickets
	public List<DatosRespuestaTicketDto> listar() throws MiException {
		try {
			//List<Ticket> ticketList = ticketRepository.findAll();
			List<Ticket> ticketList = ticketRepository.findByEstadoTrue();

			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			List<DatosRespuestaTicketDto> datosRespuestaList = ticketList.stream()
															.map(DatosRespuestaTicketDto::new) 
															.collect(Collectors.toList());
			return datosRespuestaList;

		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}
	}

	//buscar tickets por id
	public DatosRespuestaTicketDto buscarPorId(Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			DatosRespuestaTicketDto respuestaTicket = new DatosRespuestaTicketDto(ticket);
			return respuestaTicket;


		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}


	}
	
	// Actualizar los tickets
	public DatosRespuestaTicketDto actualizarTicket(DatosActualizarTicketDto actualizarTicket, Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			ticket.actualizarDatos(actualizarTicket);
			ticketRepository.save(ticket);
			DatosRespuestaTicketDto respuestaTicket = new DatosRespuestaTicketDto(ticket);
			return respuestaTicket;


		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}
	}

	//borrar ticket
	public void eliminarTicket(Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			ticket.desactivarTicket();
			ticketRepository.save(ticket);


		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}

		
	}

	//devuelve una lista de paginas con tickets
	public Page<DatosRespuestaTicketDto> ListadoPaginado( Pageable paginacion) throws MiException {

		try {
			
		Page<Ticket> pageTickets = ticketRepository.findByEstadoTrue(paginacion); // Obtiene la página de Tickets
        Page<DatosRespuestaTicketDto> pageDatosRespuestaTicket = pageTickets.map(DatosRespuestaTicketDto::new); // Mapea la página de Tickets a una página de DatosRespuestaTicket
        return pageDatosRespuestaTicket;
		
		} catch (Exception e) {
			throw new MiException(e.getMessage());		
		}
        
	}

}
