/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import EventProclass.Usuario;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Sistema {

    //private List<usuarios>;
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n\n \t\tBIENVENIDO AL SISTEMA \n\n"
                + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        usuario.setNomUsuario(sc.nextLine());
        System.out.print("CONTRASEÑA: ");
        usuario.setContraseña(sc.nextLine());
        
    mostrarMenu();
    

        //VERIFICAR CUANDO YA ESTE EL ARCHIVO SI ES CLIENTE C O P
        //ALMACENAR EL TIPO EN ALGUN LADO y DEMAS DATOS DEL ARCHIVO
      
        
    }

    public void iniciarSeccion() {
    }

    public static void mostrarMenu() {
      //<CON ESA VERIFICACION MUESTRO MENU (VERIFICAR CUANDO YA ESTE EL ARCHIVO SI ES CLIENTE C O P
System.out.println("1. Solicitar planificación de evento\n2. Registrar pago Evento\n3. Salir");
System.out.println("1. Consultar solicitudes pendientes.\n 2. Registrar Evento.\n3. Confirmar Evento.\n4. Consultar Evento\n5. Salir");
    }
}
