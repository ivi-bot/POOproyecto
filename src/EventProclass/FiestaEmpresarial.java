
package EventProclass;

<<<<<<< HEAD
import Events.Estado;
import Events.Evento;
import java.util.Date;

public class FiestaEmpresarial extends Evento{
    
    //Atributos
    private boolean deseaTransporte;
    private int cantidadPersonas;
    private int precioBase = 2000;
    
    //Metodos
    public FiestaEmpresarial(boolean deseaTransporte, int cantidadPersonas, String tipo, Date fecha, Planificador planificador, Cliente cliente, double precioBase, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales) {
        super(tipo, fecha, planificador, cliente, precioBase, estado, duracion, numeroPersonas, elementosAdicionales);
        this.deseaTransporte = deseaTransporte;
        this.cantidadPersonas = cantidadPersonas;
    }
    
    @Override
    public void mostrarPromociones(){
    System.out.println("Promocion (Fiesta Empresarial)"); 
    }

=======
import Events.Evento;

/**
 *
 * @author FERNAN
 */
public class FiestaEmpresarial extends Evento {


    @Override
    public void mostrarPromociones() {

    }


>>>>>>> d1e21fb83679e9b9a1cbcbafcdb9b76a45a177e9
}
