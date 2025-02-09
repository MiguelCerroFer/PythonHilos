try:
    with open("archivo.txt", "w") as escritor:
        escritor.write("Esto es una linea del fichero\n")  # Equivalente a println en Java
        escritor.write("Esto es una linea del fichero")  # Equivalente a write en Java
    print("El archivo ha sido creado y escrito")
except IOError as e:
    print(f"Error al escribir el archivo: {e}")
