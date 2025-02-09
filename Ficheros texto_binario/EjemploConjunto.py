try:
    with open("fichero.txt", "w") as writer:
        writer.write("Texto a escribir\n")
        writer.write("Otra linea de texto\n")
except Exception as e:
    print(f"Error al escribir el archivo: {e}")

try:
    with open("fichero.txt", "r") as reader:
        for linea in reader:
            print(linea.strip())  
except Exception as e:
    print(f"Error al leer el archivo: {e}")
