import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class CrearXML {
    public static void main(String[] args) {
        // Crear la lista de productos
        List<producto> listaProductos = new ArrayList<>();
        listaProductos.add(new producto("Cereales", "3.45"));
        listaProductos.add(new producto("Colacao", "1.45"));
        listaProductos.add(new producto("Aceite", "80"));

        try {
            // Crear el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            //Nodo Raíz
            Element raiz = documento.createElement("productos");
            documento.appendChild(raiz);

            //Recorrer la lista de productos
            Element nodoProducto;
            Element nodoDatos; 
            Text texto;

            for( producto producto : listaProductos){
                //Crear nodo Producto
                nodoProducto = documento.createElement("producto");
                raiz.appendChild(nodoProducto);

                //Crear Subnodo <nombre>
                nodoDatos = documento.createElement("nombre");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(producto.getNombre());
                nodoDatos.appendChild(texto);

                //Crear subnodo <precio>
                nodoDatos = documento.createElement("precio");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(producto.getPrecio());
                nodoDatos.appendChild(texto);
            }


            //Guardar el documento XML en un fichero
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource src = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("productos2.xml"));
            transformer.transform(src, result);

            System.out.println("El fichero se ha creado correctamente");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}