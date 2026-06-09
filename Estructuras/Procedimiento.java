package Estructuras;

import java.util.List;
import java.nio.file.Path;

public class Procedimiento
{
    //atributos de objeto procedimiento
    Path RutaCaptura;
    String Filtro = new String();
    boolean Borrado;    //en java un boolean no inicializado es false por defecto
    List<Path> RutaCopia;

    @Override
    public String toString()
    {
        return "Procedimiento: "+"\nRuta Captura: "+RutaCaptura.toString()
        +"\nFiltro: "+Filtro
        +"\nBorrado: "+Borrado
        +"\nRutas de copia: "+RutaCopia.toString();
    }

    //pruebas de git
}