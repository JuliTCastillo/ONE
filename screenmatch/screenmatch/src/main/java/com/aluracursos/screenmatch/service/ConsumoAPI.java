package com.aluracursos.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    /**
     * Esta funcion realiza consulta a cualquier API
     **/

    public String ObtenerDatos(String url){
        //Cliente de la consulta
        HttpClient client = HttpClient.newHttpClient();
        //Request generando la consulta con la url
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        //Generamos el try-catch para evitar errores con la API
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Devolvemos el valor de la consulta http
        String json = response.body();
        return json;
    }
}
