package com.app.pelis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pelis.dto.CreatePeliculaRequestDTO;
import com.app.pelis.dto.PeliculaResponseDTO;
import com.app.pelis.dto.UpdatePeliculaRequestDTO;
import com.app.pelis.service.PeliculaServicelmpl;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/movies")
public class PeliculaController {

  @Autowired
  private PeliculaServicelmpl service;

  @GetMapping
  public ResponseEntity<List<PeliculaResponseDTO>> getAllPeliculas() {
    List<PeliculaResponseDTO> peliculas = service.getAllPeliculas();

    return ResponseEntity.ok(peliculas);
  };

  @GetMapping("/{id}")
  public ResponseEntity<?> getPeliculaById(@PathVariable Long id) {
    Optional<PeliculaResponseDTO> pelicula = service.getPeliculaById(id);

    if (pelicula.isEmpty()) {
      return ResponseEntity.status(404).body("Movie not found");
    }

    return ResponseEntity.ok(pelicula);
  };

  @PostMapping
  public ResponseEntity<PeliculaResponseDTO> createPelicula(@Valid @RequestBody CreatePeliculaRequestDTO body) {
    PeliculaResponseDTO newPelicula = service.createPelicula(body);

    return ResponseEntity.ok(newPelicula);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updatePelicula(@PathVariable Long id, @Valid @RequestBody UpdatePeliculaRequestDTO body) {
    PeliculaResponseDTO peliculaActualizada = service.updatePelicula(body, id);

    if (peliculaActualizada == null) {
      return ResponseEntity.status(404).body("Movie not found");
    }

    return ResponseEntity.ok(peliculaActualizada);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePelicula(@PathVariable Long id) {
    Boolean eliminado = service.deletePelicula(id);
    if (eliminado) {
      return ResponseEntity.ok("Movie deleted");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
    }
  }
}