
package EventProclass;


import Events.Estado;
import Events.Evento;
import java.util.Date;

public class FiestaInfantil extends Evento{
    
    //Atributos
    private final int pDisfrazados = 0;
    private final int cantidadSorpresas;
    private final boolean juegos;
    
    //Metodos    
    public FiestaInfantil(int cantidadSorpresas, String tipo, Date fecha, Planificador planificador, Cliente cliente, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales, boolean juegos){
        super(tipo, fecha, planificador, cliente, 300, estado, duracion, numeroPersonas, elementosAdicionales);
        this.cantidadSorpresas = cantidadSorpresas;
        this.juegos = juegos;
    }

    public int getpDisfrazados() {
        return pDisfrazados;
    }

    public int getCantidadSorpresas() {
        return cantidadSorpresas;
    }

    public boolean isJuegos() {
        return juegos;
    }

    @Override
    public void mostrarPromociones() {
        System.out.println("Si realizan un próximo evento en las mismas instalaciones"
                + "en un plazo de 6 meses se les otorgará un servicio de música gratuito");    
    }

}
