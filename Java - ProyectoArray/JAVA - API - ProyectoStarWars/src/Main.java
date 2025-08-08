import java.io.IOException;
import java.util.Scanner;

//TIP Objetivo <b>Proyecto API Star Wars</b>:
// <ul>
// <li>Crear una aplicación para consultar las peliculas de Star Wars mediante la <b>API SWAPI</b></li>
// <li>Menú para que el usuario elija la pelicula que quiere buscar</li>
// <li>Generar un archivo .JSON con los datos de las peliculas</li>
// </ul>
public class Main {
    public static void main(String[] args) {
        Scanner lectura =  new Scanner(System.in);
        ConsultarPelicula consulta = new ConsultarPelicula();

        System.out.println("Escriba el numero de la pelicula de Star Wars que quiere consultar: ");

        try{
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            Pelicula peli = consulta.buscarPelicula(numeroDePelicula);
            System.out.println(peli);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.GuardarJson(peli);
        }
        catch (NumberFormatException e){
            System.out.println("Numero no encontrado " + e.getMessage());
        }
        //                        Este es la excepcion del generadorDeArchivo
        catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }
    }
}