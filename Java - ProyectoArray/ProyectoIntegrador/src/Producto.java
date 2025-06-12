public class Producto implements Comparable<Producto>{
    private String nombre;
    private float precio;

    // --------SETTER-----------
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    // --------GETTER-----------
    public String getNombre() {
        return nombre;
    }
    public float getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Producto o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
