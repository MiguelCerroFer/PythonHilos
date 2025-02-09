public class ejemploAnonima {
    public static void main(String[] args) {
        
        Thread hilo = new Thread( new Runnable() {
            @Override
            public void run (){
                for(int i = 0; i< 10; i++){
                    System.out.println("Soy un hilo");
                }
            }
        });

        hilo.start();
        System.out.println("Fin del hilo principal");
    }
}
