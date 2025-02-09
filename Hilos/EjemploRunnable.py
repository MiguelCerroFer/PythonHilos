import threading

class OtraClase:
    def imprimir_mensaje(self):
        print("Mensaje desde OtraClase")

class EjemploRunnable(OtraClase, threading.Thread):
    def run(self):
        for _ in range(10):
            print("Soy un hilo")
        self.imprimir_mensaje()

hilo = EjemploRunnable()
hilo.start()
hilo.join()
