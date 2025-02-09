import java.util.concurrent.Semaphore;

public class SemaphoreEjemplo {
    private static Semaphore semaphore = new Semaphore(1);
    
    public static void main(String[] args) {
        Runnable tarea= ()->{
            try {
                System.out.println(Thread.currentThread().getName() + "esperando el acceso...");
                semaphore.acquire();

                System.out.println(Thread.currentThread().getName()+" obtuvo el acceso.");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Hilo interrumpido: " +e.getMessage());
            }finally{
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+ " liberó el acceso.");
            }
        };

        Thread[] hilos = new Thread[5];
         
        for(int i = 0; i <5; i++){
            hilos[i] = new Thread(tarea, "Hilo-"+i);
            hilos[i].start();
            try{
                hilos[i].join();
            }catch(InterruptedException e){
                System.out.println("Hilo interrumpido: " + e.getMessage());
            }
        }   
    }
}