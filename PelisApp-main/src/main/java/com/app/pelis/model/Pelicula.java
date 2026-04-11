package com.app.pelis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PELICULA")
public class Pelicula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "TITULO")
  private String titulo;

  @Column(name = "ANIO")
  private Integer anio;

  @Column(name = "DIRECTOR")
  private String director;

  @Column(name = "GENERO")
  private String genero;

  @Column(name = "SINOPSIS")
  private String sinopsis;
}
