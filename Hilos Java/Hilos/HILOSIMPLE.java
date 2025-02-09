/**
 * HILOSIMPLE
 */
public class HILOSIMPLE {

    static class Tarea_Hilo extends Thread{
        @Override
        public void run(){
            for (int i = 0; i<10; i++){
                System.out.println("Soy un hilo");
            }
        }

    }

    public static void main(String[] args) {
        Tarea_Hilo tarea = new Tarea_Hilo();
        Thread hilo = new Thread(tarea);
        hilo.start();
        System.out.println("Fin del Hilo principal");
    }
}