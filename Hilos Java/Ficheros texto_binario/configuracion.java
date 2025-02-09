import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configuracion {
    public static void main(String[] args) {
        Properties configuracion = new Properties();

         String miUsuario = "Admin";
         String miContrasena = "12345";
         String  elServidor = "localhost";
         String elPuerto = "8080";

         configuracion.setProperty("user", miUsuario);
         configuracion.setProperty("password", miContrasena);
         configuracion.setProperty("server", elServidor);
         configuracion.setProperty("port", elPuerto);
         try{
            configuracion.store(new FileOutputStream("configuracion.conf")
            ,"Fichero de configuracion");
         }catch(FileNotFoundException fnfe){

         }catch(IOException e){
            
         }
    }
}
