package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
    //<T> T ) Indica que estamos hablando de tipo de datos genericos
    <T> T obtenerDatos(String json, Class<T> clase);
}
