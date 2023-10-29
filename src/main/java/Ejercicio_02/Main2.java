/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author mario
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Debe leer el fichero personas2.txt de tamaño variable, el cual tiene los mismos campos 
        que los anteriores pero el separador de campos es “@”*/
        EscribirTxt();
        LeerTxt();
    }
     public static void LeerTxt() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Persona2.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                Persona2 miPersona = new Persona2(linea);
                System.out.println(miPersona.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void EscribirTxt() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Persona2.txt");
            pw = new PrintWriter(fichero);

            //Aqui
            for (int i = 0; i < 10; i++) {
                pw.print(GenerarPersonas(i).toStringTxt()+ "\n");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static Persona2 GenerarPersonas(int i) {
        String[] vectorNombres = {"María", "Juan", "Laura", "Carlos", "Ana"};
        String[] vectorApellidos = {"Pérez", "García", "Rodríguez", "López", "González", "Martínez", "Sánchez", "Fernández", "Torres", "Ramirez"};
        Persona2 miPersona = null;

        String nombre = vectorNombres[(int) (Math.floor(Math.random() * ((vectorNombres.length - 1) + 1)))];
        String apellido1 = vectorApellidos[(int) (Math.floor(Math.random() * ((vectorApellidos.length - 1) + 1)))];;
        String apellido2 = vectorApellidos[(int) (Math.floor(Math.random() * ((vectorApellidos.length - 1) + 1)))];;;
        int telefono = (int) (Math.random() * 888888888 + 111111111);
        miPersona = new Persona2(1000 + i, nombre, apellido1, apellido2, telefono);
        return miPersona;
    }

}
