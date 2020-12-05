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
    private  Date fechaEvento;
    private final String tipoEvento;
    private  Date fechaSolicitud;
    private Estado estadoSolicitud;
    private final double precioBase;
    private ArrayList<Integer> ids;
    private  String fechaSolicitudS;
    private  String fechaEventoS;

    private ArrayList<Solicitud> solicitudes=new ArrayList<>();

    public Solicitud(Cliente cliente, Planificador planificador, String tipoEvento, String fechaSolicitudS, String fechaEventoS) {
        //this.numero = numero;
        this.cliente = cliente;
        this.planificador = planificador;
        this.fechaSolicitudS = fechaSolicitudS;
        this.fechaEventoS = fechaEventoS;
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

    public String getFechaSolicitudS() {
        return fechaSolicitudS;
    }

    public void setFechaSolicitudS(String fechaSolicitudS) {
        this.fechaSolicitudS = fechaSolicitudS;
    }

    public String getFechaEventoS() {
        return fechaEventoS;
    }

    public void setFechaEventoS(String fechaEventoS) {
        this.fechaEventoS = fechaEventoS;
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
/**
 * 
 * @return Formato del objeto cliente al guardarse en la lista
 */
    @Override
    public String toString() {
        return cliente.nombre.toUpperCase() + " "+cliente.apellido.toUpperCase() +"\n"+ 
                 planificador.nombre.toUpperCase()+ planificador.getApellido().toUpperCase()+
               fechaSolicitudS + "\n"+
               fechaEventoS ;

    }
    /**
     * Muestra mensaje del registro al cliente
     */
    public void registro(){
        System.out.println( "/**********************SOLICITUD REGISTRADA******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/\nCLIENTE: "
                + cliente.nombre.toUpperCase() +" "+ cliente.apellido.toUpperCase() + "\n"
                + "PLANIFICADOR ASIGNADO: " + planificador.nombre.toUpperCase() + " "+planificador.getApellido().toUpperCase() + "\n"
                + "FECHA DE REGISTRO: " + fechaSolicitudS + "\n"
                + "FECHA DEL EVENTO: " + fechaEventoS + "\n\n" + "**Se ha registrado su solicitud, pronto el planificador se"
                + " contactará con usted por teléfono o video conferencia para completar el proceso de recolección de datos");}

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
