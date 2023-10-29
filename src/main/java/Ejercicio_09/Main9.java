/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_09;

import Ejercicio_08.PersonaUnificado;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author mario
 */
public class Main9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        /*9) Serializa las personas de “PersonaUnificado” usando la interfaz “seralizable” y 
        guardarlo en el fichero “PUserializado”. A continuación, cárgalo en el programa (en una 
        variable diferente) y comprueba que sea correcto. Si el fichero PUserializado existe al 
        inicio, elimínalo.*/
        guardarFichero();
        cargarFichero();
        
    }

    public static void cargarFichero() throws ClassNotFoundException {
        FileInputStream fichero = null;
        ObjectInputStream entrada = null;
        try {
            fichero = new FileInputStream("PUserializado.dat");
            entrada = new ObjectInputStream(fichero);
            PersonaUnificado mipersona = (PersonaUnificado) entrada.readObject();
            System.out.println(mipersona.getNombre());
        } catch (IOException e) {
            System.out.println("Error guardando fichero");
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static void guardarFichero() {
        FileOutputStream fichero = null;
        ObjectOutputStream salida = null;
        try {
            fichero = new FileOutputStream("PUserializado.dat");
            salida = new ObjectOutputStream(fichero);
            salida.writeObject(Ejercicio_08.PersonaUnificado.class);
        } catch (IOException e) {
            System.out.println("Error guardando fichero");
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
            }
        }
    }

}
