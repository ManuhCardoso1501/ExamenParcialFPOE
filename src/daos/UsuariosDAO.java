/*
 Archivo: UsuariosDAO.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */


package daos;

import java.io.Serializable;
import modelos.*;
import java.util.*;

public class UsuariosDAO implements UsuarioDAOexte,Serializable {
    public static final long serialVersionUID = 1L;
    private HashMap<Integer, Usuario> mapa;

    public UsuariosDAO(){
        this.mapa = new HashMap<>();
    }

    @Override
    public boolean añadir(Usuario kon) {
        if(mapa.containsKey(kon.getIdentificacion()))
            return false;

        mapa.put(kon.getIdentificacion(), kon);
        return true;
    }   

    @Override
    public boolean elementoPresente(Integer identificador) {
        if(mapa.containsKey(identificador))
            return true;
        return false;
    }

    @Override
    public Usuario getElemento(Integer identificador) {
        if(mapa.containsKey(identificador))
            return mapa.get(identificador);
        return null;
    }

    @Override
    public boolean actualizar(Integer identificador, Usuario kon) {
        if(identificador.equals(kon.getIdentificacion())){
            mapa.replace(identificador, kon);
            return true;
        }
        return false;
    }

    
    
}
