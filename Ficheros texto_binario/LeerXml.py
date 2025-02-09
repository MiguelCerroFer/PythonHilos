import xml.etree.ElementTree as ET

try:
    # Cargar el archivo XML
    arbol = ET.parse("productos.xml")
    raiz = arbol.getroot()
    print("Raíz", raiz.tag)
    
    # Obtener la lista de productos
    for producto in raiz.findall("producto"):
        nombre = producto.find("nombre").text
        precio = producto.find("precio").text
        
        print(f"Producto: {nombre}")
        print(f"Precio: {precio}")
except FileNotFoundError:
    print("Error: No se encontró el archivo productos.xml")
except ET.ParseError:
    print("Error: El archivo XML tiene un formato incorrecto")
