import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Importamos el scanner para recibir los datos del usuario
        Scanner teclado = new Scanner(System.in);
        //Instanciamos la Clase de la API
        ConsultaAPI consulta = new ConsultaAPI();
        //Instanciamos la clase Conversion
        Funcionamiento funcionamiento = new Funcionamiento();

        //Creamos una variable bandera para salir del programa
        boolean programaCorriendo = true;
        float moneda = 0;

        //Creando Matriz de conversion
        String[][] opciones = {
                {"USD", "ARS"},   // 1
                {"ARS", "USD"},   // 2
                {"USD", "BRL"},   // 3
                {"BRL", "USD"},   // 4
                {"USD", "COP"}, // 5
                {"COP", "USD"}  // 6
        };


        while (programaCorriendo){
            try {
                generarMenu(); //Muestra el menu del programa
                int respuesta = teclado.nextInt();
                if (respuesta >= 1 && respuesta <= opciones.length) {
                    String origen = opciones[respuesta - 1][0]; //El nombre de la moneda que tenemos
                    String destino = opciones[respuesta - 1][1]; //El nombre de la moneda que queremos convertir
                    moneda = consulta.consultarMoneda(origen, destino); //Consultamos el precio

                    System.out.println("Ingrese el valor de la moneda que quiere convertir");
                    float cantidadDePesos = teclado.nextFloat();

                    float conversionFinal = funcionamiento.conversionDeMoneda(moneda, cantidadDePesos);
                    String mensaje = "El proceso de conversión es el siguiente: \n" + cantidadDePesos + origen + " a " + destino + " es de " + conversionFinal + destino;
                    System.out.println(mensaje);
                    funcionamiento.RegistrarConversion(mensaje);
                } else if (respuesta == opciones.length + 1) {
                    programaCorriendo = false;
                    System.out.println("El programa ha finalizado");
                } else {
                    System.out.println("La opción ingresada no existe!\nIntente de nuevo...");
                }
            }catch (InputMismatchException e) {
                String entrada = teclado.next(); // Leer lo que causó el error
                if (entrada.matches("\\d+\\.\\d+")) {
                    System.out.println("ERROR! ingresaste un decimal con punto, use la coma!");
                } else {
                    System.out.println("ERROR! ingresaste texto: " + entrada + "\nIngrese un valor del menú!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void generarMenu(){
        System.out.println(
                """
                ***************************************
                Sea Bienvenido/a al conversor de monedas:
                1) Dólar ==> Peso Argentino
                2) Peso Argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño ==> Peso Argentino
                5) Dólar ==> Peso colombiano
                6) Peso colombiano ==> Dólar
                7) Salir
                ***************************************
                Elija una opción... 
                """
        );
    }
}