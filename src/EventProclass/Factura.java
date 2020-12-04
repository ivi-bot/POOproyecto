package EventProclass;

import Events.Estado;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Factura {
    private final int id;
    private final int codigoPago;
    private final int codigoEvento;
    private final double totalPagar;
    private Estado estado = Estado.PENDIENTE;
    private final int codigoTransaccion;
    private final Date fechaRegistro;
    private ArrayList<Integer> ids;

    public Factura(int codigoPago, int codigoEvento, double totalPagar, Estado estado, int codigoTransaccion, Date fechaRegistro) {
        this.codigoPago = codigoPago;
        this.codigoEvento = codigoEvento;
        this.totalPagar = totalPagar;
        this.estado = estado;
        this.codigoTransaccion = codigoTransaccion;
        this.fechaRegistro = fechaRegistro;
        this.id = generarID();
    } 

    public int getCodigoPago() {
        return codigoPago;
    }

    public int getCodigoEvento() {
        return codigoEvento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
/**
 * 
 * @return retorna un codigo aleatorio para la factura
 */
    private int generarID(){
        Random r = new Random();
        int n = r.nextInt(1000);
        while(ids.contains(n)){
            n = r.nextInt(1000);
        }
        ids.add(n);
        return n;
    }

}
