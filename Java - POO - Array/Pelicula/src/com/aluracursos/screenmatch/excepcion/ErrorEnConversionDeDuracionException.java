package com.aluracursos.screenmatch.excepcion;

public class ErrorEnConversionDeDuracionException extends RuntimeException {

    private String mensaje;

    public ErrorEnConversionDeDuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        //Sobre escribimos el metodo que se encuentra en la clase Padre RuntimeException
        return this.mensaje;
    }
}
