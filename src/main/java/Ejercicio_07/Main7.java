/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_07;

import Ejercicio_01.Persona;
import Ejercicio_02.Persona2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Main7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Escribir todos los datos leídos (los de 1 y 2) en un fichero con el formato 2 llamado 
        personas2_todo.txt, en caso de que el fichero ya exista debe dar error*/
        EscribirTodoTxt();
    }

    public static void EscribirTodoTxt() {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        ArrayList<Persona> listaPersona1 = LeerTxtPersona1();
        ArrayList<Persona2> listaPersona2 = LeerTxtPersona2();
        File archivo = new File("personas2_todo.txt");
        if (archivo.exists()) {
            System.out.println("Error ya existe el txt");
        }
        try {

            fichero = new FileWriter("personas2_todo.txt");
            escribir = new PrintWriter(fichero);
            for (int i = 0; i < listaPersona1.size(); i++) {
                escribir.write(listaPersona1.get(i).toStringTxt());
                escribir.write("\n");

            }
            for (int i = 0; i < listaPersona2.size(); i++) {
                escribir.write(listaPersona2.get(i).toStringTxt());
                escribir.write("\n");
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

    public static ArrayList LeerTxtPersona1() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Persona> listaPersona1 = new ArrayList<Persona>();
        try {
            archivo = new File("Persona.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                Persona miPersona = new Persona(linea);
                listaPersona1.add(GenerarPersonas(miPersona.getId(), miPersona.getNombre(), miPersona.getApellido1(), miPersona.getApellido2(), miPersona.getTelefono()));

            }
            return listaPersona1;
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
        return null;
    }

    public static ArrayList LeerTxtPersona2() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Persona2> listaPersona2 = new ArrayList<Persona2>();
        try {
            archivo = new File("Persona2.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                Persona2 miPersona = new Persona2(linea);
                listaPersona2.add(miPersona);

            }
            return listaPersona2;
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
        return null;
    }

    public static Persona GenerarPersonas(int i, String nombre, String apellido1, String apellido2, int telefono) {

        Persona miPersona = null;

        nombre = nombre.replace(" ", "");
        apellido1 = apellido1.replace(" ", "");
        apellido2 = apellido2.replace(" ", "");

        miPersona = new Persona(1000 + i, nombre, apellido1, apellido2, telefono);

        return miPersona;
    }
}
