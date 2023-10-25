package com.reparame.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reparame.demo.entity.Prestador;
import java.util.Optional;
import org.springframework.data.repository.query.Param;


@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {
	
	@Query("SELECT p FROM Prestador p WHERE p.alta = true")
	List <Prestador> buscarActivos();
	
        @Query("SELECT p FROM Prestador p WHERE p.username = :username")
        Optional<Prestador> findByUsername(@Param("username") String username); 
}
