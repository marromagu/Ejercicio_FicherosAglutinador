/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_01;

/**
 *
 * @author mario
 */
public class Persona {

    private int id;//Tamañao 4
    private String nombre;//Tamaño 10
    private String apellido1;//Tamaño 15
    private String apellido2;// Tamaño 15
    private int telefono;//Tamaño 8

    public Persona(int id, String nombre, String apellido1, String apellido2, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
    }

    public Persona(String Linea) {
        this.id = Integer.parseInt(Linea.substring(0, 4));
        this.nombre = Linea.substring(4, 14);
        this.apellido1 = Linea.substring(14, 29);
        this.apellido2 = Linea.substring(29, 44);
        this.telefono = Integer.parseInt(Linea.substring(44, 52));;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(nombre);
        sb.append(apellido1);
        sb.append(apellido2);
        sb.append(telefono);
        return sb.toString();
    }

    public String toStringTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append("@");
        sb.append(nombre);
        sb.append("@");
        sb.append(apellido1);
        sb.append("@");
        sb.append(apellido2);
        sb.append("@");
        sb.append(telefono);
        return sb.toString();
    }

}
