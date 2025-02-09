class Producto:
    def __init__(self, nombre: str, precio: str):
        self._nombre = nombre
        self._precio = precio

    def get_nombre(self):
        return self._nombre

    def set_nombre(self, nombre: str):
        self._nombre = nombre

    def get_precio(self):
        return self._precio

    def set_precio(self, precio: str):
        self._precio = precio
