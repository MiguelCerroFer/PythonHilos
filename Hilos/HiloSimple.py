import threading

class HiloSimple(threading.Thread):
    def run(self):
        for _ in range(10):
            print("Soy un hilo")

hilo = HiloSimple()
hilo.start()
hilo.join()

print("Fin del Hilo principal")
