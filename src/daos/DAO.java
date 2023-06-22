/*
 Archivo: DAO.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */

package daos;

public interface DAO <KON> {
    public abstract boolean añadir(KON kon);
    public abstract boolean elementoPresente(Integer identificador);
    public abstract KON getElemento(Integer identificador);
    public abstract boolean actualizar(Integer identificador, KON kon);
    
}
