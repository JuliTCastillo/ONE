package com.example.ProyectoBiblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutor(
        @JsonAlias("name")
        String nombreAutor,
        @JsonAlias("birth_year")
        Integer nacimiento,
        @JsonAlias("death_year")
        Integer fallecimiento
) {
}
