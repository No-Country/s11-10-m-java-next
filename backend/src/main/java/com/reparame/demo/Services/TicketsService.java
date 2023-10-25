package com.reparame.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reparame.demo.Repositories.TicketsRepository;
import com.reparame.demo.dtos.request.DatosActualizarTicketDTO;
import com.reparame.demo.dtos.request.DatosRegistroTicketDTO;
import com.reparame.demo.dtos.response.DatosRespuestaTicketDTO;
import com.reparame.demo.entity.Calificacion;
import com.reparame.demo.entity.Ticket;
import com.reparame.demo.exception.MiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketsService {

	private final TicketsRepository ticketRepository;

	// crear un ticket
	public DatosRespuestaTicketDTO crearTicket(DatosRegistroTicketDTO nuevoTicket) throws MiException {
		
		Ticket ticket = new Ticket(nuevoTicket);
		
		try {
			ticketRepository.save(ticket);
		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}

		DatosRespuestaTicketDTO respuestaTicket = new DatosRespuestaTicketDTO(ticket);

		return respuestaTicket;
	}

	// listar todos los tickets
	public List<DatosRespuestaTicketDTO> listar() throws MiException {
		try {
			//List<Ticket> ticketList = ticketRepository.findAll();
			List<Ticket> ticketList = ticketRepository.findByEstadoTrue();

			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			List<DatosRespuestaTicketDTO> datosRespuestaList = ticketList.stream()
															.map(DatosRespuestaTicketDTO::new) 
															.collect(Collectors.toList());
			return datosRespuestaList;

		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}
	}

	//buscar tickets por id
	public DatosRespuestaTicketDTO buscarPorId(Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			DatosRespuestaTicketDTO respuestaTicket = new DatosRespuestaTicketDTO(ticket);
			return respuestaTicket;


		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}


	}
	
	// Actualizar los tickets
	public DatosRespuestaTicketDTO actualizarTicket(DatosActualizarTicketDTO actualizarTicket, Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			ticket.actualizarDatos(actualizarTicket);
			ticketRepository.save(ticket);
			DatosRespuestaTicketDTO respuestaTicket = new DatosRespuestaTicketDTO(ticket);
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
	public Page<DatosRespuestaTicketDTO> ListadoPaginado( Pageable paginacion) throws MiException {

		try {
			
		Page<Ticket> pageTickets = ticketRepository.findByEstadoTrue(paginacion); // Obtiene la página de Tickets
        Page<DatosRespuestaTicketDTO> pageDatosRespuestaTicket = pageTickets.map(DatosRespuestaTicketDTO::new); // Mapea la página de Tickets a una página de DatosRespuestaTicket
        return pageDatosRespuestaTicket;
		
		} catch (Exception e) {
			throw new MiException(e.getMessage());		
		}
        
	}

        
        public String calificar(Long id, Calificacion calificacion) throws MiException{
            try {
                Ticket ticket = ticketRepository.findById(id).get();
                ticket.setCalificacion(calificacion);
                ticketRepository.save(ticket);
                return "";
            } catch (Exception e) {
                throw new MiException(e.getMessage());
            }
            
            
        } 
        
        
       
        
        

}
