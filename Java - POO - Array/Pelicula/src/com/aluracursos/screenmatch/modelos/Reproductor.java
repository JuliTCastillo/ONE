package com.aluracursos.screenmatch.modelos;

public class Reproductor {
    //Atributos
    private String nombre;
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
}
