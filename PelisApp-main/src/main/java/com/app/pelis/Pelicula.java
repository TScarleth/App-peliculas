package com.app.pelis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    private int id;
    public String titulo;
    public int año;
    public String director;
    public String genero;
    public String sinopsis;
}
