package com.app.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.movies.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  
};
