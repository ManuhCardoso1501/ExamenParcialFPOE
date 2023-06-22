/*
 Archivo: Array.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */

package daos;
import modelos.*;
import java.io.Serializable;
import java.math.*;
import java.util.*;
import java.text.*;

public class Array implements Serializable {
    public static final long serialVersionUID = 1L;
  
    public static String[][] getArrayRecursos(Clinica clinica, HashMap<String, String[]> listaAlergias ){
        if(listaAlergias.isEmpty())
            return null;
        
        int numeroFilas = listaAlergias.size();
        int numeroColumnas = 1;
        String[][] arreglo = new String[numeroFilas][numeroColumnas];
        int contadorFila = 0;
        for(Map.Entry<String, String[]> pareja : listaAlergias.entrySet()){
            String alergias = pareja.getKey();
            arreglo[contadorFila][0] = pareja.getValue()[0];

            contadorFila++;
        }
        return arreglo; 
    } 
}
