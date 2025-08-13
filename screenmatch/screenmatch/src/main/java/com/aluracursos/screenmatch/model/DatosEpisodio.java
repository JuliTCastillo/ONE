package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Es para que no se busque todas las propiedad del JSON, solo las que mencionamos con el Alias
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio (
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode") Integer numeroEpisodio,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Released") String fechaDeLanzamiento
){
}
