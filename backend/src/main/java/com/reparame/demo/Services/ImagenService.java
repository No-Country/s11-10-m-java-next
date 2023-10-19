package com.reparame.demo.Services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reparame.demo.Repositories.ImagenRepository;
import com.reparame.demo.Utils.ImagenUtils;
import com.reparame.demo.entity.Imagen;



@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepo;
	
    public Imagen guardarImagen(MultipartFile file) throws IOException {

        		
        		Imagen im =		Imagen.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImagenUtils.compressImage(file.getBytes())).build();
        
        		Imagen imagenData = imagenRepo.save(im);
        		
        if (imagenData != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
        	return imagenData;
        }
        return null;
    }



    public byte[] cargarImagen(Long id) {
        Optional<Imagen> dbImageData = imagenRepo.findById(id);
        byte[] images = ImagenUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }	
	
	
	
}
