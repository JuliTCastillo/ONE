package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Reproductor;
import com.aluracursos.screenmatch.modelos.ReproductorOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in); //Permite le ingreso de datos
        List<Reproductor> reproducciones = new ArrayList<>();
        //Instanciamos GSON con la política
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            //Busqueda de Pelicula
            System.out.println("BUSQUEDA | Ingrese el nombre de la pelicula: ");
            String busqueda = teclado.nextLine(); //Se le solicita al usuario el dato
            //Condición de Salida del While
            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }
            try {
                //Con client es el que estará consultando
                HttpClient client = HttpClient.newHttpClient();
                //Con request es la consulta al servidor, usando un PATRÓN DE DISEÑO BUILDER
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://www.omdbapi.com/?t=" + busqueda.replace(" ", "+") + "&apikey=911abe03"))
                        .build();
                //Vinculamos al cliente con la consulta que quiere realizar para obtener su Respuesta
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());

                //Hacemos la conversion de STRING a JSON y lo guardamos en la instancia del obj Peli
                ReproductorOmdb peli = gson.fromJson(response.body(), ReproductorOmdb.class);
                System.out.println(peli);
                //generando el try-catch
                try {
                    Reproductor miPelicula = new Reproductor(peli);
                    System.out.println("Titulo ya convertido: " + miPelicula);
                    //Añadimos las peliculas que se vayan buscando
                    reproducciones.add(miPelicula);


                } catch (NumberFormatException e) {
                    System.out.println("Ocurrio un error: ");
                    System.out.println(e.getMessage());
                }

            } catch (IllegalArgumentException e){
                System.out.println("Ocurrio un error: Verifique la URI");
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(reproducciones);
        //Instanciamso al clase FileWrite y creamos un archivo .txt
        FileWriter escritura = new FileWriter("peliculas.txt");
        //Usamos el metodo para escribir la pelicula que buscamos, importante el .toString (ya que es JSON)
        escritura.write(gson.toJson(reproducciones));
        //Es una buena practica cerrar la clase
        escritura.close();

    }
}
