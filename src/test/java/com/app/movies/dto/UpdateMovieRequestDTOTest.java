package com.app.movies.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@DisplayName("Pruebas unitarias - UpdateMovieRequestDTO")
public class UpdateMovieRequestDTOTest {

  private Validator validator;

	@BeforeEach
	void cleanValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	};

  @Test
  @DisplayName("No debería crear un dto con el constructor sin arguemntos")
  public void noDeberiaCrearUnDTOConElConstructorSinArgumentos(){
    UpdateMovieRequestDTO dto = new UpdateMovieRequestDTO();
    Set<ConstraintViolation<UpdateMovieRequestDTO>> violations = validator.validate(dto);
    
    assertFalse(violations.isEmpty());
    assertEquals(5, violations.size());
  };

  @Test
  @DisplayName("Debería crear un dto con el constructor con argumentos válidos")
  public void deberiaCrearUnDTOConElConstructorConArgumentos(){
    String title = "Test";
    Integer year = 2026;
    String director = "Nicolas Hernández";
    String gender = "testing app";
    String synopsis = "Testeo de request dto";

    UpdateMovieRequestDTO dto = new UpdateMovieRequestDTO(title, year, director, gender, synopsis);
    Set<ConstraintViolation<UpdateMovieRequestDTO>> violations = validator.validate(dto);

    assertTrue(violations.isEmpty());
    assertNotNull(dto);
    assertEquals(title, dto.getTitle());
    assertEquals(year, dto.getYear());
    assertEquals(director, dto.getDirector());
    assertEquals(gender, dto.getGender());
    assertEquals(synopsis, dto.getSynopsis());
  };

  @Test
  @DisplayName("Debe dar error si el año es negativo")
  public void deberiaValidarQueElAnioSeaPositivo(){
    String title = "Test";
    Integer year = -2026;
    String director = "Nicolas Hernández";
    String gender = "testing app";
    String synopsis = "Testeo de request dto";

    UpdateMovieRequestDTO dto = new UpdateMovieRequestDTO(title, year, director, gender, synopsis);
    Set<ConstraintViolation<UpdateMovieRequestDTO>> violations = validator.validate(dto);

    assertFalse(violations.isEmpty());
    assertEquals(2, violations.size());
  };
};
