/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

import Events.Evento;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Cliente extends Usuario {

    private String telefono;
    private String correo;
    private String opcion_usuario;

    private boolean validarTiempo(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fecha del evento: ");
        String cadena = sc.nextLine();
        LocalDate fecha_usuario = LocalDate.of(Integer.parseInt(cadena.substring(cadena.length() - 4, cadena.length())), Month.of(Integer.parseInt(cadena.substring(3, 5))), Integer.parseInt(cadena.substring(0, 2)));
        LocalDate fechaActual = LocalDate.now();
        System.out.println(fecha_usuario);
        System.out.println(fechaActual);
        Period periodo = Period.between(fechaActual, fecha_usuario);
        switch (i) {
            case 1:
                if (periodo.getMonths() >= 10) {
                    return true;
                }
                ;
                break;
            case 2:
                if (periodo.getDays() >= 21) {
                    return true;
                }
                break;
            case 3:
                if (periodo.getMonths() >= 2) {
                    return true;
                }

                break;
        }
        return false;
    }

    public void crearSolicitud() {
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
                System.out.println("¡Fecha válida!");

                break;
            case "2":
                System.out.println("/**********************EVENTO FIESTA INFANTIL******"
                        + "****************/");
                while (validarTiempo(2) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 3 semanas para planificar. Ingrese nuevamente.");
                }
                System.out.println("¡Fecha válida!");

                break;
            case "3":
                System.out.println("/**********************EVENTO FIESTA EMPRESARIAL******"
                        + "****************/");
                while (validarTiempo(3) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 2 meses para planificar. Ingrese nuevamente.");
                }
                System.out.println("¡Fecha válida!");

                break;
            default:
                System.out.println("Opcion invalida");
                break;

        }

    }

    public void RegistrarPago() {
        System.out.println("/**********************REGISTRO PAGO******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        Evento evento=new Evento();
        //int codigoPago, int codigoEvento, double totalPagar, Estado estado, int codigoTransaccion, Date fechaRegistro
        int codigo=evento.getID();
        int codigoT;
        System.out.println("Su orden con código "+codigo+"esta pendiente de pago");
        System.out.print("¿Desea registrar pago ahora? (S/N): ");
        String op=sc.nextLine();
        while(op!="S"||op!="N"){
            System.out.println("Ingrese una opcion correcta: ");}
        if(op=="S"){
            System.out.print("Ingrese el codigo de la transacción: ");
            codigoT=sc.nextInt();
            System.out.println("Listo, se ha registrado. Cuando el planificador valide el pago se pondrá en contacto con usted");
        }
        else{
            System.out.println("Gracias");
        }
    }

}
