import pickle

class Binario:
    def __init__(self, nombre, precio):
        self.nombre = nombre
        self.precio = precio
    
    def __str__(self):
        return f"Producto: {self.nombre}, Precio: {self.precio}"

producto = Binario("Laptop", 2000)
archivo = "producto.dat"

# Serialización
try:
    with open(archivo, "wb") as file:
        pickle.dump(producto, file)
    print(f"Objeto serializado y guardado en: {archivo}")
except Exception as e:
    print(f"Error en la serialización: {e}")

# Deserialización
try:
    with open(archivo, "rb") as file:
        producto_leido = pickle.load(file)
    print(f"Objeto deserializado: {producto_leido}")
except Exception as e:
    print(f"Error en la deserialización: {e}")
