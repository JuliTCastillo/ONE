import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Funcionamiento {
    public float conversionDeMoneda(float precioMoneda, float cantidadMoneda){
        return cantidadMoneda * precioMoneda;
    }

    public void RegistrarConversion(String mensaje) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Creamos un archivo con el nombre de la pelicula y el formato json
        FileWriter escritura = new FileWriter("HistorialConversion.txt", true);
        escritura.write(mensaje+"\n-----------------------\n");
        escritura.close(); // No olvidar cerrar
    }
}
