package com.reparame.demo.dtos.response;

import java.util.Optional;

import com.reparame.demo.entity.Cliente;

public record GoogleResponseDto(
		Long id,
	    String nombre,
	    String apellido,
	    String foto,
	    String email,
	    String sub,
	    String token
	 
	) { 
	
	public GoogleResponseDto(GoogleApiResponseDto googleApiResponseDto, long id, String token) {
        this(id, googleApiResponseDto.given_name(),
            googleApiResponseDto.family_name(), googleApiResponseDto.picture(), googleApiResponseDto.email(),
            googleApiResponseDto.sub(), token);
    }
	
	
	
}