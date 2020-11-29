package EventProclass;

import Events.Estado;

import java.util.Date;

public class Factura {
    private final int codigoPago;
    private final int codigoEvento;
    private final double totalPagar;
    private Estado estado = Estado.PENDIENTE;
    private final int codigoTransaccion;
    private final Date fechaRegistro;

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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
