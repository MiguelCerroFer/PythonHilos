import configparser

config = configparser.ConfigParser()

mi_usuario = "Admin"
mi_contrasena = "12345"
el_servidor = "localhost"
el_puerto = "8080"

config["DEFAULT"] = {
    "user": mi_usuario,
    "password": mi_contrasena,
    "server": el_servidor,
    "port": el_puerto
}

archivo_config = "configuracion.conf"

try:
    with open(archivo_config, "w") as configfile:
        config.write(configfile)
        configfile.write("# Fichero de configuración\n")
    print(f"Archivo de configuración guardado en: {archivo_config}")
except Exception as e:
    print(f"Error al guardar la configuración: {e}")
