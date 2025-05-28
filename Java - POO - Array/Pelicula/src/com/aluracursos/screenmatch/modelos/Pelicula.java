package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Reproductor implements Clasificacion {
    private String director;

    //Constructor - No ponemos void
    public Pelicula(String nombre, int fechaDeLanzamiento){
        //super llama al constructor de la clase padre
        super(nombre, fechaDeLanzamiento);
    }
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

    @Override
    public String toString() {
        //super hacer referencia a que hacemos referencia de nuestra clase padre
        return "Pelicula: " + this.getNombre() + " (" + this.getFechaDeLanzamiento() + ")";
    }
}