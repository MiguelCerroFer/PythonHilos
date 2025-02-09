import schedule
import time
import threading

class ScheduledExecutor:
    def tarea(self):
            print(f"Tarea ejecutada en: {time.time()}")

    def shutdown(self):
            print("Finalizar el scheduler...")
    global ejecutando
    ejecutando = False

schedule.every(2).seconds.do(tarea)

timer = threading.Timer(10, shutdown)
timer.start()

ejecutando = True
while ejecutando:
    schedule.run_pending()
    time.sleep(1)
