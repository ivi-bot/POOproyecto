package Events;

import EventProclass.Cliente;
import EventProclass.Planificador;

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

    public void mostrarInformacion(){
        System.out.println("Some Code");
    }

    public void mostrarPromociones(){
        System.out.println("Some Code!");
    }
    //Genera un numero aleatorio y se le asigna el valor a la variable de instancia ID, este valor es unico
    //y no retorna nada.
    private int generarCodigo(){
        Random r = new Random();
        return r.nextInt(10000);
    }
}
