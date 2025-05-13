package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Reproductor implements Clasificacion {
    private String director;

    //Setter
    public void setDirector(String director) {
        this.director = director;
    }

    //Getter
    public String getDirector() {
        return director;
    }

    @Override
    public int getClasificacion() {
        return (int)calcuandoMedia() / 2;
    }
}