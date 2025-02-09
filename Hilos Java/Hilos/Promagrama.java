

public class Promagrama {
    public static void main(String[] args) {
        EjemploRunnable tarea = new EjemploRunnable();
        Thread hilo = new Thread(tarea);
        hilo.start();
        System.out.println("Fin del hilo principal");
    }
}
