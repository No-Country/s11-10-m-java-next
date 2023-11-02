/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reparame.demo.Repositories;

import com.reparame.demo.entity.Cliente;
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
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    @Query("SELECT c FROM Cliente c WHERE c.alta = true")
    List<Cliente> findByEstadoTrue();
    
    @Query("SELECT c FROM Cliente c WHERE c.username = :username")
    Optional<Cliente> findByUsername(@Param("username") String username); 
}
