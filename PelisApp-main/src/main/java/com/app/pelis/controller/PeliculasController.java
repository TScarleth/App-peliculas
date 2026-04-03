package com.app.pelis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pelis.Pelicula;
import com.app.pelis.service.PeliculasService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/movies")
public class PeliculasController {
    private final PeliculasService service;

    public PeliculasController(PeliculasService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pelicula>> getAll(){
        List<Pelicula> allMovies = service.getAllMovies();
        return ResponseEntity.ok(allMovies);
    }

@GetMapping("/{id}")
public ResponseEntity<?> getById(@PathVariable int id){
    Pelicula movie = service.getMovieById(id);

    if(movie == null){
        return ResponseEntity.status(404).body("Movie not found");
    }

    return ResponseEntity.ok(movie);
}


    
}

