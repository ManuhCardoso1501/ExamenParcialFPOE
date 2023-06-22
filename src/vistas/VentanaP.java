

package vistas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VentanaP extends JFrame  {
    private JPanel jpdatos, jpalergias;
    private JLabel id, nombre, apellido, telefono, direccion;
    private JTextField fildPacienteID, fildPacienteNombre, fildPacienteApellido, fildPacienteTelefono, fildPacienteDireccion;

    private JPanel alergias;
    private JButton addAlergias;
    private JComboBox dropAlergias;
    private JTable tablaAlergias;

    private JButton agregar, actualizar, cancelar;

    private Decolib im1;


    public VentanaP(){

    }






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

}
