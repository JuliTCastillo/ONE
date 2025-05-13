package com.aluracursos.screenmatch.modelos;

public class Serie extends Reproductor{
    private int temporada;
    private int episodiosPorTemporada;
    private int minutosPorEpisodios;

    //Setter
    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setMinutosPorEpisodios(int minutosPorEpisodios) {
        this.minutosPorEpisodios = minutosPorEpisodios;
    }

    //Getter

    public int getTemporada() {
        return temporada;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public int getMinutosPorEpisodios() {
        return minutosPorEpisodios;
    }

    //Metodos
    @Override //Indica que estamos sobreEscribiendo un metodo de la clase Reproductor
    public int getDuracionEnMinuto() {
        return temporada * episodiosPorTemporada * minutosPorEpisodios;
    }
}
