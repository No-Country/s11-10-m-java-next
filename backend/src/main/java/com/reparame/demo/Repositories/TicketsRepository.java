package com.reparame.demo.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reparame.demo.entity.Ticket;
import com.reparame.demo.entity.Cliente;


public interface TicketsRepository extends JpaRepository<Ticket, Long>{
	
	@Query("SELECT t FROM Ticket t WHERE t.estado = true")
	List <Ticket> findByEstadoTrue();
	
	
	Page<Ticket> findByEstadoTrue(Pageable paginacion);

	List <Ticket> findByCliente(Cliente cliente);

	@Query("SELECT t FROM Ticket t WHERE t.servicio.prestador.username = :usernamePrestador")
    List <Ticket> findByPrestador(@Param("usernamePrestador") String usernamePrestador);

}
