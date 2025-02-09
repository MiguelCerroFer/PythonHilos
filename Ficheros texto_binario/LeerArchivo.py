try:
    with open("archivo.txt", "r") as fichero:
        for linea in fichero:
            print(linea.strip())  # strip() elimina saltos de línea adicionales
except FileNotFoundError:
    print("Error al leer el archivo: No se encontró el archivo.")
