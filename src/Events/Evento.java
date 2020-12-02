package Events;

import EventProclass.Cliente;
import EventProclass.Planificador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Evento {
    protected final int ID;
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
    protected int capacidad;
    private final ArrayList<Integer> codes = new ArrayList<>();

    public Evento(String tipo, Date fecha, Planificador planificador, Cliente cliente, double precioBase, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.planificador = planificador;
        this.cliente = cliente;
        this.precioBase = precioBase;
        this.estado = estado;
        this.duracion = duracion;
        this.numeroPersonas = numeroPersonas;
        this.elementosAdicionales = elementosAdicionales;
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

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
<<<<<<< HEAD
    //Genera un numero aleatorio y se le asigna el valor a la variable de instancia ID, este valor es unico
    //y no retorna nada.
=======

    /*La funcion generarCode genera un numero aleatorio entre el rango de 0 a 100000, y devuelve un entero
    * que es el codigo que se le asigna a la variable de instacia ID*/
>>>>>>> d1e21fb83679e9b9a1cbcbafcdb9b76a45a177e9
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
