/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reparame.demo.dtos.response.GoogleResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Admin
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clientes")
public class Cliente extends Persona {
    private String zona;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Ticket> tikets;
    
    @OneToMany(mappedBy = "cliente")
    private List<Soporte> soportes;
    
    public Cliente(GoogleResponseDto g) {
    	super();
    	  this.setNombreCompleto(g.name());
          this.setApellidoCompleto(g.family_name());
          this.setUsername(g.email());
          this.setPassword(g.sub());
    	
    }
    
}
