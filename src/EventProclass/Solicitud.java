
package EventProclass;

<<<<<<< HEAD
import Events.Estado;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

=======
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
>>>>>>> d1e21fb83679e9b9a1cbcbafcdb9b76a45a177e9
public class Solicitud {
    private final int ID;
    private int numero;
    private final Cliente cliente;
    private final Planificador planificador;
    private final Date fechaEvento;
    private final String tipoEvento;
    private final Date fechaSolicitud;
    private Estado estadoSolicitud;
    private final double precioBase;
    private ArrayList<Integer> ids;

    public Solicitud(int numero, Cliente cliente, Planificador planificador, String tipoEvento,Date fechaSolicitud, Date fechaEvento) {
        this.numero = numero;
        this.cliente = cliente;
        this.planificador = planificador;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEvento = fechaEvento;
        this.estadoSolicitud = Estado.PENDIENTE;
        this.tipoEvento = tipoEvento;
        if(tipoEvento.equals("Boda"))
            this.precioBase = 3500.00;
        else if(tipoEvento.equals("Fiesta Empresarial"))
            this.precioBase = 2000.00;
        else
            this.precioBase = 300;
        this.ID = generarCodigo();
    }

    public int getID() {
        return ID;
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

    public void setEstadoSolicitud(Estado estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    private int generarCodigo(){
        Random r = new Random();
        int n = r.nextInt(100000);
        while(ids.contains(n)){
            n = r.nextInt(100000);
        }
        ids.add(n);
        return n;
    }

    
    //Atributos
    private int numero;
    private Cliente cliente;
    private int ID;
    private Planificador planificador;
    private Date fechaSolicitud;
    private Date fechaEvento;
    private Estado tipoEstado;
    private ArrayList<Solicitud> solicitudes;
    
    //Metodos    
    //Genera un codigo aleatorio de 4 digitos que no se repite
    Set<Integer> usados = new HashSet<>();    
    private int generarCodigo(){
        boolean aux = false;
        Random x = new Random();
        int codigo = x.nextInt(9999)+1;        
        while(aux==false){
            if(usados.contains(codigo)){
                codigo = x.nextInt(9999)+1;
                aux=false;
            }
            else{
                usados.add(codigo);
                aux=true;
            }
        }
        aux=false;
        
        return codigo;
    }
    
}
