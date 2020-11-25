/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import EventProclass.Archivo;
import EventProclass.Cliente;
import EventProclass.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author
 */
public class interfazEventpro {

    private ArrayList<String> usuarios;
    int opcion;
    String opcion2;

    public void iniciarSeccion() {

        Usuario usuario = new Usuario();
        Cliente cliente=new Cliente();

        usuarios = Archivo.LeeFichero("usuarios.txt");

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n\n \t\tBIENVENIDO AL SISTEMA \n\n"
                + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        usuario.setNomUsuario(sc.nextLine());
        System.out.print("CONTRASEÑA: ");
        usuario.setContraseña(sc.nextLine());
        if (usuarios.stream().filter(n -> n.startsWith(usuario.getNomUsuario())).anyMatch(s -> s.endsWith(";C"))) {
            System.out.println("1. Solicitar planificación de evento\n2. Registrar pago Evento\n3. Salir");
            System.out.print("Escoja una opcion:");
            opcion = sc.nextInt();
            sc.nextLine();
            while (opcion != 3) {
                if(opcion ==1){
                    cliente.crearSolicitud();
                    System.out.println("Ha registrado todos los datos necesarios para la solicitud.\n2 ¿Desea registrar su solicitud?");
                    opcion2=sc.nextLine();
                    if(opcion2.equalsIgnoreCase("si")){
                    //llamar metodo de crear solicitud
                    }
                    else{
                        System.out.println("¡Gracias por visitarnos!");}
                }
                else{
                cliente.RegistrarPago();}
                            opcion=3;

            }
        }
            else{
System.out.println("1. Consultar solicitudes pendientes.\n 2. Registrar Evento.\n3. Confirmar Evento.\n4. Consultar Evento\n5. Salir");
                      }

        }
    }

