import time
import heapq

class PlanificadorTareas:
    def __init__(self, nombre, tiempo_ejecucion):
        self.nombre = nombre
        self.tiempo_ejecucion = tiempo_ejecucion
        self.tiempo_restante = tiempo_ejecucion
        self.tiempo_inicio = 0
        self.tiempo_fin = 0

def ejecutarFCFS(tareas):
    tiempo_actual = 0
    for tarea in tareas:
        tarea.tiempo_inicio = tiempo_actual
        tarea.tiempo_fin = tiempo_actual + tarea.tiempo_ejecucion
        tiempo_actual = tarea.tiempo_fin
        print(f"{tarea.nombre} se inició a los {tarea.tiempo_inicio} y terminó a los {tarea.tiempo_fin}")
        time.sleep(0.5)

def ejecutarRR(tareas, quantum):
    tiempo_actual = 0
    while tareas:
        for tarea in tareas[:]:
            if tarea.tiempo_restante > quantum:
                print(f"{tarea.nombre} se ejecuta desde {tiempo_actual} hasta {tiempo_actual + quantum}")
                tarea.tiempo_restante -= quantum
                tiempo_actual += quantum
                time.sleep(1)
            else:
                print(f"{tarea.nombre} se ejecuta desde {tiempo_actual} hasta {tiempo_actual + tarea.tiempo_restante}")
                tiempo_actual += tarea.tiempo_restante
                time.sleep(1)
                tareas.remove(tarea)

def ejecutarSRT(tareas):
    cola_tareas = [(t.tiempo_restante, t) for t in tareas]
    heapq.heapify(cola_tareas)
    
    tiempo_actual = 0
    while cola_tareas:
        _, tarea = heapq.heappop(cola_tareas)
        if tarea.tiempo_restante > 0:
            print(f"{tarea.nombre} se ejecuta desde {tiempo_actual} hasta {tiempo_actual + tarea.tiempo_restante}")
            tiempo_actual += tarea.tiempo_restante
            tarea.tiempo_restante = 0

tareas = [
    PlanificadorTareas("Tarea 1", 5),
    PlanificadorTareas("Tarea 2", 8),
    PlanificadorTareas("Tarea 3", 3),
    PlanificadorTareas("Tarea 4", 9),
    PlanificadorTareas("Tarea 5", 6)
]

print("Selecciona el algoritmo de planificación")
print("1. FCFS (First-come, First-served)")
print("2. RR (Round Robin)")
print("3. SRT (Shortest Remaining Time)")

opcion = int(input())
if opcion == 1:
    ejecutarFCFS(tareas)
    ejecutarFCFS(tareas)
elif opcion == 2:
    ejecutarRR(tareas, 2)
    ejecutarRR(tareas, 2)
elif opcion == 3:
    ejecutarSRT(tareas)
    ejecutarSRT(tareas)

print("Fin del planificador de tareas")
