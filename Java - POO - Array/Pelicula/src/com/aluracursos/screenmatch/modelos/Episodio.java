package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {
    private int numero;
    private String nombre;
    private Serie serie; //Atributo de identificacion, para saber de quien pertenece el episodio
    private int totalVisualizaciones;

    //setter

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }
//Getter

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    @Override
    public int getClasificacion() {
        if (totalVisualizaciones > 100) {
            return 4;
        }
        else {
            return 2;
        }
    }
}
