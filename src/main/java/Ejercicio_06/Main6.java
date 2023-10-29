/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_06;

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
public class Main6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Escribir todos los datos leídos (los de 1 y 2) en un fichero con el formato 1 llamado 
        personas1_todo.txt, en caso de que el fichero ya exista debe dar error (hay que tener 
        en cuenta el tamaño máximo)*/
        EscribirTodoTxt();
    }

    public static void EscribirTodoTxt() {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        ArrayList<Persona> listaPersona1 = LeerTxtPersona1();
        ArrayList<Persona2> listaPersona2 = LeerTxtPersona2();
        File archivo = new File("personas1_todo.txt");
        if (archivo.exists()) {
            System.out.println("Error ya existe el txt");
        }
        try {

            fichero = new FileWriter("personas1_todo.txt");
            escribir = new PrintWriter(fichero);
            for (int i = 0; i < listaPersona1.size(); i++) {
                escribir.write(listaPersona1.get(i).toString());
                escribir.write("\n");

            }
            for (int i = 0; i < listaPersona2.size(); i++) {
                escribir.write(listaPersona2.get(i).toStringTxtTodos());
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
                listaPersona1.add(miPersona);

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
                listaPersona2.add(GenerarPersonas(miPersona.getId(), miPersona.getNombre(), miPersona.getApellido1(), miPersona.getApellido2(), miPersona.getTelefono()));

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

    public static Persona2 GenerarPersonas(int i, String nombre, String apellido1, String apellido2, int telefono) {

        Persona2 miPersona2 = null;

        if (nombre.length() < 10) {
            for (int j = (10 - nombre.length()); j > 0; j--) {
                nombre = nombre + " ";
            }
        }
        if (apellido1.length() < 15) {
            for (int j = (15 - apellido1.length()); j > 0; j--) {
                apellido1 = apellido1 + " ";
            }
        }
        if (apellido2.length() < 15) {
            for (int j = (15 - apellido2.length()); j > 0; j--) {
                apellido2 = apellido2 + " ";
            }
        }
        if (nombre.length() > 10) {
            nombre = nombre.substring(0, 10);
        }
        if (apellido1.length() > 15) {
            apellido1 = apellido1.substring(0, 15);
        }
        if (apellido2.length() > 15) {
            apellido2 = apellido1.substring(0, 15);
        }

        miPersona2 = new Persona2(1000 + i, nombre, apellido1, apellido2, telefono);

        return miPersona2;
    }
}
