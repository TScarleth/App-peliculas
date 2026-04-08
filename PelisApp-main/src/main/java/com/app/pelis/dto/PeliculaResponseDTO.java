package com.app.pelis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class PeliculaResponseDTO {
    
    private Long id;

    private String titulo;

    private int año;

    private String director;

    private String genero;

    private String sinopsis;
}
