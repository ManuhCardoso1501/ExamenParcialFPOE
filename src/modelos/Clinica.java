/*
 Archivo: Clinica.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */

package modelos;
import daos.*;
import java.io.Serializable;

public class Clinica implements Serializable{
    public static final long serialVersionUID = 1L;
    public String nombreClinica;
    private UsuarioDAOexte usuario;

    public Clinica(String nombreClinica){
        this.nombreClinica = nombreClinica;
        this.usuario = new UsuariosDAO();
    }


    /*  ---------------- Getters ^ Setters ---------------- */
    
    public String getNombreClinica() {
        return nombreClinica;
    }


    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public UsuarioDAOexte getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDAOexte usuario) {
        this.usuario = usuario;
    }
}
