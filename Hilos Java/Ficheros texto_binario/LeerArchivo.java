import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivo {
    public static void main(String[] args) {
        File fichero = new File("archivo.txt");

        Scanner lector = null; 
        try {
            
            lector  = new Scanner(fichero);
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());;
                
            }

        } catch (IOException e) {
            // TODO: handle exception
            System.err.println("Error al leer el archivo"+ e.getMessage());
        }
    }
}
