package com.reparame.demo.dtos.response;

public record GoogleApiResponseDto(
		String sub,
	    String name,
	    String given_name,
	    String family_name,
	    String picture,
	    String email,
	    boolean email_verified,
	    String locale
	) { }