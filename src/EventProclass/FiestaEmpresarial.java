package EventProclass;

import Events.Estado;
import Events.Evento;
import java.util.Date;

public class FiestaEmpresarial extends Evento{
    
    //Atributos
    private final boolean deseaTransporte;
    private final int cantidadPersonas;
    
    //Metodos
    public FiestaEmpresarial(boolean deseaTransporte, int cantidadPersonas, String tipo, Date fecha, Planificador planificador, Cliente cliente, Estado estado, Date duracion, int numeroPersonas, int elementosAdicionales) {
        super(tipo, fecha, planificador, cliente, 2000, estado, duracion, numeroPersonas, elementosAdicionales);
        this.deseaTransporte = deseaTransporte;
        this.cantidadPersonas = cantidadPersonas;
    }

    public boolean getDeseaTransporte() {
        return deseaTransporte;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    @Override
    public void mostrarPromociones(){
    System.out.println("Promocion (Fiesta Empresarial)"); 
    }

}
