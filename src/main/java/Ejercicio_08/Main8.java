/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_08;

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
public class Main8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*8) Para cada una de las personas de PersonaUnificado se crearán 100 líneas que tenga el 
        siguiente formato:
        a. Se guardará un fichero en tipo texto “UnificadoValorTexto.txt”
        b. Se guardará un fichero en formato binario “UnificadoValorBinario.txt”
        c. Comprobar cuanto ocupa cada fichero y reflexionar sobre ello*/
        EscribirTodoTxt();
        EscribirTodoTxtBinario();
    }

    public static void EscribirTodoTxt() {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        ArrayList<PersonaUnificado> arrayListPersonaUnificado = LeerTxt();
        try {

            fichero = new FileWriter("UnificadoValorTexto.txt");
            escribir = new PrintWriter(fichero);
            for (int i = 0; i < arrayListPersonaUnificado.size(); i++) {
                for (int j = 0; j < 100; j++) {
                    int r = (int) (Math.random() * 123456789 + 999999999);
                    escribir.write(arrayListPersonaUnificado.get(i).getId() + "@" + r + "\n");
                }
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

    public static void EscribirTodoTxtBinario() {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        ArrayList<PersonaUnificado> arrayListPersonaUnificado = LeerTxt();
        try {

            fichero = new FileWriter("UnificadoValorBinario.txt");
            escribir = new PrintWriter(fichero);

            for (int i = 0; i < arrayListPersonaUnificado.size(); i++) {
                    String binario = Integer.toBinaryString(arrayListPersonaUnificado.get(i).getId());
                for (int j = 0; j < 100; j++) {
                    int r = (int) (Math.random() * 123456789 + 999999999);
                    String binarioR = Integer.toBinaryString(r);
                    escribir.write(binario + "@" + binarioR + "\n");
                }
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

    public static ArrayList LeerTxt() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<PersonaUnificado> arrayListPersonaUnificado = new ArrayList<PersonaUnificado>();
        try {
            archivo = new File("personas2_todo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                PersonaUnificado miPersona = new PersonaUnificado(linea);
                arrayListPersonaUnificado.add(miPersona);

            }
            return arrayListPersonaUnificado;

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
}
