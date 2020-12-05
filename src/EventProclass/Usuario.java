/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;



import java.util.Scanner;

/**
 *
 * @author 
 */
public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String nomUsuario;
    protected String contraseña;
    protected char tipo;
    protected Scanner sc;

    public Usuario(String nombre, String apellido, String nomUsuario, String contraseña, char tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }
    public Usuario(String nombre, String apellido){
     this.nombre = nombre;

    }
   
    public void mostrarInformacion(){
        System.out.println("Bienvenid@ "+this.nombre+" "+this.apellido+"\n");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return  nombre + ";"+ apellido + ";" + nomUsuario + ";" + contraseña + ";" + tipo ;
    }
}
