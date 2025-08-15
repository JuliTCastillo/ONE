package com.example.ProyectoBiblioteca.Principal;

import com.example.ProyectoBiblioteca.model.Datos;
import com.example.ProyectoBiblioteca.model.DatosLibros;
import com.example.ProyectoBiblioteca.service.ConsumoAPI;
import com.example.ProyectoBiblioteca.service.ConvierteDatos;
import com.example.ProyectoBiblioteca.service.IConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String API_BASE = "http://gutendex.com/books/";
    private IConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu(){
        var json = consumoAPI.ObtenerDatos(API_BASE);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 de libros mas descargado
        System.out.println("\n-->Libros mas descargados<--");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::cantidadDescargas).reversed())
                .map(l -> l.titulo().toUpperCase())
                .limit(10)
                .forEach(System.out::println);

        //Buscando libro
        System.out.println("\n-->Ingrese el libro que desea buscar: <--");
        var libro = teclado.nextLine();

        var libroEncontrado = datos.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(libro.toUpperCase()))
                .findFirst();

        if(libroEncontrado.isPresent()){
            System.out.println("Episodio encontrado: ");
            System.out.println("Los datos son : " + libroEncontrado.get());
        }
        else {
            System.out.println("Episodio no encontrado! ");
        }

        //Generando estadisticas
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d-> d.cantidadDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibros::cantidadDescargas));

        System.out.println("\n-->Datos Estadisticos: <--");

        System.out.println("Media de las descargas: " + est.getAverage());
        System.out.println("Cantidad maxima de descargas: " + est.getMax());
        System.out.println("Cantidad minima de descargas: " + est.getMin());
    }
}
