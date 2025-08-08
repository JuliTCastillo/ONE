import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public float consultarMoneda(String monedaPrincipal, String monedaSecundaria){
        //Instanciamos Gson para tener manupulacion con JSON
        Gson gson = new Gson();
        //Creamos la URL de la consulta http
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/bdadf35f7db66e6747227f2c/pair/"+monedaPrincipal+"/"+monedaSecundaria);

        /** GENERAMOS HTTP Client, Request y Response **/
        //--> Cliente
        HttpClient client = HttpClient.newHttpClient();
        //--> Request | La consulta al servidor, usando un PATRÓN DE DISEÑO BUILDER
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        //--> Response | Usamos try-catch para evitar errores con la conexion de la API
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonElement elemento = JsonParser.parseString(response.body());
            JsonObject objectRoot = elemento.getAsJsonObject();

            return objectRoot.get("conversion_rate").getAsFloat();
        }
        catch (Exception e){
            throw new RuntimeException("No encontre esa moneda");
        }
    }
}
