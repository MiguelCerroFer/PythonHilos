import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class LeerXml {
    public static void main(String[] args) {
        try{
            //Cargar el fichero XML
        File archivo = new File("productos.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);

            //Noramalizar el documento
            doc.getDocumentElement().normalize();

            //Obetener el nodo raiz
            Element raiz  = doc.getDocumentElement();
            System.out.println("Raíz " + raiz.getNodeName());

            //Obtener la lista de productos

            NodeList productos = doc.getElementsByTagName("producto");

            for (int i = 0; i< productos.getLength(); i++){
                Node nodo = productos.item(i);
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element producto = (Element) nodo;

                    String nombre = producto.getElementsByTagName("nombre")
                    .item(0).getTextContent();
                    String precio = producto.getElementsByTagName("precio")
                    .item(0).getTextContent();

                    System.out.println("Producto: "+ nombre);
                    System.out.println("Precio: " + precio);
                }
            }
    }catch(Exception e){

    }
    }
}
