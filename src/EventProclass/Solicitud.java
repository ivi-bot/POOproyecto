package EventProclass;

import Events.Estado;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import Events.Evento;
import Events.Estado;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author FERNAN
 */
public class Solicitud {
    //Atributos

    private  int ID;
    private int numero;
    private final Cliente cliente;
    private final Planificador planificador;
    private final Date fechaEvento;
    private final String tipoEvento;
    private final Date fechaSolicitud;
    private Estado estadoSolicitud;
    private final double precioBase;
    private ArrayList<Integer> ids;

    private ArrayList<Solicitud> solicitudes;

    public Solicitud(Cliente cliente, Planificador planificador, String tipoEvento, Date fechaSolicitud, Date fechaEvento) {
        //this.numero = numero;
        this.cliente = cliente;
        this.planificador = planificador;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEvento = fechaEvento;
        this.estadoSolicitud = Estado.PENDIENTE;
        this.tipoEvento = tipoEvento;
        this.ID = generarCodigo2();
        if (this.tipoEvento.equalsIgnoreCase("Boda")) {
            this.precioBase = 3500.00;
        } else if (this.tipoEvento.equalsIgnoreCase("Fiesta Empresarial")) {
            this.precioBase = 2000.00;
        } else {
            this.precioBase = 300;
        }

    }

    public int getID() {
        return ID;
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Estado getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return cliente.nombre.toUpperCase() + cliente.apellido.toUpperCase() + 
                planificador.nombre + planificador.apellido +
                fechaSolicitud + 
               fechaEvento ;

    }
    public void registro(){
        System.out.println( "/**********************SOLICITUD REGISTRADA******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/\nCLIENTE: "
                + cliente.nombre.toUpperCase() + cliente.apellido.toUpperCase() + "\n"
                + "PLANIFICADOR ASIGNADO: " + planificador.nombre + planificador.apellido + "\n"
                + "FECHA DE REGISTRO: " + fechaSolicitud + "\n"
                + "FECHA DEL EVENTO: " + fechaEvento + "\n\n" + "**Se ha registrado su solicitud, pronto el planificador se"
                + "contactará con usted por teléfono o video conferencia para completar el proceso de recolección de datos");}

    public void setEstadoSolicitud(Estado estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }
//
//    private int generarCodigo() {
//        Random r = new Random();
//        int n = r.nextInt(100000);
//        while (ids.contains(n)) {
//            n = r.nextInt(100000);
//        }
//        ids.add(n);
//        return n;
//    }

    //Metodos    
    //Genera un codigo aleatorio de 4 digitos que no se repite
    Set<Integer> usados = new HashSet<>();

    private int generarCodigo2() {
        boolean aux = false;
        Random x = new Random();
        int codigo = x.nextInt(9999) + 1;
        while (aux == false) {
            if (usados.contains(codigo)) {
                codigo = x.nextInt(9999) + 1;
                aux = false;
            } else {
                usados.add(codigo);
                aux = true;
            }
        }
        aux = false;

        return codigo;
    }

}
