/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

import Events.Evento;
import java.util.Date;

/**
 *
 * @author
 */
public class Cliente extends Usuario {

    private String telefono;
    private String correo;

    //pRUEBA LUEGO CORREGIR
    private Date fecha_usuario;
    
    
    private boolean validarTiempo() {
        return true;
    }

    public void crearSolicitud() {
        System.out.println("/**********************NUEVA SOLICITUD******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        super.mostrarInformacion();
        System.out.print("TIPO DE EVENTO (Elija)\n1. Boda\n2.Fiesta Infantil\n3.Fiesta Empresarial\nSeleccione: ");
        System.out.println("Seleccione: ");

        super.opcion_usuario = sc.nextLine();
        switch (super.opcion_usuario) {
            case "1":
                System.out.println("/**********************EVENTO BODA******"
                + "****************/");
               
                validarTiempo();
                break;
            case "2":
                System.out.println("/**********************EVENTO FIESTA INFANTIL******"
                + "****************/");
                validarTiempo();

                break;
            case "3":
                System.out.println("/**********************EVENTO FIESTA EMPRESARIAL******"
                + "****************/");
                validarTiempo();

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
    }

}
