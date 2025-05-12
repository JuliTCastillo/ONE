import java.util.Scanner;

public class Evaluaciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota = 0;
        double mediaEvaluaciones = 0;
        int contador = 0;

        //Condicion de salida
        while (nota != -1){
            System.out.println("Escriba que nota le darias a la pelicula Matrix");
            nota = teclado.nextDouble();
            if(nota != -1){
                mediaEvaluaciones += nota;
                contador++;
            }
        }
        System.out.println("La media de evaluaciones de Matrix es: " + mediaEvaluaciones / contador);

    }
}
