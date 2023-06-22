/*
 Archivo: Array.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */


package controladores;

import daos.*;
import modelos.*;
import vistas.*;
import java.awt.event.*;
import java.math.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;  

public class ControladorPrincipal {
    private VentanaP ventanaP;
    private JTable tablaAlergias = new JTable();
    private JPanel panelTablaAlergias = new JPanel();
    String rutaArchivoBin = "./src/Archivos/Clinica.bin";
    private Clinica clinica;
    private HashMap<String, String[]> listaAlergias = new HashMap<>();

    public ControladorPrincipal(VentanaP ventanaP){
        this.ventanaP = ventanaP;
        this.clinica = Managerecords.leerArchivoBin(rutaArchivoBin);
        if(clinica == null)
        clinica = new Clinica("Clinica Universidad del valle");

        ventanaP.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                Managerecords.guardarArchivoBin(clinica, rutaArchivoBin);
                System.exit(0);
            }
        });

        ventanaP.setVisible(true);
        this.ventanaP.addListener(new AddListerner());
        this.ventanaP.addFocusListener(new setFocus());
    }

    class setFocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'focusGained'");
        }

        @Override
        public void focusLost(FocusEvent e) {
            String stringid = ventanaP.getFildPacienteID().getText();
            Integer iD;
            try{
                iD = Integer.valueOf(stringid);
            } catch (NumberFormatException exception){
                return;
            }

            if(clinica.getUsuario().elementoPresente(iD)){
                Usuario usuario = clinica.getUsuario().getElemento(iD);
                ventanaP.getFildPacienteNombre().setText(usuario.getNombre());
                ventanaP.getFildPacienteNombre().setText(usuario.getApellido());
                ventanaP.getFildPacienteNombre().setText(usuario.getDireccion());
                ventanaP.getFildPacienteNombre().setText(usuario.getTelefono().toString());
            } else {
                ventanaP.getFildPacienteNombre().setText("");
                ventanaP.getFildPacienteNombre().setText("");
                ventanaP.getFildPacienteNombre().setText("");
                ventanaP.getFildPacienteNombre().setText("");
            }
        }

    }
    
    class AddListerner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equalsIgnoreCase("Agregar")){
                if(ControladorAuxiliar.revisarCampos(ventanaP)){
                    if(!listaAlergias.isEmpty()){
                        Usuario nuevUsuario = ControladorAuxiliar.creUsuario(ventanaP, listaAlergias);
                        Integer id = nuevUsuario.getIdentificacion();
                        if(clinica.getUsuario().añadir(nuevUsuario)){
                            listaAlergias = new HashMap<>();
                            clinica.getUsuario().getElemento(id);
                            JOptionPane.showMessageDialog(null, "El Paciente ha sido Agregado Correctamente " + "\n Itentificacion Paciente:" + id + "", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "El Paciente ya fue agregado al sistema, no lo puede volver a registrar" + "\n Codigo de Paciente:" + id + "", "Advertencia", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Debe agregar al menos una Alergia a la lista, en caso de que el paciente no tenga\n Seleccione la Opcion de  \"No presenta Alergias\".", "Advertencia", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

    }
}
