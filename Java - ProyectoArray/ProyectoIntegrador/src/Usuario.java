import java.util.ArrayList;

public class Usuario {
    private float limiteTarjeta;

    public void actualizarLimite(float valorDeProducto){
        setLimiteTarjeta(this.limiteTarjeta - valorDeProducto);
    }

    public boolean conversionDeDatos(String valor, String DatoAConvertir){
        //usamos un try-catch para validar la conversion del dato
        try{
            switch (DatoAConvertir){
                case "float":
                    Float.parseFloat(valor);
                    break;
                case "int":
                    //Se convierte a float si es posible y devuelve un true
                    Integer.parseInt(valor);
                    break;
                default: return false; //Si ingresa un tipo de dato no definido
            }
            return true;
        } catch (Exception e) {
            return false; //En el caso de que el dato no se pueda convertir se dispara el catch
        }
    }

    // --------SETTER-----------
    public void setLimiteTarjeta(float limiteTarjeta) {
        this.limiteTarjeta = limiteTarjeta;
    }
    // --------GETTER-----------
    public float getLimiteTarjeta() {
        return limiteTarjeta;
    }
}
