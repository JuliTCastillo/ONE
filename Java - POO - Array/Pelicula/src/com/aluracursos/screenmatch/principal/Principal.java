package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("La princesa y el sapo", 2015); //Instanciamos la clase
        miPelicula.setDuracionEnMinuto(127);
        miPelicula.muestraFichaTecnica();

        Serie casaDragon = new Serie("La casa del dragon", 2022);
        casaDragon.setTemporada(1);
        casaDragon.setMinutosPorEpisodios(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinuto());

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("Bienvenido a casa");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(300);
        filtroRecomendacion.filtra(episodio);

        //******Nueva implementacion de codigo******//
        /* *
        *  var hace una inferencia del tipo de dato que se le esta asignando
        *  El codigo se veria asi: (NO CAMBIA EL TIPO DE DATO)
        *  Pelicula caroline = new Pelicula();
        * */
        var caroline = new Pelicula("Caroline y la puerta secreta", 2012);
        caroline.setDuracionEnMinuto(140);

        //Indicamos que queremos crear un ArrayList<Tipo-de-datos>
        ArrayList<Pelicula> listaDePelicula = new ArrayList<>();
        listaDePelicula.add(miPelicula);
        listaDePelicula.add(caroline);

        System.out.println("Tamaño de la lista: " + listaDePelicula.size());
        System.out.println("La primera pelicula es: " + listaDePelicula.get(0).getNombre());

        //Muestra el titulo de la pelicula de la pos 0
        System.out.println("toString de la pelicula: " + listaDePelicula.get(0).toString());
        //toString realiza un for de los elementos y nos da el titulo de cada pelicula
        System.out.println(listaDePelicula.toString());

        Object object = miPelicula;
    }
}
