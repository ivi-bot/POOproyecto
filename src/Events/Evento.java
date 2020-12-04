package Events;

import EventProclass.Cliente;
import EventProclass.Planificador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Evento {
    protected final int ID;
    protected String tipo;
    protected Date fechaEvento;
    protected Date fechasolicitud;
    protected Planificador planificador;
    protected Cliente cliente;
    protected double precioBase;
    protected Estado estado;
    protected Date duracion;
    protected int numeroPersonas;
    protected int elementosAdicionales;
    protected Date horaInicio;
    protected Date horaFin;
    protected int capacidad;
    private final ArrayList<Integer> codes = new ArrayList<>();
 protected String fechaEventoF;
    protected String fechasolicitudF;
    public Evento(String tipo, Date fechaEvento, Planificador planificador, Cliente cliente, double precioBase, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales) {
        this.tipo = tipo;
        this.fechaEvento = fechaEvento;
        this.planificador = planificador;
        this.cliente = cliente;
        this.precioBase = precioBase;
        this.estado = estado;
        this.duracion = duracion;
        this.numeroPersonas = numeroPersonas;
        this.elementosAdicionales = elementosAdicionales;
        this.ID = generarCodigo();
    }

    public Evento(String tipo,String fechaEventoF, String fechasolicitudF){
    this.tipo=tipo;
    this.fechaEventoF=fechaEventoF;
    this.fechasolicitudF=fechasolicitudF;
    this.ID = generarCodigo();

    }

    public Evento() {
        this.ID = generarCodigo();
    }
    
  
    

    public String getTipo() {
        return tipo;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Estado getEstado() {
        return estado;
    }

    public Date getDuracion() {
        return duracion;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public int getElementosAdicionales() {
        return elementosAdicionales;
    }

    public int getID() {
        return ID;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechasolicitud() {
        return fechasolicitud;
    }

    public String getFechaEventoF() {
        return fechaEventoF;
    }

    public void setFechaEventoF(String fechaEventoF) {
        this.fechaEventoF = fechaEventoF;
    }

    public String getFechasolicitudF() {
        return fechasolicitudF;
    }

    public void setFechasolicitudF(String fechasolicitudF) {
        this.fechasolicitudF = fechasolicitudF;
    }

    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void mostrarInformacion(){
        System.out.println("Some Code");
    }

    public void mostrarPromociones(){
        System.out.println("Some Code!");
    }
    //Genera un numero aleatorio y se le asigna el valor a la variable de instancia ID, este valor es unico
    //y no retorna nada.

    /*La funcion generarCode genera un numero aleatorio entre el rango de 0 a 100000, y devuelve un entero
    * que es el codigo que se le asigna a la variable de instacia ID*/
    private int generarCodigo(){
        Random r = new Random();
        int n = r.nextInt(1000);
        while(codes.contains(n)){
            n = r.nextInt(1000);
        }
        codes.add(n);
        return n;
    }
}
