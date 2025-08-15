package com.aluracursos.screenmatch.Principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSeries;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t="; //Constante, van con mayúscula
    private final String API_KEY = "&apikey=911abe03"; //Constante van con mayúscula
    private ConvierteDatos conversor = new ConvierteDatos();

    //Busca una serie
    public void muestraElMenu(){
        System.out.println("Por favor escribe el nombre de la serie que deseas buscar:");
        String nombreSerie = teclado.nextLine();
        //Los espacios que se hagan en el nombre de la serie seran reemplazadas con un "+"
        var json = consumoAPI.ObtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json , DatosSeries.class);

        System.out.println(datos);

        //Busca los datos de las temporadas
        DatosEpisodio episodio = conversor.obtenerDatos(json, DatosEpisodio.class);
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoAPI.ObtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season="+ i + API_KEY);
            var datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporada);
        }

        //temporadas.forEach(System.out::println);

        //Mostrar solo el titulo de los episodios para las temporadas
        /*
        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }*/

        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));


        //Convertir todas las informaciones a una lista del tipo DatosEpisodios
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                //Separamos las temporadas a episodios
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList()); //Estamos colocando los datos en una lista mutable

        //Top 5 episodios
        System.out.println("TOP 5 EPISODIOS");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equals("N/A"))
                //.peek(e -> System.out.println("Primer filtro (N/A) " + e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed()) //ordenamos segun su evaluacion e invertimos para obtener mayor a menor
                //.peek(e -> System.out.println("Ordenamiento de (M>m) " + e))
                .map(e-> e.titulo().toUpperCase())
                //.peek(e -> System.out.println("tercer filtro Mayusculas" + e))
                .limit(5);
                //.forEach(System.out::println);

        //Convirtiendo los datos a una lista de episodios
        List<Episodio> episodios = temporadas.stream()
                .flatMap(
                        t->t.episodios().stream()
                                .map(d-> new Episodio(t.numero(), d))
                )
                .sorted(Comparator.comparing(Episodio::getEvaluacion).reversed()) //ordenamos segun su evaluacion e invertimos para obtener mayor a menor
                //.limit(5)
                .collect(Collectors.toList());

        //episodios.forEach(System.out::println);

        //Busqueda de episodios segun un año
        /*
        System.out.println("Indica el año que quiere ver los episodios: ");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada " + e.getTemporada() +
                                "Episodio " + e.getTitulo() +
                                "Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
                ));
        */

        //Busca episodios por titulo
        /*System.out.println("Ingrese una parte del titulo del episodio que quiere buscar: ");
        var parteDelTitulo = teclado.nextLine();
        Optional<Episodio> episodioBuscado =  episodios.stream()
                //Filtramos por episodio, obtenemos el titulo y vamos a seleccionar aquellos que tenga una coincidencia con lo que el usuario ingreso
                .filter(e-> e.getTitulo().toUpperCase().contains(parteDelTitulo.toUpperCase()))
                .findFirst(); //Va a buscar la coincidencia

        if(episodioBuscado.isPresent()){
            System.out.println("Episodio encontrado: ");
            System.out.println("Los datos son : " + episodioBuscado.get());
        }
        else {
            System.out.println("Episodio no encontrado! ");
        }*/

        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e-> e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getEvaluacion)));

        System.out.println(evaluacionesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e-> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));

        System.out.println("Media de las evaluaciones: " + est.getAverage());
        System.out.println("Episodio Mejor evaluado: " + est.getMax());
        System.out.println("Episodio Peor evaluado: " + est.getMin());

    }


}
