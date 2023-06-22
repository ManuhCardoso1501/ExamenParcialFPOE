/*
 Archivo: Magagerecords.java
 Parcial Fundamentos de programacion Orientado a Eventos
 22 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
 */


package modelos;

import java.io.*;
import java.time.*;

public class Managerecords {
    public Managerecords() { 
    }

    public static Clinica leerArchivoBin (String rutaArchivo){
        ObjectInputStream objInputStream = null;
        Clinica clinica = null;

        try{
            objInputStream = new ObjectInputStream(new FileInputStream(rutaArchivo));
            clinica = (Clinica) objInputStream.readObject();
            System.out.println("¡Archivo binario leído!");

        } catch(FileNotFoundException exception) {
            System.out.println("El archivo binario aun no ha sido creado. No se preocupe, el archivo se generará automaticamente al cerrar la aplicación");

        } catch(IOException exception){
            System.out.println("Error leyendo el archivo binario.");
            System.out.println("Error leyendo el archivo binario. " + exception.getMessage());

        } catch(ClassNotFoundException exception) {
            System.out.println("Conflicto entre clases.");
            System.out.println("Conflicto entre clases." + exception.getMessage());

        } finally {
            if(objInputStream != null)
                try {
                    objInputStream.close();
                } catch (IOException exception) {
                    System.out.println("Error cerrando el archivo objInputStream.");
                    System.out.println("Error cerrando el archivo objInputStream" + exception.getMessage());
                }
        }
        return clinica;
    }

    public static boolean guardarArchivoBin (Clinica clinica, String rutaArchivo){
        boolean operacionRealizada = false;
        ObjectOutputStream objOutputStream = null;

        try{
            objOutputStream = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
            objOutputStream.writeObject(clinica);
            System.out.println("¡Archivo binario guardado!");
            operacionRealizada = true;

        } catch(FileNotFoundException exception){ 
            System.out.println("Hay un problema con la ruta donde se guardará el archivo binario. Por favor verificar la ruta.");
            // System.out.println("Hay un problema con la ruta donde se guardará el archivo binario. Por favor verificar la ruta." + exception.getMessage());

        } catch(IOException exception){
            System.out.println("Error guardando el archivo binario.");
            // System.out.println("Error guardando el archivo binario. " + exception.getMessage() + exception.getStackTrace());

        } finally {
            if(objOutputStream != null){
                try {
                    objOutputStream.close();
                } catch (IOException exception) {
                    System.out.println("Error cerrando el archivo objOutputStream.");
                    // System.out.println("Error cerrando el archivo objOutputStream" + exception.getMessage());
                }
            }
        }
        return operacionRealizada;

    }
}
