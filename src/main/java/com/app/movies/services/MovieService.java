package com.app.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.movies.dto.CreateMovieRequestDTO;
import com.app.movies.dto.MovieResponseDTO;
import com.app.movies.dto.UpdateMovieRequestDTO;

@Service
public interface MovieService {
  //GET
  List<MovieResponseDTO> getAllMovies();
  Optional<MovieResponseDTO> getMovieById(Long id);
  //POST
  public MovieResponseDTO createMovie(CreateMovieRequestDTO request);
  //PUT
  public MovieResponseDTO updateMovie(Long id, UpdateMovieRequestDTO request);
  //DELETE
  public Boolean deleteMovie(Long id);
};
