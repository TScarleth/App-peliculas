package com.app.movies.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMovieRequestDTO {
  
  @NotBlank(message = "El titulo es obligatorio")
  private String title;

  @NotNull(message = "El año de emisión es obligatorio")
  @Positive
  @Min(value = 1500, message = "El año es inválido")
  @Max(value = 2026, message = "El año es inválido")
  private Integer year;

  @NotBlank(message = "El director es obligatorio")
  private String director;

  @NotBlank(message = "El genero es obligatorio")
  private String gender;

  @NotBlank(message = "La sinopsis es obligatoria")
  private String synopsis;
}
