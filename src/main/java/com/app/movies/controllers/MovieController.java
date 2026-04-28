package com.app.movies.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.movies.dto.CreateMovieRequestDTO;
import com.app.movies.dto.MovieResponseDTO;
import com.app.movies.dto.UpdateMovieRequestDTO;
import com.app.movies.services.MovieServiceLMPL;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/movies")
public class MovieController {
  
  @Autowired
  private MovieServiceLMPL service;

  @GetMapping
  public ResponseEntity<List<MovieResponseDTO>> getAllMovies(){
    List<MovieResponseDTO> movies = service.getAllMovies();
    
    movies.forEach(movie -> addLinks(movie));
    return ResponseEntity.ok(movies); 
  };
  
  @GetMapping("/{id}")
  public ResponseEntity<?> getMovieById(@PathVariable Long id){
    Optional<MovieResponseDTO> movie = service.getMovieById(id);

    if(movie.isEmpty()){
      return ResponseEntity.status(404).body("Movie not found");
    }

    addLinks(movie.get());
    return ResponseEntity.ok(movie);
  };

  @PostMapping
  public ResponseEntity<MovieResponseDTO> createMovie(@Valid @RequestBody CreateMovieRequestDTO body){
    MovieResponseDTO newMovie = service.createMovie(body);
  
    addLinks(newMovie);
    return ResponseEntity.ok(newMovie);
  } 

  @PutMapping("/{id}")
  public ResponseEntity<?> updateMovie(@PathVariable Long id, @Valid @RequestBody UpdateMovieRequestDTO body){
    MovieResponseDTO updateMovie = service.updateMovie(id, body);

    if(updateMovie.equals(null)){
      return ResponseEntity.status(404).body("Movie not found by id :" + id);
    }

    addLinks(updateMovie);
    return ResponseEntity.ok(updateMovie);
  };
  
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteMovie(@PathVariable Long id){
    Boolean isDeleted = service.deleteMovie(id);

    if(!isDeleted){
      return ResponseEntity.status(404).body("Movie with id " + id + " not found.");
    }
  
    return ResponseEntity.ok("Pelicula con el id " + id + " eliminada.");
  };

  private void addLinks(MovieResponseDTO movie){
    movie.add(linkTo(methodOn(MovieController.class).getAllMovies()).withRel("movies"));
    movie.add(linkTo(methodOn(MovieController.class).getMovieById(movie.getId())).withSelfRel());
    movie.add(linkTo(methodOn(MovieController.class).createMovie(null)).withRel("create"));
    movie.add(linkTo(methodOn(MovieController.class).updateMovie(movie.getId(), null)).withRel("update"));
    movie.add(linkTo(methodOn(MovieController.class).deleteMovie(movie.getId())).withRel("delete"));
  };
};
