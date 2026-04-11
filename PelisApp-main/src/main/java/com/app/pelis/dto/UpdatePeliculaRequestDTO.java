package com.app.pelis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatePeliculaRequestDTO {

  @NotBlank(message = "El titulo de la pelicula es obligatorio")
  private String titulo;

  @NotNull(message = "El año de la pelicula es obligatorio")
  private Integer anio;

  @NotBlank(message = "El director de la pelicula es obligatorio")
  private String director;

  @NotBlank(message = "El genero de la pelicula es obligatorio")
  private String genero;

  @NotBlank(message = "La sinopsis de la pelicula es obligatoria")
  private String sinopsis;

};
