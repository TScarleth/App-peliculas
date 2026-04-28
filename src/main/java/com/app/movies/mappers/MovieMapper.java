package com.app.movies.mappers;

import com.app.movies.dto.MovieResponseDTO;
import com.app.movies.models.Movie;

public class MovieMapper {
  
  public static Movie toEntity(MovieResponseDTO dto){
    Movie movie = new Movie();
    movie.setTitle(dto.getTitle());
    movie.setYear(dto.getYear());
    movie.setDirector(dto.getDirector());
    movie.setGender(dto.getGender());
    movie.setSynopsis(dto.getSynopsis());

    return movie;
  };

  public static MovieResponseDTO toDTO(Movie entity){
    MovieResponseDTO dto = new MovieResponseDTO();

    dto.setId(entity.getId());
    dto.setTitle(entity.getTitle());
    dto.setYear(entity.getYear());
    dto.setDirector(entity.getDirector());
    dto.setGender(entity.getGender());
    dto.setSynopsis(entity.getSynopsis());

    return dto;
  };
};
