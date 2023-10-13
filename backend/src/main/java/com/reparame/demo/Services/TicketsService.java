package com.reparame.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reparame.demo.Repositories.TicketsRepository;
import com.reparame.demo.dtos.DatosActualizarTicket;
import com.reparame.demo.dtos.DatosRegistroTicket;
import com.reparame.demo.dtos.DatosRespuestaTicket;
import com.reparame.demo.entity.Ticket;
import com.reparame.demo.exception.MiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketsService {

	private final TicketsRepository ticketRepository;

	// crear un ticket
	public DatosRespuestaTicket crearTicket(DatosRegistroTicket nuevoTicket) throws MiException {

		Ticket ticket = new Ticket(nuevoTicket);

		try {
			ticketRepository.save(ticket);
		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}

		DatosRespuestaTicket respuestaTicket = new DatosRespuestaTicket(ticket);

		return respuestaTicket;
	}

	// listar todos los tickets
	public List<DatosRespuestaTicket> listar() throws MiException {
		try {
			//List<Ticket> ticketList = ticketRepository.findAll();
			List<Ticket> ticketList = ticketRepository.findByEstadoTrue();

			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			List<DatosRespuestaTicket> datosRespuestaList = ticketList.stream()
															.map(DatosRespuestaTicket::new) 
															.collect(Collectors.toList());
			return datosRespuestaList;

		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}
	}

	//buscar tickets por id
	public DatosRespuestaTicket buscarPorId(Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			DatosRespuestaTicket respuestaTicket = new DatosRespuestaTicket(ticket);
			return respuestaTicket;


		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}


	}
	
	// Actualizar los tickets
	public DatosRespuestaTicket actualizarTicket(DatosActualizarTicket actualizarTicket, Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			ticket.actualizarDatos(actualizarTicket);
			ticketRepository.save(ticket);
			DatosRespuestaTicket respuestaTicket = new DatosRespuestaTicket(ticket);
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
	public Page<DatosRespuestaTicket> ListadoPaginado( Pageable paginacion) throws MiException {

		try {
			
		Page<Ticket> pageTickets = ticketRepository.findByEstadoTrue(paginacion); // Obtiene la página de Tickets
        Page<DatosRespuestaTicket> pageDatosRespuestaTicket = pageTickets.map(DatosRespuestaTicket::new); // Mapea la página de Tickets a una página de DatosRespuestaTicket
        return pageDatosRespuestaTicket;
		
		} catch (Exception e) {
			throw new MiException(e.getMessage());		
		}
        
	}

}
