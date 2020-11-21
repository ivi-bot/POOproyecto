package Events;

import EventProclass.Cliente;
import EventProclass.Planificador;

import java.util.Date;

public class Evento {
    protected int ID;
    protected Evento tipo;
    protected Date fecha;
    protected Planificador planificador;
    protected Cliente cliente;
    protected double precioBase;
    protected Estado estado;
    protected Date duracion;
    protected int numeroPersonas;
    protected int elementosAdicionales;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Evento getTipo() {
        return tipo;
    }

    public void setTipo(Evento tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    public void setPlanificador(Planificador planificador) {
        this.planificador = planificador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public int getElementosAdicionales() {
        return elementosAdicionales;
    }

    public void setElementosAdicionales(int elementosAdicionales) {
        this.elementosAdicionales = elementosAdicionales;
    }

    public void mostrarInformacion(){
        System.out.println("Some Code");
    }

    public void mostrarPromociones(){
        System.out.println("Some Code!");
    }
}
