package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Reproductor;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        //Creamos la lista
        ArrayList<String> listaDeArtista = new ArrayList<>();
        listaDeArtista.add("Penelope Cruz");
        listaDeArtista.add("Antonio Banderas");
        listaDeArtista.add("Ricardo Darin");

        System.out.println("Lista de Artistas NO ordenada " + listaDeArtista);
        //Ordenamiento de lista
        Collections.sort(listaDeArtista);
        System.out.println("Lista de Artistas ordenada " + listaDeArtista);

        System.out.println("Lista de pelicula No ordenada " + lista);
        Collections.sort(lista);
        System.out.println("Lista de pelicula ordenada " + lista);

        /* * ORDENAMIENTO DE FECHA DE LANZAMIENTO * *
        * Usamos el sort que pasamos como parametros a Comparartor
        * hacemos uso de comparing en donde debemos indicar que clase padre
        * para pasarle la fecha de lanzamiento
        * */
        lista.sort(Comparator.comparing(Reproductor::getFechaDeLanzamiento));
        System.out.println("Lista de pelicula y Serie por fecha? " + lista);


    }
}
