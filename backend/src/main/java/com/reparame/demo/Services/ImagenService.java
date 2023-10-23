package com.reparame.demo.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reparame.demo.Repositories.ImagenRepository;
import com.reparame.demo.entity.Imagen;

import java.net.URL;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Service
public class ImagenService {

	@Autowired
	private ImagenRepository imagenRepository;

	public Imagen getImagen(Long Id) throws IOException {
		Optional<Imagen> imagen = imagenRepository.findById(Id);
//		String urls = imagen.get().getImagenUrl();
//		System.out.println(urls);
//
//		URL url = new URL(urls);
//		ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//		try (InputStream inputStream = url.openStream()) {
//			int n = 0;
//			byte[] buffer = new byte[1024];
//			while (-1 != (n = inputStream.read(buffer))) {
//				output.write(buffer, 0, n);
//			}
//		}
//
//		return output.toByteArray();
		return imagen.get();
	}

	public Optional<Imagen> getOne(Long id) {
		return imagenRepository.findById(id);
	}

	public void save(Imagen imagen) {
		imagenRepository.save(imagen);
	}

	public void delete(Long id) {
		imagenRepository.deleteById(id);
	}

	public boolean exists(Long id) {
		return imagenRepository.existsById(id);
	}

}
