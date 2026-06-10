package Estructuras;

import java.util.ArrayList;
import java.util.List;

public class Configure 
{

    public List<Procedimiento> procedimientos = new ArrayList<>(); //lo pongo publico porque la logica de set aqui no tengo porque hacerla de momento

    @Override
    public String toString()
    {
        String resultado = "Configure: \n";
        
        for (Procedimiento procedimiento : procedimientos) 
        {
            resultado += procedimiento.toString() + "\n";
        }
        return resultado;
    }

}
