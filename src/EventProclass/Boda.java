
package EventProclass;


import Events.Estado;
import Events.Evento;
import java.util.Date;

public class Boda extends Evento{
    
    private final String tipoVehiculo;
    private int precioBase = 3500;

    public Boda(String tipoVehiculo, String tipo, Date fecha, Planificador planificador, Cliente cliente, Estado estado, Date duracion, int numeroPersonas) {
        super(tipo, fecha, planificador, cliente, 3500, estado, duracion, numeroPersonas);
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }


    @Override
    public String mostrarPromociones() {
        super.mostrarPromociones();
        return "Los novios tendrán un 25% de descuento si compran sus tickets de luna de miel en la aereolínea LATAM";
    }

    @Override
    public String toString() {
        return super.toString() + "tipoVehiculo='" + tipoVehiculo + '\'' +
                ", precioBase=" + precioBase;
    }
}
    

