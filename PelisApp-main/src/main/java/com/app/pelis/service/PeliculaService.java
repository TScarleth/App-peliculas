package com.app.pelis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.pelis.dto.PeliculaResponseDTO;


@Service
public interface PeliculaService {
  List<PeliculaResponseDTO> getAllPeliculas();
  Optional<PeliculaResponseDTO> getPeliculaById(Long id);
};


