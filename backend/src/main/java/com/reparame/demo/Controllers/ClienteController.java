/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Controllers;

import com.reparame.demo.Services.ClienteService;
import com.reparame.demo.entity.Cliente;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteServ;
    
    @PostMapping("/crear")
    public ResponseEntity<Cliente> nuevoCliente(@RequestBody Cliente cliente){
        try {
            Cliente clienteNuevo = clienteServ.nuevoCliente(cliente);
            return new ResponseEntity<>(clienteNuevo, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @GetMapping("/listar")
    public List<Cliente> listarClientes(){
        return clienteServ.listarClientes();
    }
    
    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<Cliente> buscarPorID(@PathVariable("id") Long id){
        try {
            Cliente cliente = clienteServ.buscarPorID(id).get();
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @PutMapping("/darBaja/{id}")
    public ResponseEntity<Cliente> darBaja(@PathVariable("id") Long id){
        try {
            Cliente cliente = clienteServ.bajaCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCliente(@PathVariable("id") Long id){
    	clienteServ.eliminarCliente(id);
    } 
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Cliente> modificar(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        try {
            Cliente clienteModificado = clienteServ.modificarCliente(id, cliente);
            return new ResponseEntity<>(clienteModificado, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
