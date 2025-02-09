import java.util.*;

class Tarea {
    String nombre;
    int tiempoEjecucion;
    int tiempoRestante;
    int tiempoInicio;
    int tiempoFin;

    public Tarea(String nombre, int tiempoEjecucion) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoEjecucion;

    }

}

public class PlanificadorTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona el algoritmo de planificación");
        System.out.println("1. FCFS (First-come, First-Served)");
        System.out.println("2. RR (Round Robin)");
        System.out.println("3. SRT (Shortest Remaining Time)");
        int opcion = scanner.nextInt();

        List<Tarea> tareas = new ArrayList<>(Arrays.asList(
                new Tarea("Tarea 1", 5),
                new Tarea("Tarea 2", 8),
                new Tarea("Tarea 3", 3),
                new Tarea("Tarea 4", 9),
                new Tarea("Tarea 5", 6)));

        switch (opcion) {
            case 1:
                ejecutarFCFS(tareas);
                break;
            case 2:
                ejecutarRR(tareas, 2);
                break;
            case 3:
                ejecutarSRT(tareas);
                break;

            default:
                break;
        }
    }

    private static void ejecutarFCFS(List<Tarea> tareas) {
        int tiempoActual = 0;
        for (Tarea tarea : tareas) {
            tarea.tiempoInicio = tiempoActual;
            tarea.tiempoFin = tiempoActual + tarea.tiempoEjecucion;
            tiempoActual = tarea.tiempoFin;
        }
        for (Tarea tarea : tareas) {
            System.out.println(
                    tarea.nombre + "se inicio a los" + tarea.tiempoInicio + "y terminó a los " + tarea.tiempoFin);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private static void ejecutarRR(List<Tarea> tareas, int quantum) {
        int tiempoActual = 0;
        while (!tareas.isEmpty()) {
            Iterator<Tarea> iterator = tareas.iterator();
            while (iterator.hasNext()) {
                Tarea tarea = iterator.next();
                if (tarea.tiempoRestante > quantum) {
                    System.out.println(
                            tarea.nombre + " se ejecuta desde " + tiempoActual + " hasta " + (tiempoActual + quantum));
                    tarea.tiempoRestante -= quantum;
                    tiempoActual += quantum;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(tarea.nombre + " se ejecuta desde " + tiempoActual + " hasta "
                            + (tiempoActual + tarea.tiempoRestante));
                    tiempoActual += tarea.tiempoRestante;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    iterator.remove();
                }
            }

        }
    }

    private static void ejecutarSRT(List<Tarea> tareas) {
        PriorityQueue<Tarea> colaTareas = new PriorityQueue<>(Comparator.comparing(t -> t.tiempoRestante));
        colaTareas.addAll(tareas);

        int tiempoActual = 0;
        while (!colaTareas.isEmpty()) {
            Tarea tarea = colaTareas.poll();
            if (tarea.tiempoRestante > 0) {
                System.out.println(tarea.nombre + " se ejecuta desde " + tiempoActual + " hasta "
                        + (tiempoActual + tarea.tiempoRestante));
                tiempoActual += tarea.tiempoRestante;
                tarea.tiempoRestante = 0;

            }

        }

    }
}
