/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reparame.demo.Controllers;

import com.reparame.demo.Services.UserService;
import com.reparame.demo.dtos.LoginRequest;
import com.reparame.demo.dtos.RegisterRequest;
import com.reparame.demo.exception.MiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> registro(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(userService.registro(request));
        } catch (MiException miException) {
            return new ResponseEntity<String>(miException.getMessage(), miException.getStatus());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(userService.login(request));
        } catch (MiException miExeception) {
            return new ResponseEntity<String>(miExeception.getMensaje(), miExeception.getStatus());
        }
    }

}
