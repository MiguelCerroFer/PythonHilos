import threading

def EjemploAnonima():
    for _ in range(10):
        print("Soy un hilo")

hilo = threading.Thread(target=tarea)
hilo.start()

print("Fin del hilo principal")
