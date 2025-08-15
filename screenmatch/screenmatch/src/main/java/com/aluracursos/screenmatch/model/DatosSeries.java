package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.net.URL;
//Este archivo sirve para poder obtener un objeto del json que estamos obteniendo
//Usamso anotaciones @JsonAlias para hacer un match con las propiedades que tiene el JSON

@JsonIgnoreProperties(ignoreUnknown = true) //Por defecto se lee todo el json pero si usamos la anotacion solo lee las propiedades indicadas
public record DatosSeries(
        @JsonAlias("Title") //Permite leer el contenido
        String titulo,
        @JsonAlias("Plot")
        String sinopsis,
        @JsonAlias("totalSeasons")
        Integer totalDeTemporadas,
        @JsonAlias("Genre")
        String genero,
        @JsonAlias("Actors")
        String actores,
        @JsonAlias("Poster")
        String poster,
        @JsonAlias("imdbRating")
        String evaluacion
        //@JsonProperty("") //Podemos leer y escribir
) {

}
