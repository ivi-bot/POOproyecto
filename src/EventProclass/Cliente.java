/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

/**
 *
 * @author
 */
public class Cliente extends Usuario {

    private String telefono;
    private String correo;

    private boolean validarTiempo() {
        return true;
    }
    
    public void crearSolicitud(){
           System.out.println("/**********************NUEVA SOLICITUD******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
           super.mostrarInformacion();
        System.out.print("TIPO DE EVENTO (Elija)\n1. Boda\n2.Fiesta Infantil\n3.Fiesta Empresarial\nSeleccione: ");
    }
    public void RegistrarPago(){
    System.out.println("/**********************REGISTRO PAGO******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
    }

}
