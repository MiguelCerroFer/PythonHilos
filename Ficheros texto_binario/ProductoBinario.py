import pickle

class ProductoBinario:
    _version = 1  

    def __init__(self, nombre: str, precio: float):
        self._nombre = nombre
        self._precio = precio

    def get_nombre(self):
        return self._nombre

    def set_nombre(self, nombre: str):
        self._nombre = nombre

    def get_precio(self):
        return self._precio

    def set_precio(self, precio: float):
        self._precio = precio

    def __str__(self):
        return f"ProductoBinario {{nombre = {self._nombre}, Precio = {self._precio} }}"

    @staticmethod
    def check_version(obj):
        if hasattr(obj, '_version') and obj._version == ProductoBinario._version:
            return True
        else:
            raise ValueError("La versión del objeto serializado no coincide con la versión actual de la clase")
