package EventProclass;

import Events.Evento;

import java.util.List;

/**
 *
 * @author 
 */
public class Planificador extends Usuario{
    private List<Evento> eventos;
    private List<Solicitud> solicitudes;

    //Esta funcion permite consultar todas la solicitudes que tiene cada planificar y no retorna nada.
    public void consultarSolicitudes(){
        System.out.println("/**********************SOLICITUDES PENDIENTES******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        solicitudes.forEach(s -> System.out.println(s.getID() + "- " + s.getEvento().getFecha()));
    }
    public void registrarEvento(int ID){
    System.out.println("/**********************REGISTRO DE EVENTOS******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
    for(Solicitud s : solicitudes){
        if(s.getID() == ID){
            System.out.println("DATOS: ");
            System.out.println("CLIENTE: " + s.getCliente() + "\nPLANIFICADOR ASIGNADO: " + this.getApellido() +
                    " " + this.nombre + "\nFECHA DE REGISTRO:  " + s.getFechaSolicitud() + "\nTIPO DE EVENTO: " + s.getEvento().getTipo()+
                    "\nFECHA DEL EVENTO: " + s.getEvento().getFecha() + "\nPRECIO BASE: " + s.getEvento().getPrecioBase());
        }
    }
    }
    public void confirmarEvento(){
    System.out.println("/**********************CONFIRMAR EVENTO******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");}
    public void consultarEvento(){
    System.out.println("/**********************CONSULTAR EVENTOS******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");}
}
