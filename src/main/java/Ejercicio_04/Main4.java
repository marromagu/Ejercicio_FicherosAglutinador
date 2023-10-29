/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_04;

import Ejercicio_01.Persona;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mario
 */
public class Main4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Crear un programa que añada filas al fichero personas1.txt (al final del fichero) 
        pidiendo datos al usuario por pantalla (hay que tener en cuenta el tamaño máximo)*/
        PedirDatos(ContarLineas());
    }

    public static void EscribirTxt(Persona p) {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        try {
            fichero = new FileWriter("Persona.txt", true);
            escribir = new PrintWriter(fichero);

            //Aqui
            escribir.print("");
            escribir.println(p.toString());
            
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

    public static Persona GenerarPersonas(int i, String nombre, String apellido1, String apellido2, int telefono) {

        Persona miPersona = null;

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
        
        miPersona = new Persona(1000 + i, nombre, apellido1, apellido2, telefono);
        
        EscribirTxt(miPersona);
        return miPersona;
    }

    public static void PedirDatos(int i) {
        Scanner leer = new Scanner(System.in);
        int telefono;
        System.out.println("Escribe el nombe de la persona");
        String nombre = leer.nextLine();
        System.out.println("Escribe su primer apellido");
        String apellido1 = leer.nextLine();
        System.out.println("Escribe el segundo apellido");
        String apellido2 = leer.nextLine();
        do {
            System.out.println("Escribe su numero de telefono");
            telefono = leer.nextInt();
        } while (telefono < 100000000 || telefono > 999999999);
        GenerarPersonas(i, nombre, apellido1, apellido2, telefono);

    }

    public static int ContarLineas() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int i = 0;
        try {
            archivo = new File("Persona.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                i++;
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
        return i;

    }
}
