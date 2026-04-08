
package com.app.pelis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pelis.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    
}