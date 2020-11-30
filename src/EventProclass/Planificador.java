package EventProclass;


import Events.Estado;
import Events.Evento;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author
 */
public class Planificador extends Usuario {
    private List<Evento> eventos;
    private List<Solicitud> solicitudes;
    private List<Factura> ordendepagos;
    //Esta funcion permite consultar todas la solicitudes que tiene cada planificar y no retorna nada.
    public void consultarSolicitudes() {
        System.out.println("/**********************SOLICITUDES PENDIENTES******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        solicitudes.forEach(s -> System.out.println(s.getID() + "- " + s.getEvento().getFecha()));
    }

    public void registrarEvento(int ID) {
        System.out.println("/**********************REGISTRO DE EVENTOS******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        for (Solicitud s : solicitudes) {
            if (s.getID() == ID && s.getPlanificador().getApellido().equals(apellido)) {
                System.out.println("DATOS: ");
                System.out.println("CLIENTE: " + s.getCliente() + "\nPLANIFICADOR ASIGNADO: " + this.getApellido()
                        + " " + this.nombre + "\nFECHA DE REGISTRO:  " + s.getFechaSolicitud() + "\nTIPO DE EVENTO: " + s.getEvento().getTipo()
                        + "\nFECHA DEL EVENTO: " + s.getEvento().getFecha() + "\nPRECIO BASE: " + s.getEvento().getPrecioBase());
                anadirEvento(s.getEvento());
            }else{
                System.out.println("Solicitud No Encontrada!");
            }
        }

    }

    public void confirmarEvento() {
        System.out.println("/**********************CONFIRMAR EVENTO******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        int id;
        System.out.print("Ingrese el id de la orden de pago: ");
        id = sc.nextInt();
        for(Factura odp: ordendepagos){
            if((odp.getId() == id)){
                System.out.print("El pago de este evento se ha realizado el: " + odp.getFechaRegistro());
                System.out.print("Desea aprobar este pago? (S/N): ");
                String o = sc.nextLine();
                if(o.equals("S")){
                    System.out.println("El pago se ha aprobado.");
                    odp.setEstado(Estado.APROBADO);
                    eventos.stream().filter(e -> e.getID() == odp.getCodigoEvento()).forEach(evento -> evento.setEstado(Estado.APROBADO));
                }else{
                    System.out.println("No se ha aprobado el pago!");
                }
            }
        }

    }

    public void consultarEvento() {
        int op, nBoda=0,nEmpre=0,nInfa=0;
        System.out.println("/**********************CONSULTAR EVENTOS******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        System.out.println("TIPOS DE EVENTOS \n1. Boda\n2. Fiesta Infantil \n3. Fiesta Empresarial");
        System.out.print("Elija el tiepo de evnetos que requiere consultar: ");
        op = sc.nextInt();
        for(Evento e: eventos){
            if(e.getPlanificador().getApellido().equals(apellido)){
                if(e instanceof Boda){
                    nBoda++;
                    Boda b = (Boda) e;
                    b.mostrarPromociones();
                } else if (e instanceof FiestaEmpresarial) {
                    nEmpre++;
                    FiestaEmpresarial fe = (FiestaEmpresarial) e;
                    fe.mostrarPromociones();
                }else{
                    nInfa++;
                    FiestaInfantil fi = (FiestaInfantil) e;
                    fi.mostrarPromociones();
                }
            }else
                System.out.println("Evento no encontrado!");
        }
        switch (op){
            case 1:
                //int n = (int) eventos.stream().filter(e -> e.getTipo().equals("Boda")).count();
                System.out.println("\nTiene " + nBoda + "bodas asignadas.\n");
                break;
            case 2:
                System.out.println("\nTiene " + nInfa + "fiestas infantiles asignadas.\n");
                break;
            case 3:
                System.out.println("\nTiene " + nEmpre + "fiestas empresariales asignadas.\n");
                break;
            default:
                System.out.println("Volviendo al Menu...");
                break;
        }

    }

    public void anadirEvento(Evento evento){
        eventos.add(evento);
    }

    public void anadirSolicitud(Solicitud solicitud){
        solicitudes.add(solicitud);
    }

    public void anadirOrdendePago(Factura ordendepago){
        ordendepagos.add(ordendepago);
    }
}
