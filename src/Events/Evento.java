package Events;

import EventProclass.Cliente;
import EventProclass.Planificador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Evento {
    protected final int ID ;
    protected String tipo;
    protected Date fecha;
    protected Planificador planificador;
    protected Cliente cliente;
    protected double precioBase;
    protected Estado estado;
    protected Date duracion;
    protected int numeroPersonas;
    protected int elementosAdicionales;
    protected Date horaInicio;
    protected Date horaFin;
    private ArrayList<Integer> codes;

    public Evento(String tipo, Date fecha, Planificador planificador, Cliente cliente, double precioBase, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales, Date horaInicio, Date horaFin) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.planificador = planificador;
        this.cliente = cliente;
        this.precioBase = precioBase;
        this.estado = estado;
        this.duracion = duracion;
        this.numeroPersonas = numeroPersonas;
        this.elementosAdicionales = elementosAdicionales;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ID = generarCodigo();
    }

    public Evento() {
        this.ID = generarCodigo();

    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void mostrarInformacion(){
        System.out.println("Some Code");
    }

    public void mostrarPromociones(){
        System.out.println("Some Code!");
    }

    /*La funcione generarCode genera un numero aleatorio entre el rango de 0 a 100000, y devuelve un entero
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
