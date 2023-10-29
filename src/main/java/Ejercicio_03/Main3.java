/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_03;

import Ejercicio_01.Persona;
import Ejercicio_02.Persona2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author mario
 */
public class Main3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Mostrar por pantalla los datos leídos tanto de persona1.txt como de persona2.txt, a la 
        unificación de datos lo llamaremos PersonaUnificado.*/
        System.out.println("\n\tpersona1.txt");
        LeerTxt1();
        System.out.println("\n\tpersona2.txt");
        LeerTxt2();
    }
    public static void LeerTxt2() {
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
    public static void LeerTxt1() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Persona.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                Persona miPersona = new Persona(linea);
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

}
