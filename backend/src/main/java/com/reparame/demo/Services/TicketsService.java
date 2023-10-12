package com.reparame.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

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
			List<Ticket> ticketList = ticketRepository.findAll();

			// Mapear la lista de Ticket a una lista de DatosRespuestaTicket
			List<DatosRespuestaTicket> datosRespuestaList = ticketList.stream().map(DatosRespuestaTicket::new) // Usar
																												// el
																												// constructor
																												// que
																												// acepta
																												// un
																												// Ticket
					.collect(Collectors.toList());

			return datosRespuestaList;

		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}
	}

	public DatosRespuestaTicket buscarPorId(Long id) throws MiException {
		try {
			Ticket ticket = ticketRepository.findById(id).get();
			DatosRespuestaTicket respuestaTicket = new DatosRespuestaTicket(ticket);
			return respuestaTicket;


		} catch (Exception e) {
			throw new MiException(e.getMessage());
		}


	}

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

}
