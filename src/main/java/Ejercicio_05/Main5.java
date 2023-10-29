/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_05;

import Ejercicio_02.Persona2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mario
 */
public class Main5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Crear un programa que añada filas al fichero personas2.txt (al final del fichero) pidiendo datos al usuario por pantalla*/
        PedirDatos();
    }

    public static void PedirDatos() {
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

        GenerarPersonas(ContarLineas(), nombre, apellido1, apellido2, telefono);

    }

    public static Persona2 GenerarPersonas(int i, String nombre, String apellido1, String apellido2, int telefono) {
        Persona2 miPersona = null;
        miPersona = new Persona2(1000 + i, nombre, apellido1, apellido2, telefono);
        EscribirTxt(miPersona);
        return miPersona;
    }

    public static void EscribirTxt(Persona2 p) {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        try {
            fichero = new FileWriter("Persona2.txt", true);
            escribir = new PrintWriter(fichero);

            //Aqui
            escribir.print("");
            escribir.println(p.toStringTxt());

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

    public static int ContarLineas() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int i = 0;
        try {
            archivo = new File("Persona2.txt");
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
