package com.reparame.demo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reparame.demo.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen,Long> {

    Optional<Imagen> findByName(String fileName);
}


