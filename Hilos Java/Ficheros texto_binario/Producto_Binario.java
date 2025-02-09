import java.io.Serializable;

public class Producto_Binario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private float precio;

    public Producto_Binario(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


    @Override
    public String toString(){
        return "Producto {nombre ="+ nombre +", Precio="+ precio+" }";
        }
}