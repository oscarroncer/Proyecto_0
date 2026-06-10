package Estructuras;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Procedimiento
{
    //atributos de objeto procedimiento
    public File RutaCaptura = new File("");
    public String Filtro = new String();
    public boolean Borrado;    //en java un boolean no inicializado es false por defecto
    public List<File> RutaCopia = new ArrayList<>();

    @Override
    public String toString()
    {
        return "Procedimiento: "+"\nRuta Captura: "+RutaCaptura.toString()
        +"\nFiltro: "+Filtro
        +"\nBorrado: "+Borrado
        +"\nRutas de copia: "+RutaCopia.toString();
    }



}