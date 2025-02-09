class OtraClase:
    def __init__(self):
        self._mensaje = "Mensaje desde la clase base"

    def get_mensaje(self):
        return self._mensaje

    def set_mensaje(self, mensaje: str):
        self._mensaje = mensaje

    def imprimir_mensaje(self):
        print(self._mensaje)
