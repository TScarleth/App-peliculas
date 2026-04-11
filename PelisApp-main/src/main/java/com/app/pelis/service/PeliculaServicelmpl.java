package com.app.pelis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pelis.dto.CreatePeliculaRequestDTO;
import com.app.pelis.dto.PeliculaResponseDTO;
import com.app.pelis.dto.UpdatePeliculaRequestDTO;
import com.app.pelis.mappers.PeliculaMapper;
import com.app.pelis.model.Pelicula;
import com.app.pelis.repository.PeliculaRepository;

@Service
public class PeliculaServicelmpl implements PeliculaService {

  @Autowired
  private PeliculaRepository peliculaRepository;

  public List<PeliculaResponseDTO> getAllPeliculas() {
    List<PeliculaResponseDTO> peliculas = peliculaRepository.findAll()
        .stream()
        .map(PeliculaMapper::toDTO)
        .toList();
    return peliculas;
  };

  public Optional<PeliculaResponseDTO> getPeliculaById(Long id) {
    Optional<Pelicula> pelicula = peliculaRepository.findById(id);
    Optional<PeliculaResponseDTO> peliculaDTO = pelicula.map(PeliculaMapper::toDTO);

    return peliculaDTO;
  };

  public PeliculaResponseDTO createPelicula(CreatePeliculaRequestDTO request) {
    Pelicula pelicula = new Pelicula();
    pelicula.setTitulo(request.getTitulo());
    pelicula.setAnio(request.getAnio());
    pelicula.setDirector(request.getDirector());
    pelicula.setGenero(request.getGenero());
    pelicula.setSinopsis(request.getSinopsis());
    peliculaRepository.save(pelicula);

    PeliculaResponseDTO newPelicula = PeliculaMapper.toDTO(pelicula);
    return newPelicula;
  };

  public PeliculaResponseDTO updatePelicula(UpdatePeliculaRequestDTO request, Long id) {
    Optional<Pelicula> peliculaOptional = peliculaRepository.findById(id);

    if (peliculaOptional.isEmpty()) {
      return null;
    }

    Pelicula pelicula = peliculaOptional.get();
    pelicula.setTitulo(request.getTitulo());
    pelicula.setAnio(request.getAnio());
    pelicula.setDirector(request.getDirector());
    pelicula.setGenero(request.getGenero());
    pelicula.setSinopsis(request.getSinopsis());
    peliculaRepository.save(pelicula);

    PeliculaResponseDTO updatePelicula = PeliculaMapper.toDTO(pelicula);
    return updatePelicula;

  }

  public Boolean deletePelicula(Long id) {
    Boolean isDeleted = peliculaRepository.existsById(id);

    if (isDeleted) {
      peliculaRepository.deleteById(id);
      return true;
    }

    return false;
  }
}