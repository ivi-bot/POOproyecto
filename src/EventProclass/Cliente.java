/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

import Events.Estado;
import Events.Evento;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author
 */
public class Cliente extends Usuario {

    private String telefono;
    private String correo;
    private String opcion_usuario;
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private boolean validarTiempo(int i) {

        Evento evento = new Evento();
        Date currentDate = new Date();
        String fechaActual = dateFormat.format(currentDate);
        System.out.println(dateFormat.format(currentDate));
        System.out.print("Fecha del evento: ");
        Scanner t = new Scanner(System.in);
        String fechaUsuario = t.nextLine();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechaActual.substring(0, 2)));
        cal.set(Calendar.MONTH, Integer.parseInt(fechaActual.substring(3, fechaActual.length() - 5)));
        cal.set(Calendar.YEAR, Integer.parseInt(fechaActual.substring(6, fechaActual.length())));
        Date firstDate = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechaUsuario.substring(0, 2)));
        cal.set(Calendar.MONTH, Integer.parseInt(fechaUsuario.substring(3, fechaUsuario.length() - 5)));
        cal.set(Calendar.YEAR, Integer.parseInt(fechaUsuario.substring(6, fechaUsuario.length())));
        Date secondDate = cal.getTime();
        long difD = secondDate.getTime() - firstDate.getTime();
        System.out.println("Days: " + difD / 1000 / 60 / 60 / 24);

        try {
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual));
            fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaUsuario));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            int difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            System.out.println(difM);

            switch (i) {
                case 1:
                    if (difM >= 10) {
                        evento.setFechaEvento(secondDate);
                        return true;
                    }
                    ;
                    break;
                case 2:
                    if (difD >= 21) {
                        evento.setFechaEvento(secondDate);
                        return true;
                    }
                    break;
                case 3:
                    if (difM >= 2) {
                        evento.setFechaEvento(secondDate);
                        return true;
                    }

                    break;
            }

        } catch (ParseException ex) {

        }
        return false;
        // evento.setFechasolicitud(fechaActual);
//        switch (i) {
//            case 1:
//                if (difM >= 10) {
//                    //       evento.setFechaEvento(fecha_usuario);
//                    return true;
//                }
//                ;
//                break;
//            case 2:
//                if (difD >= 21) {
//                    //     evento.setFechaEvento(fecha_usuario);
//                    return true;
//                }
//                break;
//            case 3:
//                if (difM >= 2) {
//                    //    evento.setFechaEvento(fecha_usuario);
//                    return true;
//                }
//
//                break;
//        }
//        return false;
    }

    public String crearSolicitud() {
        Evento evento = new Evento();
                Planificador p = new Planificador();
        Cliente cliente = new Cliente();

        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("/**********************NUEVA SOLICITUD******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        super.mostrarInformacion();
        System.out.println("TIPO DE EVENTO (Elija)\n1.Boda\n2.Fiesta Infantil\n3.Fiesta Empresarial");
        System.out.print("Seleccione: ");
        opcion_usuario = sc.nextLine();
        switch (opcion_usuario) {

            case "1":
                System.out.println("/**********************EVENTO BODA******"
                        + "****************/");
                while (validarTiempo(1) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 10 meses para planificar. Ingrese nuevamente.");
                }
                //evento.setTipo("BODA");
                System.out.println("¡Fecha válida!");

                                return "BODA";

            case "2":
                System.out.println("/**********************EVENTO FIESTA INFANTIL******"
                        + "****************/");
                while (validarTiempo(2) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 3 semanas para planificar. Ingrese nuevamente.");
                }
               // evento.setTipo("FIESTA INFANTIL");
                System.out.println("¡Fecha válida!");
                return "FIESTA INFANTIL";

            case "3":
                System.out.println("/**********************EVENTO FIESTA EMPRESARIAL******"
                        + "****************/");
                while (validarTiempo(3) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 2 meses para planificar. Ingrese nuevamente.");
                }
                //evento.setTipo("FIESTA EMPRESARIAL");
                                System.out.println("¡Fecha válida!");

                return "FIESTA EMPRESARIAL";
              
            default:
                System.out.println("Opcion invalida");
                break;

        }    
                        return "Invalido";

    }

    public void RegistrarPago() {
        System.out.println("/**********************REGISTRO PAGO******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        Evento evento = new Evento();
        //int codigoPago, int codigoEvento, double totalPagar, Estado estado, int codigoTransaccion, Date fechaRegistro
        int codigo = evento.getID();
        int codigoT;
        System.out.println("Su orden con código " + codigo + "esta pendiente de pago");
        System.out.print("¿Desea registrar pago ahora? (S/N): ");
        String op = sc.nextLine();
        while (op != "S" || op != "N") {
            System.out.println("Ingrese una opcion correcta: ");
        }
        if (op == "S") {
            System.out.print("Ingrese el codigo de la transacción: ");
            codigoT = sc.nextInt();
            System.out.println("Listo, se ha registrado. Cuando el planificador valide el pago se pondrá en contacto con usted");
        } else {
            System.out.println("Gracias");
        }
    }

}
