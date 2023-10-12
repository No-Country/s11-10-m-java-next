package com.reparame.demo.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reparame.demo.entity.Ticket;

public interface TicketsRepository extends JpaRepository<Ticket, Long>{
	
	@Query("SELECT t FROM Ticket t WHERE t.estado = true")
	List <Ticket> findByEstadoTrue();
	
	
	Page<Ticket> findByEstadoTrue(Pageable paginacion);

}
