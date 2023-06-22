/*
 Archivo: VentanaP.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */

package vistas;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.AlignmentAction;


public class VentanaP extends JFrame  {

    private JPanel jpdatos, jpalergias;
    private JLabel id, nombre, apellido, telefono, direccion;
    private JTextField fildPacienteID, fildPacienteNombre, fildPacienteApellido, fildPacienteTelefono, fildPacienteDireccion;

    private JPanel alergias;
    private JButton addAlergias;
    private JComboBox<String> dropAlergias = new JComboBox<>();
    private JTable tablaAlergias = new JTable();

    private JButton agregar, actualizar, cancelar;

    private Decolib im1;


    public VentanaP(){
        inciarComponentes();
        im1 = new Decolib("/img/fonodo.png");
        im1.setBounds(0,0,1000,695);
        add(im1);
    }

    private void inciarComponentes() {

        setTitle("Clinica Universidad del valle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 695);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setAlwaysOnTop(true);

        Color fondopaneles = new Color(225, 236, 200);
        Color verderFondo = new Color(160, 196, 157);
        Font nuevaTipografia1 = new Font("Courier New", Font.BOLD, 20);
        Color colorletrasfont = new Color(74,39,23);


        jpdatos = new JPanel();
        jpdatos.setBounds(21,126,937,234);
        jpdatos.setBackground(fondopaneles);
        jpdatos.setLayout(null);
        add(jpdatos);

        id = new JLabel("Identificacion");
        id.setBounds(40,26,185,46);
        id.setFont(nuevaTipografia1);
        id.setForeground(colorletrasfont);

        nombre = new JLabel("Nombres:");
        nombre.setBounds(40,87,185,46);
        nombre.setFont(nuevaTipografia1);
        nombre.setForeground(colorletrasfont);

        apellido = new JLabel("Apellidos:");
        apellido.setBounds(40,149,185,46);
        apellido.setFont(nuevaTipografia1);
        apellido.setForeground(colorletrasfont);

        telefono = new JLabel("Telefono:");
        telefono.setBounds(500,87,185,46);
        telefono.setFont(nuevaTipografia1);
        telefono.setForeground(colorletrasfont);

        direccion = new JLabel("Direccion:");
        direccion.setBounds(500,149,185,46);
        direccion.setFont(nuevaTipografia1);
        direccion.setForeground(colorletrasfont);

        fildPacienteID = new JTextField();
        fildPacienteID.setBounds(241,26,236,46);
        fildPacienteID.setFont(nuevaTipografia1);
        fildPacienteID.setForeground(colorletrasfont);
        fildPacienteID.setBackground(fondopaneles);

        fildPacienteNombre = new JTextField();
        fildPacienteNombre.setBounds(241,87,236,46);
        fildPacienteNombre.setFont(nuevaTipografia1);
        fildPacienteNombre.setForeground(colorletrasfont);
        fildPacienteNombre.setBackground(fondopaneles);

        fildPacienteApellido = new JTextField();
        fildPacienteApellido.setBounds(241,149,236,46);
        fildPacienteApellido.setFont(nuevaTipografia1);
        fildPacienteApellido.setForeground(colorletrasfont);
        fildPacienteApellido.setBackground(fondopaneles);
        
        fildPacienteTelefono = new JTextField();
        fildPacienteTelefono.setBounds(694,87,236,46);
        fildPacienteTelefono.setFont(nuevaTipografia1);
        fildPacienteTelefono.setForeground(colorletrasfont);
        fildPacienteTelefono.setBackground(fondopaneles);

        fildPacienteDireccion = new JTextField();
        fildPacienteDireccion.setBounds(694,149,236,46);
        fildPacienteDireccion.setFont(nuevaTipografia1);
        fildPacienteDireccion.setForeground(colorletrasfont);
        fildPacienteDireccion.setBackground(fondopaneles);

        jpdatos.add(id);    
        jpdatos.add(nombre);
        jpdatos.add(apellido);
        jpdatos.add(telefono);
        jpdatos.add(direccion);
        jpdatos.add(fildPacienteID);
        jpdatos.add(fildPacienteNombre);
        jpdatos.add(fildPacienteApellido);
        jpdatos.add(fildPacienteTelefono);
        jpdatos.add(fildPacienteDireccion);
        
        
        jpalergias = new JPanel();
        jpalergias.setBounds(23,387,510,259);
        jpalergias.setBackground(fondopaneles);
        jpalergias.setLayout(null);
        add(jpalergias);

        addAlergias = new JButton("Agregar");
        addAlergias.setBounds(17,20,147,35);
        addAlergias.setFont(nuevaTipografia1);
        addAlergias.setForeground(colorletrasfont);
        addAlergias.setOpaque(true);
        addAlergias.setBackground(fondopaneles);

        dropAlergias.setBounds(182,20,309,35);
        dropAlergias.setFont(nuevaTipografia1);
        dropAlergias.setForeground(colorletrasfont);
        dropAlergias.setOpaque(true);
        dropAlergias.setEditable(true);
        dropAlergias.setBackground(fondopaneles);

        alergias = new JPanel();
        alergias.setBounds(7,68,493,181);
        alergias.setBackground(verderFondo);

        jpalergias.add(addAlergias);
        jpalergias.add(dropAlergias);
        jpalergias.add(alergias);

        agregar = new JButton("Agregar");
        agregar.setBounds(632,406,256,56);
        agregar.setFont(nuevaTipografia1);
        agregar.setForeground(colorletrasfont);
        agregar.setOpaque(true);
        agregar.setBackground(fondopaneles);

        actualizar = new JButton("Actualizar");
        actualizar.setBounds(632,491,256,56);
        actualizar.setFont(nuevaTipografia1);
        actualizar.setForeground(colorletrasfont);
        actualizar.setOpaque(true);
        actualizar.setBackground(fondopaneles);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(632,571,256,56);
        cancelar.setFont(nuevaTipografia1);
        cancelar.setForeground(colorletrasfont);
        cancelar.setOpaque(true);
        cancelar.setBackground(fondopaneles);

        add(agregar);
        add(actualizar);
        add(cancelar);

    }

    public void addListener(ActionListener listenControles){
        addAlergias.addActionListener(listenControles);
        agregar.addActionListener(listenControles);
        actualizar.addActionListener(listenControles);
        cancelar.addActionListener(listenControles);
    }

    public void addFocusListener(FocusListener listener){
        fildPacienteNombre.addFocusListener(listener);
        fildPacienteApellido.addFocusListener(listener);
        fildPacienteTelefono.addFocusListener(listener);
        fildPacienteDireccion.addFocusListener(listener);
        
    }

    /* ------------------- Getters and Stters --------------------------------- */

    public JTextField getFildPacienteID() {
        return fildPacienteID;
    }
    public JTextField getFildPacienteNombre() {
        return fildPacienteNombre;
    }
    public JTextField getFildPacienteApellido() {
        return fildPacienteApellido;
    }
    public JTextField getFildPacienteTelefono() {
        return fildPacienteTelefono;
    }
    public JTextField getFildPacienteDireccion() {
        return fildPacienteDireccion;
    }

    public JComboBox<String> getDropAlergias() {
        return dropAlergias;
    }

    public JTable getTablaAlergias() {
        return tablaAlergias;
    }

    public void setTablaAlergias(JTable tablaAlergias) {
        this.tablaAlergias = tablaAlergias;
    }

}
