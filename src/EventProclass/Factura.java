package EventProclass;

import Events.Estado;

import java.util.Date;

public class Factura {
    private int codigoPago;
    private int codigoEvento;
    private double totalPagar;
    private Estado estado;
    private int codigoTransaccion;
    private Date fechaRegistro;

    public Factura(int codigoPago, int codigoEvento, double totalPagar, Estado estado, int codigoTransaccion, Date fechaRegistro) {
        this.codigoPago = codigoPago;
        this.codigoEvento = codigoEvento;
        this.totalPagar = totalPagar;
        this.estado = estado;
        this.codigoTransaccion = codigoTransaccion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(int codigoPago) {
        this.codigoPago = codigoPago;
    }

    public int getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(int codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
