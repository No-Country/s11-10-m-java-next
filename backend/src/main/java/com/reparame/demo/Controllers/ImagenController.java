package com.reparame.demo.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reparame.demo.Services.ImagenService;

@RestController
@RequestMapping("/imagen")
public class ImagenController {

	
	@Autowired
	private ImagenService imagenService;

	@PostMapping
	public ResponseEntity<?> guardarImagen(@RequestParam("imagen")MultipartFile file) throws IOException {
		String uploadImage = imagenService.guardarImagen(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> cargarImagen(@PathVariable Long id){
		byte[] imageData=imagenService.cargarImagen(id);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
}
