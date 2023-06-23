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
    private JScrollPane panelTablaAlergias = new JScrollPane();
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
        pintarAlergias();
    }

    class setFocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
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
                ventanaP.getFildPacienteApellido().setText(usuario.getApellido());
                ventanaP.getFildPacienteDireccion().setText(usuario.getDireccion());
                ventanaP.getFildPacienteTelefono().setText(usuario.getTelefono().toString());
                
            } 
        }

    }
    
    class AddListerner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equalsIgnoreCase("Agregar")){
                if(ControladorAuxiliar.revisarCampos(ventanaP)){
                    if(listaAlergias.isEmpty()){
                        Usuario nuevUsuario = ControladorAuxiliar.creUsuario(ventanaP, listaAlergias);
                        Integer id = nuevUsuario.getIdentificacion();
                        if(clinica.getUsuario().añadir(nuevUsuario)){
                            listaAlergias = new HashMap<>();
                            clinica.getUsuario().getElemento(id);
                            JOptionPane.showMessageDialog(null, "El Paciente ha sido Agregado Correctamente, Recuerde agregar las alergias y Agregar nuevamente " + "\n Itentificacion Paciente:" + id + "", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "El Paciente ya fue agregado al sistema, no lo puede volver a registrar" + "\n Codigo de Paciente:" + id + "", "Advertencia", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Las Alergias del paciente han sido agregadas con existo", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else if (evento.getActionCommand().equalsIgnoreCase("Cancelar")){
                ControladorAuxiliar.limpiar(ventanaP);
                listaAlergias = new HashMap<>();
                limpiartablas();
     
            } else if (evento.getActionCommand().equalsIgnoreCase("Actualizar")){
                if(ControladorAuxiliar.revisarCampos(ventanaP)){
                    Usuario nuevUsuario = ControladorAuxiliar.creUsuario(ventanaP, listaAlergias);
                    Integer idUsuario = nuevUsuario.getIdentificacion();
                    if(clinica.getUsuario().elementoPresente(idUsuario) && clinica.getUsuario().actualizar(idUsuario, nuevUsuario)){
                        JOptionPane.showMessageDialog(null ,"!El Paciente (" + idUsuario + ") Fue actualizado con exito", "Paciente Actualizado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null ,"!El Paciente (" + idUsuario + ") No existe en el sistema, debe gegistrarlo", "Paciente Actualizado", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (evento.getActionCommand().equalsIgnoreCase("Añadir")){
                if(ControladorAuxiliar.revisarBox(ventanaP)){
                    Integer idPaciente = Integer.valueOf(ventanaP.getFildPacienteID().getText());
                    String alergia = ventanaP.getDropAlergias().getSelectedItem().toString();
                    String[] arreglo = {alergia};
                    if(clinica.getUsuario().elementoPresente(idPaciente)){
                        listaAlergias.put(alergia,arreglo);
                        JOptionPane.showMessageDialog(null, "La alergia  (" + alergia + ")"+ "" +"\n Ha sido agregada satisfactoriamente a la lista ", "Alergia agregada correctamente", JOptionPane.INFORMATION_MESSAGE);
                        pintarAlergias();
                        System.out.println(listaAlergias.size());

                    } else {
                        JOptionPane.showMessageDialog(null, "La alergia no se pudo agregar", "Advertecia", JOptionPane.ERROR_MESSAGE);
                    }
                } 
            } 
        }

    }

    public void pintarAlergias(){
        tablaAlergias = ventanaP.getTablaAlergias();
        panelTablaAlergias = ventanaP.getPaneltablaAlergias();

        ventanaP.getPanelAlergias().removeAll();
        tablaAlergias.removeAll();
        panelTablaAlergias.removeAll();

        String [][] alergiasListadas = Array.getArrayRecursos(clinica, listaAlergias);
        tablaAlergias = new JTable(ControladorPrincipal.asignarModelTabla(alergiasListadas, ControladorAuxiliar.getTitle()));
        tablaAlergias.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        ventanaP.setTablaAlergias(tablaAlergias);
        panelTablaAlergias = new JScrollPane(ventanaP.getTablaAlergias());
        ventanaP.setPaneltablaAlergias(panelTablaAlergias);
        
        
    }

    public void limpiartablas(){
        tablaAlergias = ventanaP.getTablaAlergias();
        panelTablaAlergias = ventanaP.getPaneltablaAlergias();

        ventanaP.getPanelAlergias().removeAll();
        tablaAlergias.removeAll();
        panelTablaAlergias.removeAll();
    }


    public static TableModel asignarModelTabla (String[][] datos, String[] encabezado){
        TableModel model = new DefaultTableModel(datos, encabezado){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        }; 
        
        return model;

    }


}
