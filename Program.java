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
    System.out.println("Leido con exito: "+ leidoConExito);
}


//comprobamos que existye y llamamos al cargarConfigure()
public static  boolean  leerConfigure()
{
    File file = new File(".\\configure.xml");

    if (file.exists()) 
    { 

        return cargarConfigure(file); //devuelve el resultado de cargar con exito o no
  
    }

    return false;
}

public static boolean cargarConfigure(File file)
{

    File configurePath = file;
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

                        switch (currentElement.toUpperCase()) {
                            
                            case "RUTACAPTURA": procedimientoCurrent.RutaCaptura = new File (texto);
                                
                            break;

                            case "FILTRO": procedimientoCurrent.Filtro = texto;
                                
                            break;

                            case "BORRADO":     //contemplamos solo dos casos true/false
                                
                                if(texto.toLowerCase().equals("true"))      
                                {
                                    procedimientoCurrent.Borrado = true;
                                }
                                else if (texto.toLowerCase().equals("false"))
                                {
                                    procedimientoCurrent.Borrado = false;
                                }
                                
                            break;

                            case "RUTA":

                                procedimientoCurrent.RutaCopia.add(new File(texto));
                            
                            break;
                        
                        }
                    }
                    
                break;

                case XMLStreamConstants.END_ELEMENT:
                    
                    if (currentElement.equals("Procedimiento")) 
                    {
                        Procedimiento p = procedimientoCurrent;
                        
                        configuracion.procedimientos.add(p);
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