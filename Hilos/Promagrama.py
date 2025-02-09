import threading
class Promagrama:
    def main(self):
        tarea = EjemploRunnable()
        hilo = threading.Thread(target=tarea.run)
        hilo.start()
        hilo.join()
        print("Fin del hilo principal")
