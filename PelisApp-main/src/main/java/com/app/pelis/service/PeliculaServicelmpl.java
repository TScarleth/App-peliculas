package com.app.pelis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pelis.dto.PeliculaResponseDTO;
import com.app.pelis.mappers.PeliculaMapper;
import com.app.pelis.model.Pelicula;
import com.app.pelis.repository.PeliculaRepository;


@Service
public class PeliculaServicelmpl implements PeliculaService{

    @Autowired
    private  PeliculaRepository peliculaRepository;

    public List<PeliculaResponseDTO> getAllPeliculas(){
    List<PeliculaResponseDTO> peliculas  = peliculaRepository.findAll()
    .stream()
    .map(PeliculaMapper::toDTO)
    .toList();
    
    return peliculas;
 }

public Optional<PeliculaResponseDTO> getPeliculaById(Long id){
    Optional<Pelicula> pelicula = peliculaRepository.findById(id);
    Optional<PeliculaResponseDTO> peliculaDTO = pelicula.map(PeliculaMapper::toDTO);

    return peliculaDTO;
}
};