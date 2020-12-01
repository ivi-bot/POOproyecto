/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

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

    
}
