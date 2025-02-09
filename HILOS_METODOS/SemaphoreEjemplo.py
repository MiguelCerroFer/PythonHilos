import threading
import time

class SemaphoreEjemplo:
    semaphore = threading.Semaphore(1)

    @staticmethod
    def tarea():
        try:
            print(f"{threading.current_thread().name} esperando el acceso...")
            SemaphoreEjemplo.semaphore.acquire()

            print(f"{threading.current_thread().name} obtuvo el acceso.")
            time.sleep(1)
        except Exception as e:
            print(f"Hilo interrumpido: {e}")
        finally:
            SemaphoreEjemplo.semaphore.release()
            print(f"{threading.current_thread().name} liberó el acceso.")

if __name__ == "__main__":
    hilos = []
    for i in range(5):
        hilo = threading.Thread(target=SemaphoreEjemplo.tarea, name=f"Hilo-{i}")
        hilos.append(hilo)
        hilo.start()
        hilo.join()
