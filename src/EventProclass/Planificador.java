package EventProclass;

import Events.Estado;
import Events.Evento;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author
 */

public class Planificador extends Usuario {
    private static final SimpleDateFormat dateFormatHora = new SimpleDateFormat("HH:mm");
    private List<Evento> eventos;
    private List<Solicitud> solicitudes;
    private List<Factura> ordendepagos;

    public Planificador(List<Evento> eventos, List<Solicitud> solicitudes, List<Factura> ordendepagos, String nombre, String apellido, String nomUsuario, String contraseña, char tipo) {
        super(nombre, apellido, nomUsuario, contraseña, tipo);
        this.eventos = eventos;
        this.solicitudes = solicitudes;
        this.ordendepagos = ordendepagos;
    }
    
    public Planificador(String nombre, String apellido, String nomUsuario, String contraseña, char tipo){
            super(nombre, apellido, nomUsuario, contraseña, tipo);

    }
    public Planificador(String nombre, String apellido){
                super(nombre, apellido);

    
    
    }
    /**
     * Este metodo permite consultar todas la solicitudes que tiene cada planificar y no retorna nada.
     */
    

    //Esta funcion permite consultar todas la solicitudes que tiene cada planificador y no retorna nada.
    public void consultarSolicitudes() {
        System.out.println("/**********************SOLICITUDES PENDIENTES******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        solicitudes.forEach(s -> System.out.println(s.getID() + " - " +s.getFechaEvento()));
    }
/**
 * 
 * @param ID recibe el codigo de la factura que  previamente fue generado para poder 
 * registrar el evento
 */
  
    //Esta Funcion le permite al planificador registrar un evento que el usuario a solicitado
    public void registrarEvento() {
        System.out.println("Ingrese el id de la solicitud: ");
        int ID = sc.nextInt();
        System.out.println("/**********************REGISTRO DE EVENTOS******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        for (Solicitud s : solicitudes) {
            if (s.getID() == ID) {
                System.out.println("DATOS: ");
                System.out.println("CLIENTE: " + s.getCliente() + "\nPLANIFICADOR ASIGNADO: " + this.getApellido()
                        + " " + this.nombre + "\nFECHA DE REGISTRO:  " + s.getFechaSolicitud() + "\nTIPO DE EVENTO: " + s.getTipoEvento()
                        + "\nFECHA DEL EVENTO: " + s.getFechaEvento() + "\nPRECIO BASE: " + s.getPrecioBase());
                //anadirEvento(s.getEvento());
                System.out.println("\n\n/**********************REGISTRO DE DATOS DEL EVENTOS******"
                        + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                        + "*******************************************/");
                String hIni, hFin;
                int cap;
                System.out.print("Hora Inicio: ");
                hIni = sc.nextLine();
                System.out.print("Hora Fin:");
                hFin = sc.nextLine();
                System.out.print("Capacidad: ");
                cap = sc.nextInt();
                String op;
                System.out.println("Desea registrar elementos adicionales (S/N)?");
                op = sc.nextLine().strip();
                if(op.equals("S")){
                    registrarAdicionales();
                }

                if(s.getTipoEvento().equals("Boda")){
                    System.out.println("Se Registra Los Datos De Boda");
                }else if(s.getTipoEvento().equals("Fiesta Empresarial")){
                    System.out.println("Se Registra Los Datos De La Fiesta Empresarial");
                }else{
                    System.out.println("Se Registra Los Datos De La Fiesta Infantil");
                }

            }else{
                System.out.println("Solicitud No Encontrada!");
            }
        }

    }
/**
 * Método que aprueba el pago o no
 */
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
    /**
     * Permite al planificador visualizar su lista de eventos
     */

    public void consultarEvento() {
        int op, nBoda=0,nEmpre=0,nInfa=0;
        System.out.println("/**********************CONSULTAR EVENTOS******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        System.out.println("TIPOS DE EVENTOS \n1. Boda\n2. Fiesta Infantil \n3. Fiesta Empresarial");
        System.out.print("Elija el tiepo de eventos que requiere consultar: ");
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

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
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

    public void registrarAdicionales(){
        ArrayList<Integer> ops = new ArrayList<>();
        String op = "S";
        int menu;
        double total = 0.00;
        while(op.equals("S")) {
            System.out.println("/** REGISTRO DE ELEMENTOS ADICONALES PARA EL EVENTO **/ \nLas opciones son: \n1. Comida\n" +
                    "2. Bocaditos \n3. Musica \n4. Fotografia \n5. Bebida \n6. Regresar al menu anterior" );
            do{
                System.out.print("Elija elemento a adicionar: ");
                menu = sc.nextInt();
            }while(ops.contains(menu));
            ops.add(menu);
            switch (menu){
                case 1:
                    System.out.print("Cantida de platos: ");
                    int c = sc.nextInt();
                    Opcional o1 = new Opcional(15.00,c,Adicional.BEBIDA);
                    System.out.println(o1.getValor());
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if(op.equals("S"))
                        System.out.println("Se ha agregado su eleccion.");
                        total += o1.getValor();

                    break;
                case 2:
                    System.out.print("Cantida de platos: ");
                    c = sc.nextInt();
                    double p =  c < 150 ? 0.25 : 0.10;
                    Opcional o2 = new Opcional(p,c,Adicional.BOCADITO);
                    System.out.println(o2.getValor());
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if(op.equals("S")) {
                        System.out.println("Se ha agregado su eleccion.");
                        total += o2.getValor();
                    }
                    break;
                case 3:
                    int cont=0;
                    System.out.println("Para musica se presentan las opciones de: \n1. DJ($300) \n2. ($2000)");
                    System.out.println("Que Prefiere?");
                    menu = sc.nextInt();
                    if(menu == 1){
                        p = 300.00;
                    }else{
                        p = 2000.00;
                    }
                    Opcional o3 = new Opcional(p,Adicional.MUSICA);
                    sc.nextLine();
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if(op.equals("S")){
                        System.out.println("Se ha agregado su eleccion.");
                        total += o3.getValor();}
                    if(cont == 0){
                        ops.remove((Integer) 3);
                        cont+=1;
                    }
                    break;
                case 4:
                    //Falta Bebida!
                    break;
                case 5:
                    Opcional o5 = new Opcional(500,Adicional.FOTOGRAFIA);
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if(op.equals("S")){
                        System.out.println("Se ha agregado su eleccion.");
                        total += o5.getValor();}
                    break;
                default:
                    System.out.println("Volviendo al Menu ");
                    break;
            }
            if(menu > 5){
                op = "N";
                ops.clear();
            }else{
                System.out.println("Desea registrar elementos adicionales (S/N)?");
                op = sc.nextLine().strip();
            }
        } //endwhile
    }

}
