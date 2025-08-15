package com.example.ProyectoBiblioteca.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class ConsumoAPI {
    //Funcion para realizar consulta a cualquier API

    public String ObtenerDatos(String url){
        //Cliente de la consula
        HttpClient cliente = HttpClient.newHttpClient();

        //Creamos la request para llamar a la consulta
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        //Creamos una variable null por ahora para que se guarde la respuesta de la consulta que realizamos
        HttpResponse<String> respuesta = null;

        //Generamos el try-catch para evitar errores con la API
        try {
            //Si todo sale bien pedimos que se envie la consulta y obtener la respuesta del body
            respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        //Devolvemos el valor del body
        return respuesta.body();
    }
}
