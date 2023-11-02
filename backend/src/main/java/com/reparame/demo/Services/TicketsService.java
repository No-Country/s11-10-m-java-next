package com.reparame.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reparame.demo.Repositories.CalificacionRepository;
import com.reparame.demo.Repositories.PrestadorRepository;
import com.reparame.demo.Repositories.ServicioRepository;
import com.reparame.demo.Repositories.TicketsRepository;
import com.reparame.demo.dtos.request.DatosActualizarTicketDTO;
import com.reparame.demo.dtos.request.DatosCalificacionDTO;
import com.reparame.demo.dtos.request.DatosRegistroTicketDTO;
import com.reparame.demo.dtos.response.DatosRespuestaTicketDTO;
import com.reparame.demo.entity.Calificacion;
import com.reparame.demo.entity.Cliente;
import com.reparame.demo.entity.Servicio;
import com.reparame.demo.entity.Imagen;
import com.reparame.demo.entity.Prestador;
import com.reparame.demo.entity.Ticket;
import com.reparame.demo.enumeradores.ProgresoTicket;
import com.reparame.demo.exception.MiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketsService {

	private final TicketsRepository ticketRepository;
	private final ClienteService clienteService;
	private final PrestadorService prestadorService;
	
	@Autowired
	ServicioRepository servicioRepository;
	
	@Autowired
	CalificacionRepository calificacionRepository;	

	@Autowired
    private ModelMapper modelMapper;

	// crear un ticket
	public DatosRespuestaTicketDTO crearTicket(DatosRegistroTicketDTO nuevoTicket, Long id, String usernameCliente) 
	throws MiException {
        Ticket ticket = new Ticket(nuevoTicket);
        
		try {
	        Cliente cliente = clienteService.getByUsername(usernameCliente);
			Servicio servicio = servicioRepository.findById(id).get();
	        ticket.setCliente(cliente);
			ticket.setServicio(servicio);
			ticket.setProgreso(ProgresoTicket.SOLICITADO);
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
			//Cliente cliente = clienteService.getByUsername(usernameCliente);
			//List<Ticket> tickets = ticketRepository.findByCliente(cliente);

			List<Ticket> tickets = ticketRepository.findAll();

			
			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			List<DatosRespuestaTicketDTO> datosRespuestaList = tickets.stream()
															.map(DatosRespuestaTicketDTO::new) 
															.collect(Collectors.toList());
			return datosRespuestaList;

		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}
	}

	//buscar tickets por id
	public DatosRespuestaTicketDTO buscarPorId(Long id, String username) throws MiException {
		try {
			Cliente cliente = clienteService.getByUsername(username);
			Ticket ticket = ticketRepository.findById(id).get();
			if (ticket.getCliente() != cliente){
				throw new MiException("No puedes calificar este ticket");
			}else{
				DatosRespuestaTicketDTO respuestaTicket = new DatosRespuestaTicketDTO(ticket);
				return respuestaTicket;
			}
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

        
	public Calificacion calificar(Long id, DatosCalificacionDTO datosCalificacionDTO, String username) 
	throws MiException{
		try {
			Cliente cliente = clienteService.getByUsername(username);
			Ticket ticket = ticketRepository.findById(id).get();

			if (ticket.getCliente() != cliente){
				throw new MiException("No puedes calificar este ticket");
			}else{
				Calificacion calificacion = modelMapper.map(datosCalificacionDTO,Calificacion.class);
				calificacion.setTicket(ticket);
				Calificacion nuevacalificacion = calificacionRepository.save(calificacion);
				ticket.setCalificacion(nuevacalificacion);
				ticketRepository.save(ticket);
				return nuevacalificacion;
			}
 
		} catch (Exception e) {
			throw new MiException("El ticket no existe , o ya tiene calificación");
		}
	}

	//obtener los tickets del prestador autenticado, por eso se pasa el username que viene de la peticion

	public List<DatosRespuestaTicketDTO> listadoPorPrestador(String username) throws MiException{
		try{
			//estador = prestadorService.getByUsername(username);
			List <Ticket> tickets = ticketRepository.findByPrestador(username);

			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			List<DatosRespuestaTicketDTO> datosRespuestaList = tickets.stream()
															.map(DatosRespuestaTicketDTO::new) 
															.collect(Collectors.toList());
			return datosRespuestaList;

		} catch (Exception e) {
			throw new MiException("No se encontro el prestador");
		}
	}

	public List<DatosRespuestaTicketDTO> listadorPorCliente(String username) throws MiException{
		try{
			Cliente cliente = clienteService.getByUsername(username);
			List<Ticket> tickets = ticketRepository.findByCliente(cliente);

			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			List<DatosRespuestaTicketDTO> datosRespuestaList = tickets.stream()
															.map(DatosRespuestaTicketDTO::new) 
															.collect(Collectors.toList());
			return datosRespuestaList;

		} catch (Exception e) {
			throw new MiException("No se encontro el cliente");
		}
	}


	/* public List<TicketClienteDTO> listadorPorCliente(String username) throws MiException{
		try{
			Cliente cliente = clienteService.getByUsername(username);
			List<Ticket> tickets = ticketRepository.findByCliente(cliente);

			List<TicketClienteDTO> ticketsDTO = tickets.stream().map(ticket -> {
				Prestador prestador = ticket.getServicio().getPrestador();
                TicketClienteDTO ticketDTO = modelMapper.map(ticket, TicketClienteDTO.class);
                ticketDTO.setPrestador(modelMapper.map(prestador, PrestadorServicioListadoDTO.class));
                return ticketDTO;
            }).collect(Collectors.toList());
			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			return ticketsDTO;

		} catch (Exception e) {
			throw new MiException("No se encontro el cliente");
		}
	} */
}
