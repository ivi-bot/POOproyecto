
package EventProclass;


import Events.Estado;
import Events.Evento;
import java.util.Date;

public class Boda extends Evento{
    
    private final String tipoVehiculo;
    private int precioBase = 3500;

    
//    public Boda(String tipoVehiculo, String tipo, Date fecha, Planificador planificador, Cliente cliente, double precioBase, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales) {
//        super(tipo, fecha, planificador, cliente, precioBase, estado, duracion, numeroPersonas, elementosAdicionales);
//    
//    }
//Atributos

    public Boda(String tipoVehiculo, String tipo, Date fecha, Planificador planificador, Cliente cliente, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales) {
        super(tipo, fecha, planificador, cliente, 3500, estado, duracion, numeroPersonas, elementosAdicionales);
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }


    @Override
    public void mostrarPromociones() {
        System.out.println("Promocion (Boda)");
    }

}
    

