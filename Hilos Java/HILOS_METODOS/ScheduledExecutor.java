import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    
public static void main(String[] args) {
    
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    Runnable tarea = () -> System.out.println( "Tarea ejecutada en: " + System.currentTimeMillis());

    scheduler.scheduleAtFixedRate(tarea, 0 , 2, TimeUnit.SECONDS);

    scheduler.schedule(()->{
        System.out.println("Finalizar el scheduler...");

        scheduler.shutdown();
    }, 10, TimeUnit.SECONDS);
}
}
