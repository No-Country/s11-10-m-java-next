package com.reparame.demo.dtos.response;

public record GoogleResponseDto(
		Long id,
	    String name,
	    String given_name,
	    String family_name,
	    String picture,
	    String email,
	    String sub,
	    String token
	 
	) { 
	
	public GoogleResponseDto(GoogleApiResponseDto googleApiResponseDto, long id, String token) {
        this(id, googleApiResponseDto.name(), googleApiResponseDto.given_name(),
            googleApiResponseDto.family_name(), googleApiResponseDto.picture(), googleApiResponseDto.email(),
            googleApiResponseDto.sub(), token);
    }
	
	
}