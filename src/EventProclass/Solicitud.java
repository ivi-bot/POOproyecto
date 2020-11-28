/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

import Events.Estado;
import Events.Evento;

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
    private final Evento evento;
    private final Date fechaSolicitud;
    private Estado estadoSolicitud;
    private ArrayList<Integer> ids;

    public Solicitud(int numero, Cliente cliente, Planificador planificador, Date fechaSolicitud, Evento evento) {
        this.numero = numero;
        this.cliente = cliente;
        this.planificador = planificador;
        this.fechaSolicitud = fechaSolicitud;
        this.evento = evento;
        this.estadoSolicitud = Estado.PENDIENTE;
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

    public Evento getEvento() {
        return evento;
    }

    public Estado getEstadoSolicitud() {
        return estadoSolicitud;
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
