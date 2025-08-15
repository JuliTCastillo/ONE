package com.example.ProyectoBiblioteca.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
