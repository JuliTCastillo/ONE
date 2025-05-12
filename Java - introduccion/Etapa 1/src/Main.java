//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido(a) a Screen Match");
        System.out.println("Pelicula: Matrix");

        int fechaDeLanzamiento = 1999; //CamelCase - dato numerico
        boolean incluidoEnElPlan = true; // boolean verdadero/falso
        double notaDeLaPelicula = 8.2; //Decimales

        double media = (8.2 + 6.0 + 9.0) / 3;

        System.out.println(media);

        String sinopsis = """
                Matrix es una paradoja 
                La mejor pelicula del fin del milenio
                Fue lanzada en: 
                """ + fechaDeLanzamiento; //texto

        System.out.println(sinopsis);

        int clasificacion = (int)(media / 2);
        System.out.println(clasificacion);
    }
}