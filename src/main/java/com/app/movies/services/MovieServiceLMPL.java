package com.app.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.movies.dto.CreateMovieRequestDTO;
import com.app.movies.dto.MovieResponseDTO;
import com.app.movies.dto.UpdateMovieRequestDTO;
import com.app.movies.mappers.MovieMapper;
import com.app.movies.models.Movie;
import com.app.movies.repository.MovieRepository;

@Service
public class MovieServiceLMPL implements MovieService {
  
  @Autowired
  private MovieRepository movieRepository;
  
  public List<MovieResponseDTO> getAllMovies(){
    List<MovieResponseDTO> movies = movieRepository.findAll()
      .stream()
      .map(MovieMapper::toDTO)
      .toList();

    return movies;
  };

  public Optional<MovieResponseDTO> getMovieById(Long id){
    Optional<Movie> movie = movieRepository.findById(id);
    Optional<MovieResponseDTO> movieDto = movie.map(MovieMapper::toDTO);

    return movieDto;
  };

  public MovieResponseDTO createMovie(CreateMovieRequestDTO request){
    Movie movie = new Movie();
    movie.setTitle(request.getTitle());
    movie.setYear(request.getYear());
    movie.setDirector(request.getDirector());
    movie.setGender(request.getGender());
    movie.setSynopsis(request.getSynopsis());
    movieRepository.save(movie);

    MovieResponseDTO newMovie = MovieMapper.toDTO(movie);

    return newMovie;
  };

  public MovieResponseDTO updateMovie(Long id, UpdateMovieRequestDTO request){
    Optional<Movie> movieOptional = movieRepository.findById(id);
    
    if(movieOptional.isEmpty()){
      return null;
    }

    Movie movie = movieOptional.get();
    movie.setTitle(request.getTitle());
    movie.setYear(request.getYear());
    movie.setDirector(request.getDirector());
    movie.setGender(request.getGender());
    movie.setSynopsis(request.getSynopsis());
    movieRepository.save(movie);

    MovieResponseDTO updateMovie = MovieMapper.toDTO(movie);
    return updateMovie;
  };

  public Boolean deleteMovie(Long id){
    if(movieRepository.existsById(id)){
      movieRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
