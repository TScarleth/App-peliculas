package com.app.movies.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas Unitarias - Movie")
public class MovieTest {
  
  @Test
  @DisplayName("Deberia crear una Movie entity con el constructor sin argumentos")
  public void deberiaCrearUnaMovieEntityConElConstructorSinArgumentos(){
    Movie movie = new Movie();

    assertNotNull(movie);
  };

  @Test
  @DisplayName("Debería crear una Movie con el constructor con argumentos")
  public void deberiaCrearUnaMovieEntityConElConstructorConArgumentos(){
    Long id = 1L;
    String title = "Test";
    Integer year = 2026;
    String director = "Nicolás Hernández";
    String gender = "testing";
    String synopsis = "First Test";

    Movie movie = new Movie(id, title, year, director, gender, synopsis);
  
    assertNotNull(movie);
    assertEquals(id, movie.getId());
    assertEquals(title, movie.getTitle());
    assertEquals(year, movie.getYear());
    assertEquals(director, movie.getDirector());
    assertEquals(gender, movie.getGender());
    assertEquals(synopsis, movie.getSynopsis());
  };

  @Test
  @DisplayName("Deberia actualizar todos los campos")
  public void deberiaActualizarTodosLosCampos(){
    Movie movie = new Movie(1L, "Test", 2026, "Nicolás Hernández", "testing", "First Test");
    
    movie.setId(2L);
    movie.setTitle("UpdateTest");
    movie.setYear(2025);
    movie.setDirector("Cuka Beatriz");
    movie.setGender("update testing");
    movie.setSynopsis("Update the subject test");

    assertNotNull(movie);
    assertEquals(2L, movie.getId());
    assertEquals("UpdateTest", movie.getTitle());
    assertEquals(2025, movie.getYear());
    assertEquals("Cuka Beatriz", movie.getDirector());
    assertEquals("update testing", movie.getGender());
    assertEquals("Update the subject test", movie.getSynopsis());
  };
};
