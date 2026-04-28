package com.app.movies.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas unitarias - MovieResponseDTO")
public class MovieResponseDTOTest {

  @Test
  @DisplayName("Debería crear un dto con el constructor sin argumentos")
  public void deberiaCrearUnDTOConElConstructorSinArgumentos() {
    MovieResponseDTO dto = new MovieResponseDTO();

    assertNotNull(dto);
  };

  @Test
  @DisplayName("Debería crear un dto con el constructor con argumentos")
  public void deberiaCrearUnDTOConElConstructorConArgumentos() {
    Long id = 1L;
    String title = "TestDTO";
    Integer year = 2026;
    String director = "Nicolás Hernández";
    String gender = "testing";
    String synopsis = "First Test";

    MovieResponseDTO movie = new MovieResponseDTO(id, title, year, director, gender, synopsis);

    assertNotNull(movie);
    assertEquals(id, movie.getId());
    assertEquals(title, movie.getTitle());
    assertEquals(year, movie.getYear());
    assertEquals(director, movie.getDirector());
    assertEquals(gender, movie.getGender());
    assertEquals(synopsis, movie.getSynopsis());
  };

  @Test
  @DisplayName("Debería heredar de la clase RepresentationModel")
  public void deberiaHeredarDeRepresentationModel() {
    MovieResponseDTO movie = new MovieResponseDTO(1L, "Test", 2026, "Nicolás Hernández", "testing", "First Test");

    assertTrue(movie instanceof org.springframework.hateoas.RepresentationModel);
  };
};
