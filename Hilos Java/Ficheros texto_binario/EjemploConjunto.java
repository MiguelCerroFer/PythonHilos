import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class EjemploConjunto {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("fichero.txt"))){
            writer.write("Texto  a escribir\n");
            writer.write("Otra linea de texto");
        } catch (Exception e) {
            // TODO: handle exception
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("fichero.txt"))){
            String cadena = reader.readLine();
            
            while (cadena != null) {
                System.out.println(cadena);
                cadena = reader.readLine();
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
