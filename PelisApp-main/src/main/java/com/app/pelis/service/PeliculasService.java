package com.app.pelis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pelis.Pelicula;

@Service
public class PeliculasService {
  private List<Pelicula> movies = new ArrayList<>();

  public PeliculasService() {
    movies.add(new Pelicula(
        1,
        "Coraline",
        2009,
        "Henry Selick",
        "Animación,fantasía y terror",
        "Coraline es una niña curiosa que descubre una puerta secreta en su nueva casa que la lleva a un mundo paralelo aparentemente perfecto.Sin embargo, pronto descubre que este mundo es oscura y peligroso, y debe enfrentarse a sus propios medios para salvarse a sí misma y a su familia."));
    movies.add(new Pelicula(
        2,
        "The Road: A Breaking Bad Movie",
        2019,
        "Vince Gilligan",
        "Crimen, drama y suspenso",
        "El Camino: A breaking Bad Movie continúa la historia de Jesse Pinkman después de los eventos de Breaking Bad. Jesse huye de su pasado y busca libertad,mientras enfrenta peligros y toma decisiones que determinarán su futuro."

    ));
    movies.add(new Pelicula(
        3,
        "The Hateful Eigth",
        2015,
        "Quentin Trantino",
        "Misterio y drama",
        "The Hateful Eigth narra la historia de ocho extraños atrapados durante una tormenta de nieve en una cabaña en Wyoming tras la Guerra Civil estadounidense.Entre traiciones,secretos y tensiones,la desconfianza crece,llevando a conflictos violentos que revelan la veradera  naturaleza de cada uno"

    ));
    movies.add(new Pelicula(
        4,
        "Jennifer's Body",
        2009,
        "Karyn Kusama",
        "Terror y comedia negra",
        "Jennifer es una animadora popular que es poseída por un demonio y comienza a asesinar a los chicos de su escuela.Su mejor amiga intenta detenerla,enfrentando tanto horrores sobrenaturales como los secretos ocultos en su amistad."

    ));
    movies.add(new Pelicula(
        5,
        "Parasite",
        2019,
        "Bong Joon-ho",
        "Thriller,drama y comedia negra",
        "Parasite cuenta la historia de la familia Kim, que viven en la pobreza y busca infiltrarse en la vida de la adinerada familia Park.A medida que se mezclan con ellos,las diferencias sociales y la codicia desencadenan secretos y conflictos inesperados que transforman sus vidas para siempre"

    ));
  }

  public List<Pelicula> getAllMovies() {
    return movies;
  }

  public List<Pelicula> getAllMojvies() {
    return movies;
  }

  public Pelicula getMovieById(int id) {
    for (Pelicula movie : movies) {
      if (movie.getId() == id) {
        return movie;
      }
    }
    return null;
  }
};