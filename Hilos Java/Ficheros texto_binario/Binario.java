import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Binario {
     public static void main(String[] args) {
        Producto_Binario producto = new Producto_Binario("Laptop", 2000);

        String archivo = "producto.dat";

        //Serialización
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))){
            oos.writeObject(producto);
            System.out.println("Objeto serailizado y guardado en :" +archivo);
        } catch (Exception e) {
            // TODO: handle exception
        }

        //Deserialización
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Producto_Binario productoLeido = (Producto_Binario) ois.readObject();
            System.out.println("Objeto Deserializado: "+productoLeido);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
     }
}
