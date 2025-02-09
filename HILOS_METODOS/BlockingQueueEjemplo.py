import threading
import queue
import time

class BlockingQueueEjemplo:
    def __init__(self):
        self.queque = queue.Queue(maxsize=5)
    
    def productor(self):
        for i in range(11):
            try:
                print(f"Productor está produciendo el valor: {i}")
                self.queque.put(i)
                print(f"Productor ha colocado el valor {i} en la cola.")
                time.sleep(0.5)
            except Exception as e:
                print(f"El productor fue interrumpido: {e}")
        
        self.queque.put(-1)
        print("Productor ha terminado de producir todos los valores.")
    
    def consumidor(self):
        while True:
            try:
                valor = self.queque.get()
                print(f"Consumidor ha tomado el valor: {valor} de la cola.")
                time.sleep(0.1)
                if valor == -1:
                    break
            except Exception as e:
                print(f"El consumidor fue interrumpido: {e}")
                break
        print("Consumidor ha terminado de consumir.")

if __name__ == "__main__":
    ejemplo = BlockingQueueEjemplo()
    hilo_productor = threading.Thread(target=ejemplo.productor)
    hilo_consumidor = threading.Thread(target=ejemplo.consumidor)
    
    hilo_productor.start()
    hilo_consumidor.start()
    
    hilo_productor.join()
    hilo_consumidor.join()
