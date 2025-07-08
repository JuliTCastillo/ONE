package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

import java.util.Collections;

public class Reproductor implements Comparable<Reproductor>{
    //Atributos
    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
    private int duracionEnMinuto;
    private boolean incluidaEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int cantidadDeEvaluacion = 0;

    //Constructor
    public Reproductor(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Reproductor(ReproductorOmdb peli) {
        this.nombre = peli.title();
        //Usamos Integer.valueOf() porque estamos recibiendo los datos en STRING
        this.fechaDeLanzamiento = Integer.valueOf(peli.year());
        //Validamos la entrada de 'N/A'
        if(peli.runtime().contains("N/A")){
            //si es cierto, lanzamos un error
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion, "+
                    "porque contiene un 'N/A'");
        }
        this.duracionEnMinuto = Integer.valueOf(
                //Lo que hacemos es intentar convertir 3 caracteres a números,
                //En el caso de que tenga dos dígitos, reemplazamos el espacio por nada
                peli.runtime().substring(0, 3).replace(" ", "")
        );
    }

    //Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinuto(int duracionEnMinuto) {
        this.duracionEnMinuto = duracionEnMinuto;
    }

    public void setIncluidaEnElPlan(boolean incluidaEnElPlan) {
        this.incluidaEnElPlan = incluidaEnElPlan;
    }

    // Getter
    public int getTotalDeLasEvaluaciones(){
        return cantidadDeEvaluacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinuto() {
        return duracionEnMinuto;
    }

    public boolean isIncluidaEnElPlan() {
        return incluidaEnElPlan;
    }

    //metodos
    public void muestraFichaTecnica(){
        System.out.printf("""
        Mi pelicula %s \nfue estrenada en el año %d con una duracion de %d\n
        """, nombre, fechaDeLanzamiento, getDuracionEnMinuto());
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        cantidadDeEvaluacion++;
    }

    public double calcuandoMedia(){
        return sumaDeLasEvaluaciones / cantidadDeEvaluacion;
    }

    @Override
    public int compareTo(Reproductor otroReproducto) {
        //this.getNombre() - comparamos - con otroNombre de la lista
        return this.getNombre().compareTo(otroReproducto.getNombre());
    }

    @Override
    public String toString() {
        return "Reproductor{" +
                "fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", nombre='" + nombre + '\'' +
                ", duracion= "+ duracionEnMinuto +
                '}';
    }
}
