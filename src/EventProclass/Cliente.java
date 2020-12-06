/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

import Archivos.Archivo;
import Events.Estado;
import Events.Evento;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private String fecha1;
    private String fecha2;
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente(String telefono, String correo, String nombre, String apellido, String nomUsuario, String contraseña, char tipo) {
        super(nombre, apellido, nomUsuario, contraseña, tipo);
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente(String nombre, String apellido, String nomUsuario, String contraseña, char tipo) {
        super(nombre, apellido, nomUsuario, contraseña, tipo);
    }

    public Cliente(String nombre) {
        super(nombre);
    }

    /**
     * @param tiempo opcion que se recibe del metodo crearSolicitud donde 1, es
     * para boda, 2 fiesta infantil y 3 fiesta empresarial y dentro la se
     * analiza si la fecha es valida
     * @return Retorna un oolean que indicara si la fecha es correcta o no segun
     * el tipo de evento
     *
     */
    private boolean validarTiempo(int tiempo) {
        Date currentDate = new Date();
        String fechaActual = dateFormat.format(currentDate);
        // System.out.println(dateFormat.format(currentDate));
        System.out.println("Ingrese la fecha deseada con el siguiente formato: dd/MM/yyyy\nPsdt. No ingrese fechas anteriores a la actual, su registro será inválido");
        System.out.print("Fecha del evento: ");
        Scanner t = new Scanner(System.in);
        String fechaUsuario = t.nextLine();
        while (!fechaUsuario.contains("/")) {
            System.out.print("Por favor ingrese la fecha deseada con el siguiente formato: dd/MM/yyyy\nSi tiene conflicto aqui un ejemplo:04/04/2012");
            fechaUsuario = t.nextLine();
        }
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
        //  System.out.println("Days: " + difD / 1000 / 60 / 60 / 24);
        try {
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual));
            fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaUsuario));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            int difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            // System.out.println(difM);

            switch (tiempo) {
                case 1:
                    if (difM >= 10) {
                        fecha1 = fechaUsuario;
                        fecha2 = fechaActual;
                        return true;
                    }
                    ;
                    break;
                case 2:
                    if (difD >= 21) {
                        fecha1 = fechaUsuario;
                        fecha2 = fechaActual;
                        return true;
                    }
                    break;
                case 3:
                    if (difM >= 2) {
                        fecha1 = dateFormat.format(secondDate);
                        fecha2 = fechaActual;
                        return true;
                    }
                    break;
            }
        } catch (ParseException ex) {
        }
        return false;
    }

    /**
     *
     * @return Retorna el tipo de evento que creo el usuario
     */
    public String crearSolicitud() {
        Scanner sc = new Scanner(System.in);
        System.out.println("/**********************NUEVA SOLICITUD******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        super.mostrarInformacion();
        System.out.println("TIPO DE EVENTO (Elija)\n1.Boda\n2.Fiesta Infantil\n3.Fiesta Empresarial");
        System.out.print("Seleccione: ");
        opcion_usuario = sc.nextLine();
        ArrayList<String> opcionesV2 = new ArrayList<>();
        opcionesV2.add("1");
        opcionesV2.add("2");
        opcionesV2.add("3");
        while (!opcionesV2.contains(opcion_usuario)) {
            System.out.print("Escriba una opcion correcta:");
            opcion_usuario = sc.nextLine();
        }
        switch (opcion_usuario) {
            case "1":
                System.out.println("/**********************EVENTO BODA******"
                        + "****************/");
                while (validarTiempo(1) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 10 meses para planificar. Ingrese nuevamente.");
                }
                System.out.println("¡Fecha válida!");

                return "BODA" + fecha1 + fecha2;

            case "2":
                System.out.println("/**********************EVENTO FIESTA INFANTIL******"
                        + "****************/");
                while (validarTiempo(2) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 3 semanas para planificar. Ingrese nuevamente.");
                }
                // evento.setTipo("FIESTA INFANTIL");
                System.out.println("¡Fecha válida!");
                return "FIESTA INFANTIL" + fecha1 + fecha2;

            case "3":
                System.out.println("/**********************EVENTO FIESTA EMPRESARIAL******"
                        + "****************/");
                while (validarTiempo(3) != true) {
                    System.out.println("***La fecha es muy próxima. Para este tipo de evento debemos tener \n"
                            + "por lo menos 2 meses para planificar. Ingrese nuevamente.");
                }
                //evento.setTipo("FIESTA EMPRESARIAL");
                System.out.println("¡Fecha válida!");

                return "FIESTA EMPRESARIAL" + fecha1 + fecha2;

            default:
                System.out.println("Opcion invalida");
                break;

        }
        return "Invalido";

    }

    public void RegistrarPago(int ID) {
        System.out.println("/**********************REGISTRO PAGO******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        System.out.println("Su orden con código " + ID + " esta pendiente de pago");
        System.out.print("¿Desea registrar pago ahora? (S/N): ");
        Scanner sc1 = new Scanner(System.in);
        String op = sc1.nextLine();
        ArrayList<String> opcionesV4 = new ArrayList<>();
        opcionesV4.add("S");
        opcionesV4.add("N");
        opcionesV4.add("s");
        opcionesV4.add("n");
        while (!opcionesV4.contains(op)) {
            System.out.print("Escriba una opcion correcta:");
            op = sc1.nextLine();
        }

        ArrayList<String> opcionesV1 = new ArrayList<>();
        opcionesV1.add("S");
        opcionesV1.add("N");
        opcionesV1.add("s");
        opcionesV1.add("n");
        while (!opcionesV1.contains(op)) {
            System.out.print("Escriba una opcion correcta:");
            op = sc1.nextLine();
        }
        if (op.equalsIgnoreCase("S")) {

            System.out.println("Ingrese el codigo de la transacción: ");
            System.out.print("Ingrese un numero valido por favor: ");
            String codigoT = sc1.nextLine();

            System.out.println("Listo, se ha registrado. Cuando el planificador valide el pago se pondrá en contacto con usted");
        } else {
            System.out.println("Gracias");
        }
    }

}
