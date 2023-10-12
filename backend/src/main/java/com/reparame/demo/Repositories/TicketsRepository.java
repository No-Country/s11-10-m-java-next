package com.reparame.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reparame.demo.entity.Ticket;

public interface TicketsRepository extends JpaRepository<Ticket, Long>{

}
