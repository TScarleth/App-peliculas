package com.app.pelis.mappers;

import com.app.pelis.dto.PeliculaResponseDTO;
import com.app.pelis.model.Pelicula;

public class PeliculaMapper {

    public static Pelicula toEntity(PeliculaResponseDTO dto){
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setAño(dto.getAño());
        pelicula.setDirector(dto.getDirector());
        pelicula.setGenero(dto.getGenero());
        pelicula.setSinopsis(dto.getSinopsis());

        return pelicula;
    };

    public static PeliculaResponseDTO toDTO(Pelicula entity){
        PeliculaResponseDTO dto = new PeliculaResponseDTO();

        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setAño(entity.getAño());
        dto.setDirector(entity.getDirector());
        dto.setGenero(entity.getGenero());
        dto.setSinopsis(entity.getSinopsis());

        return dto;
    };
    
}
