package com.reparame.demo.Controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reparame.demo.JWT.JwtService;
import com.reparame.demo.Repositories.ClienteRepository;
import com.reparame.demo.dtos.request.TokenRequestDto;
import com.reparame.demo.dtos.response.GoogleResponseDto;
import com.reparame.demo.dtos.response.TokenResponseDTO;
import com.reparame.demo.entity.Cliente;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/validarToken")
@RequiredArgsConstructor
public class GoogleController {
	
    private final ClienteRepository  clienteRepository;
    private final JwtService jwtService;

    @PostMapping("")
    public ResponseEntity<?> validarToken(@RequestBody TokenRequestDto tokendto) {
        // URL de la API de Google para obtener información del usuario
        String apiUrl = "https://www.googleapis.com/oauth2/v3/userinfo";
        
        //obtengo el token de la respusta
        String token = tokendto.token(); 
        System.out.println(token);

        // Configura el encabezado con el token de acceso
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        try {
            // Realiza la solicitud a la API de Google
            ResponseEntity<String> responseEntity = new RestTemplate().exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            // Verifica si la solicitud fue exitosa
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
            	
            	//mapeo
            	ObjectMapper objectMapper = new ObjectMapper();
                GoogleResponseDto googleResponseDto = objectMapper.readValue(responseEntity.getBody(),GoogleResponseDto.class);
                
               
                // creo un cliente con los datos obtenido de google 
                Cliente user = new Cliente (googleResponseDto);
                clienteRepository.save(user);
                
                String tokenResponse = jwtService.getToken(user);
                
            	return new ResponseEntity<TokenResponseDTO>(new TokenResponseDTO(tokenResponse), HttpStatus.OK);
                
            } else {
                // Maneja el error de acuerdo a tus necesidades
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Credenciales no válidas");
            }
        } catch (Exception e) {
            // Manejo de excepciones
  
            return ResponseEntity.status(400).body("el token esta vencido, envie una nueva solicitud");
        }
    }

}
