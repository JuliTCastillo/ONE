import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre = "Tony Stark";
        String tipoCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;
        System.out.printf("""
                ********************************
                
                Nombre del cliente: %s
                Tipo de Cuenta: %s
                Saldo disponible : %.2f
                
                ********************************
                """, nombre, tipoCuenta, saldo);

        while ( opcion != 9){
            System.out.println("""
                    ** Escriba el numero de la opcion deseada **
                    1 - Consultar saldo
                    2 - Retirar
                    3 - Depositar
                    9 - Salir
                    """);
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Su saldo actual es: " + saldo);
                    break;
                case 2:
                    System.out.println("Escriba el monto que desea retirar:");
                    double retiro = teclado.nextDouble();
                    if(retiro <= saldo){
                        saldo -= retiro;
                        System.out.printf("Usted ha retirado %.2f$ su saldo actual es %.2f$\n", retiro, saldo);
                    }
                    else{
                        System.out.printf("""
                                Error: Quiere retirar un saldo mayor al que tiene
                                Ingrese un valor menor de %.2f\n
                                """, saldo);
                    }
                    break;
                case 3:
                    System.out.println("Escriba el monto que va a depositar:");
                    double deposito = teclado.nextDouble();
                    saldo+= deposito;
                    System.out.printf("Usted deposito %.2f, su saldo actual es %.2f\n", deposito, saldo);
                    break;
                case 9:
                    System.out.println("Usted a salido del sistema!");
                    break;
                default:
                    System.out.println("Error: La opcion elegida no existe!");
            }
        }
    }
}
