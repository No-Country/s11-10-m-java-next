/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reparame.demo.Repositories;

import com.reparame.demo.entity.Servicio;
import com.reparame.demo.enumeradores.Rubros;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long>{
    @Query("SELECT s FROM Servicio s WHERE s.alta = true")
    List<Servicio> findByEstadoTrue();
    
    @Query("SELECT s FROM Servicio s WHERE s.rubro = :categoria")
    List<Servicio> findByCategoria(@Param("categoria") Rubros categoria);

}
