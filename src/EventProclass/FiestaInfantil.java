
package EventProclass;


import Events.Estado;
import Events.Evento;
import java.util.Date;

public class FiestaInfantil extends Evento{
    
    //Atributos
    private int pDisfrazados = 0;
    private int cantidadSorpresas;
    private boolean juegos = false;
    private int precioBase = 300;
    
    //Metodos    
    public FiestaInfantil(int cantidadSorpresas, String tipo, Date fecha, Planificador planificador, Cliente cliente, double precioBase, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales){
        super(tipo, fecha, planificador, cliente, precioBase, estado, duracion, numeroPersonas, elementosAdicionales);
        this.cantidadSorpresas = cantidadSorpresas;
    }

    @Override
    public void mostrarPromociones() {
        System.out.println("Promocion (FiestaInfantil)");    
    }
    

/**
 *
 * @author FERNAN

public class FiestaInfantil extends Evento {

    @Override
    public void mostrarPromociones() {

    } */
}
