
package EventProclass;

import Events.Estado;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solicitud {
    
    //Atributos
    private int numero;
    private Cliente cliente;
    private int ID;
    private Planificador planificador;
    private Date fechaSolicitud;
    private Date fechaEvento;
    private Estado tipoEstado;
    private ArrayList<Solicitud> solicitudes;
    
    //Metodos    
    //Genera un codigo aleatorio de 4 digitos que no se repite
    Set<Integer> usados = new HashSet<>();    
    private int generarCodigo(){
        boolean aux = false;
        Random x = new Random();
        int codigo = x.nextInt(9999)+1;        
        while(aux==false){
            if(usados.contains(codigo)){
                codigo = x.nextInt(9999)+1;
                aux=false;
            }
            else{
                usados.add(codigo);
                aux=true;
            }
        }
        aux=false;
        
        return codigo;
    }
    
}
