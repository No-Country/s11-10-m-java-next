package com.reparame.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reparame.demo.entity.Prestador;


@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {
	
	
}
