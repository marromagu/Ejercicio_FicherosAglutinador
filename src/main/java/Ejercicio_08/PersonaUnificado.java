/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_08;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author mario
 */
public class PersonaUnificado implements Serializable{

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */

    private int id;//Tamañao 4
    private String nombre;//Tamaño 10
    private String apellido1;//Tamaño 15
    private String apellido2;// Tamaño 15
    private int telefono;//Tamaño 8

    public PersonaUnificado(int id, String nombre, String apellido1, String apellido2, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonaUnificado{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido1=").append(apellido1);
        sb.append(", apellido2=").append(apellido2);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }

  public PersonaUnificado(String Linea) {
        Scanner sc = new Scanner(Linea).useDelimiter("@");
        this.id = sc.nextInt();
        this.nombre = sc.next();
        this.apellido1 = sc.next();
        this.apellido2 = sc.next();
        this.telefono = sc.nextInt();;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
