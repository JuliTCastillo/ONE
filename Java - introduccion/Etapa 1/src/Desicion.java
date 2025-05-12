public class Desicion {
    public static void main(String[] args) {
        //Datos de la pelicula
        int fechaDeLanzamiento = 1999; // numero entero
        boolean incluidoEnElPlan = false; // verdadero/falso
        double notaDeLaPelicula = 8.2; //Decimales
        String tipopPlan = "plus";

        if(fechaDeLanzamiento >= 2022){
            System.out.println("Peliculas mas populares");
        }
        else{
            System.out.println("Peliculas Retro que aun vale la pena ver");
        }

        if (incluidoEnElPlan && tipopPlan.equals("plus")){
            System.out.println("Disfruta del plan");
        }
        else {
            System.out.println("Pelicula No disponible para el plan actual");
        }
    }
}
