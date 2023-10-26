/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Controllers;

import com.reparame.demo.Services.UserService;
import com.reparame.demo.dtos.request.LoginRequestDTO;
import com.reparame.demo.dtos.request.RegisterRequestDTO;
import com.reparame.demo.exception.MiException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody @Valid RegisterRequestDTO request) {
        try {
            return ResponseEntity.ok(userService.registro(request));
        } catch (MiException miException) {
            return ResponseEntity.badRequest().body(miException.getMensaje());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody @Valid LoginRequestDTO request) {
        try {
            return ResponseEntity.ok(userService.login(request));
        } catch (MiException miExeception) {
            return new ResponseEntity<String>(miExeception.getMensaje(), miExeception.getStatus());
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> Me(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            //String username = userDetails.getUsername();
            // Aquí puedes acceder a otros datos del usuario desde userDetails si es necesario.
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No hay usuario logueado.");
        }
    }
    

}
