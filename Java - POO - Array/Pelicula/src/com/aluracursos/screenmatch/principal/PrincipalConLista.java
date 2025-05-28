package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Reproductor;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class PrincipalConLista {
    public static void main(String[] args) {
        //Objetos de Pelicula
        Pelicula dragones = new Pelicula("Entrenando tu dragon", 2021);
        dragones.evalua(10);
        Pelicula caroline = new Pelicula("Caroline y la puerta secreta", 2012);
        caroline.evalua(10);
        Pelicula avatar = new Pelicula("Avatar II", 2023);
        avatar.evalua(4);

        //Objetos de Series
        Serie theChosen = new Serie("The Chosen", 2021);
        Serie american = new Serie("American good family", 2025);

        //Creamos el array Reproductor para usar Peliculas y Series
        ArrayList<Reproductor> lista = new ArrayList<>();
        lista.add(dragones);
        lista.add(caroline);
        lista.add(avatar);
        lista.add(theChosen);
        lista.add(american);

        //Creamos la var item para guardar el elemento : var que guarda los datos
        for (Reproductor item : lista){
            System.out.println(item.getNombre());
            if(item instanceof Pelicula pelicula && pelicula.getClasificacion() >= 5){ //Preguntamos si item es una instancia de pelicula
                System.out.println(pelicula.getClasificacion());
            }

        }
    }
}
