import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarPelicula {

    public  Pelicula buscarPelicula (int idPelicula) {
        //Creamos la direccion de API
        URI direccion = URI.create("https://swapi.py4e.com/api/films/" + idPelicula);
        //Creamos al cliente que consume la API
        HttpClient cliente = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        /* * *
         *  TODO | Debido que la API nos tiraba un ESTADO 301 Eso indica que la URL que se usa se esta
         *  cambiando  y el servidor esta redirigiendo a una nueva URL. Por lo que hacemos un newBuilder a Cliente
         *  con .followRedirects(HttpClient.Redirect.ALWAYS), le estás diciendo a tu HttpClient que siga
         *  automáticamente cualquier redirección que reciba del servidor.
         * * */

        //Creamos la consulta para la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa película");
        }
    }
}
