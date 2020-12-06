package EventProclass;

import Events.Estado;
import Events.Evento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Factura {

    private final int id;
    private final int codigoPago;
    private final int codigoEvento;
    private final double totalPagar;
    private Estado estado = Estado.PENDIENTE;
    private int codigoTransaccion;
    private Date fechaRegistro;
    private String fechaFactura;
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

    public Factura(int codigoPago, int codigoEvento, double totalPagar, Estado estado, Date fechaRegistro) {
        this.codigoPago = codigoPago;
        this.codigoEvento = codigoEvento;
        this.totalPagar = totalPagar;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.id = generarID();
    }

    public Factura(int codigoPago, String fechaFactura) {
        this.codigoPago = codigoPago;
        this.estado = estado;
        this.fechaFactura = fechaFactura;
        this.id = 0;
        this.codigoEvento = 0;
        this.totalPagar = 0;
    }

    public int getCodigoPago() {
        return codigoPago;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
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
    private int generarID() {
        Random r = new Random();
        int n = r.nextInt(1000);
        while (ids.contains(n)) {
            n = r.nextInt(1000);
        }
        ids.add(n);
        return n;
    }

    public void mostrarOrdendePago(Cliente c, ArrayList<Opcional> elementosAdicionales, Evento e) {
        System.out.println("CODIGO PAGO: " + codigoPago + "\nFECHA: " + fechaRegistro + "\nCLIENTE: " + c.getNombre() + " "
                + c.getApellido() + "EVENTO: " + e.getTipo() + "FECHA EVENTO:" + e.getFechaEvento() + "\n\n" + "ADICIONALES:");
        ArrayList<Adicional> adicionales = new ArrayList<Adicional>();
        ArrayList<String> subtipos = new ArrayList<String>();
        System.out.println("/**ORDEN DE PAGO**"
                + "**/\n/\t\t\t\t\t\t\t\t\t\b\b\t\t\t\t\t\t\t\t\t\t/\n/**"
                + "******/");
        System.out.println("CODIGO PAGO: " + codigoPago + "\nFECHA: " + fechaRegistro + "\nCLIENTE: " + c + "EVENTO: " + e.getTipo()
                + "FECHA EVENTO:" + e.getFechaEvento() + "\n\n" + "ADICIONALES:");
        for (Opcional o : elementosAdicionales) {

            if (!adicionales.contains(o.getTipo()) && !subtipos.contains(o.getSubtipo())) {
                System.out.println(o.getTipo() + " " + o.getSubtipo().toUpperCase());
                adicionales.add(o.getTipo());
                subtipos.add(o.getSubtipo());
            }
        }
    }
}
