import threading
import time

class Multihilo(threading.Thread):
    def run(self):
        try:
            for i in range(5):
                print(f"{threading.current_thread().name} ejecutando iteración {i}")
                time.sleep(0.5)
        except Exception as e:
            print(f"Error en {threading.current_thread().name}: {e}")

hilo1 = Multihilo()
hilo2 = Multihilo()

hilo1.start()
hilo1.join()

hilo2.start()
hilo2.join()

print("Fin del hilo principal")
