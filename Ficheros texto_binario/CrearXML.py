import xml.etree.ElementTree as ET

class Producto:
    def __init__(self, nombre, precio):
        self.nombre = nombre
        self.precio = precio

# Crear la lista de productos
lista_productos = [
    Producto("Cereales", "3.45"),
    Producto("Colacao", "1.45"),
    Producto("Aceite", "80")
]

# Crear el nodo raíz
raiz = ET.Element("productos")

# Recorrer la lista de productos y agregarlos al XML
for producto in lista_productos:
    nodo_producto = ET.SubElement(raiz, "producto")
    ET.SubElement(nodo_producto, "nombre").text = producto.nombre
    ET.SubElement(nodo_producto, "precio").text = producto.precio

# Crear el árbol y guardar el XML
arbol = ET.ElementTree(raiz)
nombre_archivo = "productos2.xml"

try:
    arbol.write(nombre_archivo, encoding="utf-8", xml_declaration=True)
    print(f"El fichero {nombre_archivo} se ha creado correctamente")
except Exception as e:
    print(f"Error al crear el archivo XML: {e}")
