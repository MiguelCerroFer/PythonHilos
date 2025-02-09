public class multihilo {
    static class tarea extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "ejecutando iteración " + i);
            try {
                
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
            }
        }

        public static void main(String[] args) {
            Thread hilo1 = new Thread(new tarea());
            Thread hilo2 = new Thread(new tarea());

            hilo1.start();
            
            try {
                hilo1.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            hilo2.start();
            try {
                hilo2.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Fin del hilo principal");
            System.out.println("Fin del hilo principal");
        }
        
    }
}
