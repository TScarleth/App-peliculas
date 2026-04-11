package com.app.pelis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.pelis.dto.CreatePeliculaRequestDTO;
import com.app.pelis.dto.PeliculaResponseDTO;
import com.app.pelis.dto.UpdatePeliculaRequestDTO;

@Service
public interface PeliculaService {
  List<PeliculaResponseDTO> getAllPeliculas();

  Optional<PeliculaResponseDTO> getPeliculaById(Long id);

  PeliculaResponseDTO createPelicula(CreatePeliculaRequestDTO request);

  PeliculaResponseDTO updatePelicula(UpdatePeliculaRequestDTO request, Long id);

  Boolean deletePelicula(Long id);
}