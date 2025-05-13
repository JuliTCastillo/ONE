package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screenmatch.modelos.Reproductor;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    //getter
    public int getTiempoTotal() {
        return tiempoTotal;
    }

    //metodo
    public void incluye(Reproductor reproductor){
        this.tiempoTotal += reproductor.getDuracionEnMinuto();
    }
}
