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
public class CreatePeliculaRequestDTO {

  @NotBlank(message = "El Titulo de la pelicula es obligatorio")
  private String titulo;

  @NotNull(message = "El Año de la pelicula es obligatorio")
  private Integer anio;

  @NotBlank(message = "El Director de la pelicula es obligatorio")
  private String director;

  @NotBlank(message = "El Género de la pelicula es obligatorio")
  private String genero;

  @NotBlank(message = "La Sinopsis de la pelicula es obligatorio")
  private String sinopsis;

};
