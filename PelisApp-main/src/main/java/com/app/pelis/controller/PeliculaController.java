package com.app.pelis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pelis.dto.PeliculaResponseDTO;
import com.app.pelis.service.PeliculaServicelmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/movies")
public class PeliculaController {

  @Autowired
  private PeliculaServicelmpl service;

  @GetMapping
  public ResponseEntity<List<PeliculaResponseDTO>> getAllPeliculas(){
    List<PeliculaResponseDTO> peliculas = service.getAllPeliculas();

    return ResponseEntity.ok(peliculas);
  };

  @GetMapping("/{id}")
  public ResponseEntity<?> getPeliculaById (@PathVariable Long id){
    Optional<PeliculaResponseDTO> pelicula = service.getPeliculaById(id);

    if(pelicula.isEmpty()){
      return ResponseEntity.status(404).body("Movie not found");
    }

    return ResponseEntity.ok(pelicula);
  };
};

