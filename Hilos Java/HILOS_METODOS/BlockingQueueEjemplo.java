import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueEjemplo {

    public static void main(String[] args) {
         BlockingQueue<Integer> queque =  new ArrayBlockingQueue<>(5);

         Runnable productor = ()-> {
            for (int i = 0; i <= 10; i++) {
                try{
                    System.out.println("Productor esta produciendo el valor: "+ i);
                    queque.put(i);
                    System.out.println("Productor a colocado el valor "+i+" en la cola.");
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    System.out.println("El productor fue interrumpido " +e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
            try{
                queque.put(-1);
            }catch(InterruptedException e){
                System.out.println("El productor fue interrumpido " +e.getMessage());
                Thread.currentThread().interrupt();
            }
            System.out.println("Productro ha terminado de producir todos los valores.");
         };
         
         Runnable consumidor = ()-> {
            while (true) {
                try {
                    Integer  valor = queque.take();
                    System.out.println( "Consumiddor ha tomado el valor: "+ valor + " de la cola.");
                    Thread.sleep(00);
                    if (valor == -1) {
                        break;
                        
                    }
                } catch (Exception e) {
                    System.out.println("El consumidor fue interrumpido: "+ e.getMessage());
                    break;
                }
            }
            System.out.println("Consumidor ha terminado de consumir.");
         };

         Thread hiloProductor = new Thread(productor);
         Thread hiloConsumidor = new Thread(consumidor);

         hiloProductor.start();
         hiloConsumidor.start();
    }
}