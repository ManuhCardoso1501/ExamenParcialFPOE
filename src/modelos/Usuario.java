/*
 Archivo: Usuario.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */

package modelos;

import java.io.Serializable;
import java.util.*;
 import java.time.*;
 import java.math.*;

public class Usuario implements Serializable{
    public static final long serialVersionUID = 1L;
    public static final int datosTotales = 6;
    private Integer identificacion;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String direccion;
    private HashMap <Integer,String[]> listaAlergias;

    public Usuario(Integer identificacion, String nombre, String apellido, Integer telefono, String direccion, HashMap <Integer,String[]> listaAlergias ){
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public HashMap<Integer, String[]> getListaAlergias() {
        return listaAlergias;
    }

    public String getDato(int pkdato){
        switch(pkdato){
            case 0:
                return String.valueOf(identificacion);
            case 1:
                return String.valueOf(nombre);
            case 2:
                return String.valueOf(apellido);
            case 3:
                return String.valueOf(telefono);
            case 4:
                return String.valueOf(direccion);
            default:
                return"";
        }
    }

    
    
}
