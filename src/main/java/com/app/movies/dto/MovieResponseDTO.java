package com.app.movies.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class MovieResponseDTO extends RepresentationModel<MovieResponseDTO>{ 

  private Long id;
  
  private String title;

  private Integer year;

  private String director;

  private String gender;

  private String synopsis;
};
