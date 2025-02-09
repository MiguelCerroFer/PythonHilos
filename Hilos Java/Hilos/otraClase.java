public class otraClase {
    private String mensaje;

    public otraClase(){
        this.mensaje = "Mensaje desde la clase base";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
     public void imprimirMensaje(){
        System.out.println(mensaje);
     }
}
