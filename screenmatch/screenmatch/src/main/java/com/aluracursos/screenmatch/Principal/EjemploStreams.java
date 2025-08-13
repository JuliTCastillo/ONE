package com.aluracursos.screenmatch.Principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Brenda", "Luis", "Maria Fernanda", "Eric", "Genesys");

        nombres.stream()
                .sorted() //Orden alfabetico
                .limit(4) //limitamos la cantidad de valores y la cantidad de los valores a usar
                .filter(n -> n.startsWith("L")) //filtro
                .map(n -> n.toUpperCase()) //Lo hacemos mayuscula
                .forEach(System.out::println); //mostramos
    }
}
