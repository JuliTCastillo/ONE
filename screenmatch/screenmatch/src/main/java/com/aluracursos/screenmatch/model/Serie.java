package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.ConsultaChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;
import jdk.jfr.Category;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private String sinopsis;
    private Integer totalDeTemporadas;
    private Categoria genero;
    private String actores;
    private String poster;
    private Double evaluacion;

    public Serie(DatosSeries datosSeries){
        this.titulo = datosSeries.titulo();
        this.sinopsis = ConsultaChatGPT.obtenerTraduccion(datosSeries.sinopsis());
        this.totalDeTemporadas = datosSeries.totalDeTemporadas();
        //A traves de nuestro genero tenemos un String, con fromString verificamos que se convierta los datos de nuestra categoria
        //Como estamos manejando un String usamos el .split() para que separe los datos cuando encuentra una ","
        //El .trim() se usa para evitar guardar caracteres vacios
        this.genero = Categoria.fromString(datosSeries.genero().split(",")[0].trim());
        this.actores = datosSeries.actores();
        this.poster = datosSeries.poster();
        this.evaluacion = OptionalDouble.of(Double.valueOf(datosSeries.evaluacion())).orElse(0);

    }

    @Override
    public String toString() {
        return
                "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", totalDeTemporadas=" + totalDeTemporadas +
                ", actores='" + actores + '\'' +
                ", poster='" + poster + '\'' +
                ", evaluacion=" + evaluacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getTotalDeTemporadas() {
        return totalDeTemporadas;
    }

    public void setTotalDeTemporadas(Integer totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }
}
