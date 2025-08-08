import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    //                                         Se agrega para que no tire error FileWrite
    public void GuardarJson(Pelicula pelicula) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Creamos un archivo con el nombre de la pelicula y el formato json
        FileWriter escritura = new FileWriter(pelicula.title()+".json");
        escritura.write(gson.toJson(pelicula));
        escritura.close(); // No olvidar cerrar
    }
}
