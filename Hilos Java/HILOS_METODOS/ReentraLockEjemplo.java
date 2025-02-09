import java.util.concurrent.locks.ReentrantLock;

public class ReentraLockEjemplo {
    private static ReentrantLock lock = new ReentrantLock();

    private static int contador = 0;

    public static void main(String[] args) {
          
        Runnable tarea = () -> {
            for(int i = 0; i<5; i++){
                lock.lock();
                try{
                    contador++;
                    System.out.println(Thread.currentThread().getName() + " incrementó el contador a: "+ contador);

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("Hilo interrumpido por: "+ e.getMessage());
                    }
                }
                finally{
                    lock.unlock();
                }
            }
        };

        Thread hilo1 = new Thread(tarea, "Hilo-1");
        
        Thread hilo2 = new Thread(tarea, "Hilo-2");

        hilo1.start();

        hilo2.start();
    }
}
