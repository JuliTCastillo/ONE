import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota = 0;
        double mediaEvaluaciones = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("Escriba que nota le darias a la pelicula Matrix");
            nota = teclado.nextDouble();
            mediaEvaluaciones = mediaEvaluaciones + nota;
        }
        System.out.println("La media de evaluaciones de Matrix es: " + mediaEvaluaciones / 3);
    }
}
