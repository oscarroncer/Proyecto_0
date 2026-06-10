//IMPORTS
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.*;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import Estructuras.*;


public class Program{

public static void main(String[] args) 
{
    boolean leidoConExito = leerConfigure(); //Si no se ha cargado correctamente o no existe el fichero de configuración salimos del programa
    System.out.println("Leido con exito: "+leidoConExito);
}


//comprobamos que existye y llamamos al cargarConfigure()
public static  boolean  leerConfigure()
{
    File file = new File("C:\\Users\\Oscar\\OneDrive\\Escritorio\\PROYECTOS\\Proyecto_0\\configure.xml");

    if (file.exists()) 
    { 

        return cargarConfigure("C:\\Users\\Oscar\\OneDrive\\Escritorio\\PROYECTOS\\Proyecto_0\\configure.xml"); //devuelve el resultado de cargar con exito o no
  
    }

    return false;
}

public static boolean cargarConfigure(String file)
{

    File configurePath = new File(file);
    Configure configuracion = new Configure(); //aqui cargaremos la configuracion final

    //inicializamos el reader
    try 
    {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(configurePath));
        
        //variables current
        String currentElement = "";
        Procedimiento procedimientoCurrent = new Procedimiento();
        
        
        while(reader.hasNext())
        {
            int evento = reader.next();
            

            switch (evento) {

                case XMLStreamConstants.START_ELEMENT:
                
                    currentElement = reader.getLocalName();

                break;

                case XMLStreamConstants.CHARACTERS:

                    String texto = reader.getText().trim();

                    if (!texto.isEmpty()){

                        switch (currentElement) {
                            
                            case "RutaCaptura": procedimientoCurrent.RutaCaptura = new File (texto);
                                
                            break;

                            case "Filtro": procedimientoCurrent.Filtro = texto;
                                
                            break;

                            case "Borrado":     //contemplamos solo dos casos true/false
                                
                                if(texto.toLowerCase().equals("true"))      
                                {
                                    procedimientoCurrent.Borrado = true;
                                }
                                else if (texto.toLowerCase().equals("false"))
                                {
                                    procedimientoCurrent.Borrado = false;
                                }
                                
                            break;

                            case "Ruta":

                                procedimientoCurrent.RutaCopia.add(new File(texto));
                            
                            break;
                        
                        }
                    }
                    
                break;

                case XMLStreamConstants.END_ELEMENT:
                    
                    if (currentElement.equals("Procedimiento")) 
                    {
                        configuracion.procedimientos.add(procedimientoCurrent);
                        procedimientoCurrent = null;
                    }

                    currentElement = "";
                
                break;
            
            }
        }

    } catch (Exception e) 
    {
        System.out.println("Eror: " + e);
        
        return false;
    }

    return true;

}


public void buscarPorMascaraFichero (List<Path> dirs, String mascara)
{

}

}