/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import EventProclass.Archivo;
import EventProclass.Cliente;
import EventProclass.Planificador;
import EventProclass.Usuario;
import Events.Evento;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author
 */
public class interfazEventpro {

    private ArrayList<String> usuarios = Archivo.LeeFichero("usuarios.txt");
    int opcion;
    String opcion2;

    public void iniciarSeccion() {

        Usuario usuario = new Usuario();
        Cliente cliente = new Cliente();

        usuarios = Archivo.LeeFichero("usuarios.txt");

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n\n \t\tBIENVENIDO AL SISTEMA \n\n"
                + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        String usuarioComprobar = sc.nextLine();
        ArrayList<String> nomUsuarios = new ArrayList<>();
        ArrayList<String> contraseñas = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            String[] datos = usuarios.get(i).split(";");
            nomUsuarios.add(datos[0]);
            contraseñas.add(datos[3]);
        }
        while (!nomUsuarios.contains(usuarioComprobar)) {
            System.out.println("Ingrese un usuario  válido");
            usuarioComprobar = sc.nextLine();
        }
        usuario.setNomUsuario(usuarioComprobar);
        System.out.print("CONTRASEÑA: ");
        String contraseñaComprobar = sc.nextLine();
        while (contraseñas.get(nomUsuarios.indexOf(usuarioComprobar)).equals(contraseñaComprobar)) {
            System.out.print("Ingrese la contraseña correctamente: ");
            contraseñaComprobar = sc.nextLine();
        }
        usuario.setContraseña(contraseñaComprobar);

        if (usuarios.stream().filter(n -> n.startsWith(usuario.getNomUsuario())).anyMatch(s -> s.endsWith(";C"))) {
            System.out.println("1. Solicitar planificación de evento\n2. Registrar pago Evento\n3. Salir");
            System.out.print("Escoja una opcion:");
            opcion = sc.nextInt();
            sc.nextLine();
            while (opcion != 3) {
                if (opcion == 1) {
                    cliente.crearSolicitud();
                    System.out.println("Ha registrado todos los datos necesarios para la solicitud.\n\n ¿Desea registrar su solicitud?");
                    opcion2 = sc.nextLine();
                    if (opcion2.equalsIgnoreCase("si")) {
                        //llamar metodo de crear solicitud
                    } else {
                        System.out.println("¡Gracias por visitarnos!");
                    }
                } else {
                    cliente.RegistrarPago();
                }
                opcion = 3;

            }
        } else {
            Planificador planificador = new Planificador();
            Evento evento = new Evento();
            System.out.println("1. Consultar solicitudes pendientes.\n 2. Registrar Evento.\n3. Confirmar Evento.\n4. Consultar Evento\n5. Salir");
            System.out.print("Escoja una opcion:");
            opcion = sc.nextInt();
            sc.nextLine();
            while (opcion != 5) {
                switch (opcion) {
                    case 1:
                        planificador.consultarSolicitudes();

                        break;
                    case 2:
                        planificador.registrarEvento(evento.getID());

                        break;
                    case 3:
                        planificador.confirmarEvento();

                        break;
                    case 4:
                        planificador.consultarEvento();
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;

                }
            }

        }

    }

}
