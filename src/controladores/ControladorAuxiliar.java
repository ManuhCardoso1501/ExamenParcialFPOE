/*
 Archivo: Array.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */


package controladores;
import vistas.*;
import modelos.*;

import java.util.*;
import java.math.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.text.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ControladorAuxiliar {
    private static String Encabezado[] = {"|Tipo de Alergia|"};


    public static void limpiar(VentanaP ventanaP){
        ventanaP.getFildPacienteID().setText("");
        ventanaP.getFildPacienteNombre().setText("");
        ventanaP.getFildPacienteApellido().setText("");
        ventanaP.getFildPacienteTelefono().setText("");
        ventanaP.getFildPacienteDireccion().setText("");
    }

    public static String[] getTitle(){
        return Encabezado;
    }

    public static boolean revisarCampos(VentanaP ventanaP){
        String IdPaciente = ventanaP.getFildPacienteID().getText();
        try {
            Integer.valueOf(IdPaciente);
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un ID valido de Paciente, sin puntos ni comas" + "\n Ejemplo: 1004250131" , "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String nombrePaciente = ventanaP.getFildPacienteNombre().getText();
        if(nombrePaciente.isEmpty() || nombrePaciente.isBlank() || nombrePaciente == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese El/Los nombres del Paciente", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        } 

        String apellidoPaciente = ventanaP.getFildPacienteApellido().getText();
        if(apellidoPaciente.isEmpty() || apellidoPaciente.isBlank() || apellidoPaciente == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese El/Los Apellidos del Paciente", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        } 

        String telefonoPaciente = ventanaP.getFildPacienteTelefono().getText();
        try {
            Integer.valueOf(telefonoPaciente);
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un numero de telefono valido, sin puntos ni comas" + "\n Ejemplo: 3219873299" , "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String direccionPaciente = ventanaP.getFildPacienteDireccion().getText();
        if(direccionPaciente.isEmpty() || direccionPaciente.isBlank() || direccionPaciente == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese la direccion del Paciente", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean revisarBox(VentanaP ventanaP){
        String alergiaSeleccionada = ventanaP.getDropAlergias().getSelectedItem().toString();
        if(alergiaSeleccionada.equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Porfavor Seleccione una alergia de la lista", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static Usuario creUsuario(VentanaP ventanaP, HashMap<String, String[]> listaAlergias){
        String stringID = ventanaP.getFildPacienteID().getText();
        Integer iD = Integer.valueOf(stringID);
        String nombre = ventanaP.getFildPacienteNombre().getText();
        String apellido = ventanaP.getFildPacienteApellido().getText();
        String stringTelefono = ventanaP.getFildPacienteTelefono().getText();
        Integer telefono = Integer.valueOf(stringTelefono);
        String direccion = ventanaP.getFildPacienteDireccion().getText();

        Usuario usuario = new Usuario(iD, nombre, apellido, telefono, direccion, listaAlergias);
        return usuario;
    }

    public static void crearTabla(DefaultTableModel modelTlabe, VentanaP ventanaP){
        String tablaAlergia = modelTlabe.getValueAt(ventanaP.getTablaAlergias().getSelectedRow(),0).toString();

        ventanaP.getDropAlergias().setSelectedItem(tablaAlergia);
    }
}
