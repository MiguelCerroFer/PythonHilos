import java.io.IOException;
import java.io.PrintWriter;

public class EscribirArchivo {

    public static void main(String[] args) {
        PrintWriter escritor = null;

        try{
            escritor = new PrintWriter("archivo.txt");
        
            escritor.println("Esto es una linea del fichero");
            escritor.write("Esto es una linea del fichero");
            System.out.println("El archivo ha sido creado y escrito");
            escritor.close();
        }catch(IOException e){

        }
    }
}