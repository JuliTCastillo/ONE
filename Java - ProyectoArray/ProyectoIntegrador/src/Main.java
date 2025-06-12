import java.util.*;

// crear una aplicación para realizar compras en una tarjeta de crédito,
// un menú para ejecutar esas compras y la exhibición de la lista de
// compras realizadas y ordenadas por valor.

public class Main {
    public static void main(String[] args) {

        //permite ingresar datos
        Scanner teclado = new Scanner(System.in);
        boolean comprando = true; //variable bandera de productos
        boolean proceso = true; //variable bandera de proceso

        List<Producto> listaProducto = new ArrayList<>();

        //Menu de bienvenida
        System.out.println("""
                ╒══════════════════════════════════════╕
                |   Bienvenido/a a tu tienda online    |
                ╘══════════════════════════════════════╛
        """);
        Usuario user = new Usuario(); //Instanciamos el obj usuario
        String valor = pedirDato(teclado, "Ingrese el limite de su tarjeta: ");

        if(user.conversionDeDatos(valor, "float")){
            user.setLimiteTarjeta(Float.parseFloat(valor));
            while (comprando) {
                String opcion = pedirDato(
                        teclado,
                        """
                            ⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳Usted esta comprando˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅
                            ╒══════════════════════════════════════╕
                            | 1- Para comprar producto.            |
                            | 0- Para salir.                       |
                            ╘══════════════════════════════════════╛
                        """
                );

                if(user.conversionDeDatos(opcion,"int")){
                    int seleccion = Integer.parseInt(opcion);
                    switch (seleccion){
                        case 0:
                            comprando = false;
                            motrarLista(listaProducto);
                            break;
                        case 1:
                            System.out.println("⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳Procesando producto˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅");
                            Producto producto = new Producto();
                            producto.setNombre(pedirDato(teclado, "Ingrese el nombre de su producto:"));
                            String datoPrecio = pedirDato(teclado, "Ingrese el precio de su producto:");
                            if(user.conversionDeDatos(datoPrecio, "float")){ //Verificamos se puede convertir a float
                                if (user.getLimiteTarjeta() >= Float.parseFloat(datoPrecio)){ //Controlamos el limite de tarjeta
                                    user.actualizarLimite(Float.parseFloat(datoPrecio)); //Actualizamos el gasto de la tarjeta
                                    producto.setPrecio(Float.parseFloat(datoPrecio)); //Agregamos el dato del precio del producto
                                    listaProducto.add(producto);
                                    System.out.println("🛒 Producto agregado al carrito.");
                                }
                                else{
                                    System.out.printf("El producto que desea comprar supera al limite de la tarjeta\nSu limite es de $%.2f\n", user.getLimiteTarjeta());
                                }
                            }
                            else{
                                mensajeError();
                            }
                            break;
                        default:
                            System.out.println("No existe esa opcion, intente de nuevo!");
                    }
                }
                else{
                    mensajeError();
                }
            }
        }
        else {
            mensajeError();
        }
    }

    // ✅ MÉTODO ESTÁTICO PARA MOSTRAR MENSAJE DE ERROR
    public static void mensajeError() {
        System.out.println("""
             ╒══════════════════════════════════════╕
             |   ⭙ERROR, No se ingreso un numero   |
             ╘══════════════════════════════════════╛
        """);
    }
    public static String pedirDato(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }
    public static void motrarLista(List<Producto> lista) {
        lista.sort(Comparator.comparing(Producto::getPrecio));
        for (Producto prod : lista){
            System.out.println("El producto cargado es:\n"+prod.getNombre()+ " | precio: $" + prod.getPrecio());
        }
    }
}