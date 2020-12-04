/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import EventProclass.Archivo;
import EventProclass.Cliente;
import EventProclass.Planificador;
import EventProclass.Solicitud;
import EventProclass.Usuario;
import Events.Estado;
import Events.Evento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author
 */
public class interfazEventpro {

    private ArrayList<String> usuarios = Archivo.LeeFichero("usuarios.txt");
    String opcion;
    String opcion2;

    /**
     * Inicio del sistema
     */
    public void iniciarSeccion() {

        usuarios = Archivo.LeeFichero("usuarios.txt");

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n\n \t\tBIENVENIDO AL SISTEMA \n\n"
                + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        String usuarioComprobar = sc.nextLine();
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> nomUsuarios = new ArrayList<>();
        ArrayList<String> contraseñas = new ArrayList<>();
        ArrayList<String> planificadores = new ArrayList<>();
        ArrayList<String> apellidoPlanificador = new ArrayList<>();
        ArrayList<Character> tipo = new ArrayList<>();
        ArrayList<String> apellidoUsuario = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            String[] datos = usuarios.get(i).split(";");
            nombres.add(datos[0]);
            nomUsuarios.add(datos[2]);
            contraseñas.add(datos[3]);
            apellidoUsuario.add(datos[1]);
            tipo.add(datos[datos.length - 1].charAt(0));
            if (datos[datos.length - 1].equals("P")) {
                planificadores.add(datos[0]);
                apellidoPlanificador.add(datos[1]);
            }
        }
        while (!nomUsuarios.contains(usuarioComprobar)) {
            System.out.println("Ingrese un usuario  válido");
            usuarioComprobar = sc.nextLine();
        }
        int indiceUsuario = nomUsuarios.indexOf(usuarioComprobar);
        System.out.print("CONTRASEÑA: ");
        String contraseñaComprobar = sc.nextLine();

        while (!contraseñas.get(nomUsuarios.indexOf(usuarioComprobar)).equals(contraseñaComprobar)) {

            //while (contraseñas.get(nomUsuarios.indexOf(usuarioComprobar)).equals(contraseñaComprobar)) {
            System.out.print("Ingrese la contraseña correctamente: ");
            contraseñaComprobar = sc.nextLine();
        }

        Usuario usuario = new Usuario(nombres.get(indiceUsuario), apellidoUsuario.get(indiceUsuario), nomUsuarios.get(indiceUsuario), contraseñas.get(indiceUsuario), tipo.get(indiceUsuario));
        int planificador = (int) Math.random();
        Cliente cliente = new Cliente(nombres.get(indiceUsuario), apellidoUsuario.get(indiceUsuario), nomUsuarios.get(indiceUsuario), contraseñas.get(indiceUsuario), tipo.get(indiceUsuario));
        Planificador p = new Planificador(planificadores.get(planificador), apellidoPlanificador.get(planificador));
        int id;
        //if (usuarios.stream().filter(n -> n.startsWith(usuario.getNomUsuario())).anyMatch(s -> s.endsWith(";C"))) {
        if (String.valueOf(tipo.get(indiceUsuario)).equalsIgnoreCase("C")) {
            System.out.println("1. Solicitar planificación de evento\n2. Registrar pago Evento\n3. Salir");
            System.out.print("Escoja una opcion:");
            opcion = sc.nextLine();
            while (Integer.parseInt(opcion) != 3) {
                if (Integer.parseInt(opcion)  == 1) {
                    String tipoEvento = cliente.crearSolicitud();
                    System.out.println("¿Desea registrar su solicitud? S/N");
                    System.out.println(tipoEvento);
                    String opcion2 = sc.nextLine();
                    Evento evento = new Evento(tipoEvento.substring(0, tipoEvento.length() - 20), tipoEvento.substring(tipoEvento.length() - 20, tipoEvento.length() - 10), tipoEvento.substring(tipoEvento.length() - 10, tipoEvento.length()));
                    if (opcion2.equalsIgnoreCase("s")) {
                        System.out.println(evento.getTipo());
                        Solicitud solicitud = new Solicitud(cliente, p, evento.getTipo(), evento.getFechasolicitudF(), evento.getFechaEventoF());
                        solicitud.setEstadoSolicitud(Estado.PENDIENTE);

                        Archivo.EscribirArchivo("solicitudes.txt", solicitud.getID() + "," + cliente.getNombre() + "," + p.getNombre() + "," + solicitud.getFechaSolicitudS() + "," + solicitud.getFechaEventoS() + "," + solicitud.getEstadoSolicitud());
                        solicitud.getSolicitudes().add(solicitud);
                        solicitud.registro();
                        id = evento.getID();
                    } else {
                        System.out.println("¡Gracias por visitarnos!");
                    }

//                    String opcion2 = sc.nextLine();
//                    if (opcion2.equalsIgnoreCase("s")) {
//                        System.out.println(evento.getTipo());
//                        Solicitud solicitud = new Solicitud(cliente, p, evento.getTipo(), evento.getFechasolicitud(), evento.getFechaEvento());
//                        solicitud.setEstadoSolicitud(Estado.PENDIENTE);
//
//                        Archivo.EscribirArchivo("solicitudes.txt", solicitud.getID() + "," + cliente.getNombre() + "," + planificador + "," + solicitud.getFechaSolicitud() + "," + solicitud.getFechaEvento() + "," + solicitud.getEstadoSolicitud());
//                        System.out.println("Su planificador asignado es: " + planificador);
//                        solicitud.getSolicitudes().add(solicitud);
//                        solicitud.registro();
//
//                    } else {
//                        System.out.println("¡Gracias por visitarnos!");
//                    }
//                    System.out.println("Ha registrado todos los datos necesarios para la solicitud.\n\n¿Desea registrar su solicitud? S/N");
//                    opcion2 = sc.nextLine();
//                    if (opcion2.equalsIgnoreCase("s")) {
//                        System.out.println(evento.getTipo());
//                        Solicitud solicitud = new Solicitud(cliente, p, evento.getTipo(), evento.getFechasolicitud(), evento.getFechaEvento());
//                        solicitud.setEstadoSolicitud(Estado.PENDIENTE);
//                        String planificador = planificadores.get((int) Math.random());
//                        Archivo.EscribirArchivo("solicitudes.txt", solicitud.getID() + "," + cliente.getNombre() + "," + p.getNombre() + "," + solicitud.getFechaSolicitud() + "," + solicitud.getFechaEvento() + "," + solicitud.getEstadoSolicitud());
//                        System.out.println("Su planificador asignado es: " + planificador);
//                        p.anadirSolicitud(solicitud);
//                        solicitud.toString();
//
//                    } else {
//                        System.out.println("¡Gracias por visitarnos!");
//                    }
                } else {
                    cliente.RegistrarPago();
                }
                opcion = "3";

            }
        } else {
            System.out.println("1. Consultar solicitudes pendientes.\n 2. Registrar Evento.\n3. Confirmar Evento.\n4. Consultar Evento\n5. Salir");
            System.out.print("Escoja una opcion:");
            opcion = sc.nextLine();
            sc.nextLine();
            while (Integer.parseInt(opcion) != 5) {
                switch (Integer.parseInt(opcion)) {
                    case 1:
                        p.consultarSolicitudes();

                        break;
                    case 2:
                        p.registrarEvento(5);

                        break;
                    case 3:
                        p.confirmarEvento();

                        break;
                    case 4:
                        p.consultarEvento();
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;

                }
            }

        }

    }

}
