import threading
import time

class ReentraLockEjemplo:
    lock = threading.RLock()
    contador = 0

    @staticmethod
    def tarea():
        for _ in range(5):
            with ReentraLockEjemplo.lock:
                ReentraLockEjemplo.contador += 1
                print(f"{threading.current_thread().name} incrementó el contador a: {ReentraLockEjemplo.contador}")
                try:
                    time.sleep(0.5)
                except Exception as e:
                    print(f"Hilo interrumpido por: {e}")

if __name__ == "__main__":
    hilo1 = threading.Thread(target=ReentraLockEjemplo.tarea, name="Hilo-1")
    hilo2 = threading.Thread(target=ReentraLockEjemplo.tarea, name="Hilo-2")

    hilo1.start()
    hilo2.start()

    hilo1.join()
    hilo2.join()
