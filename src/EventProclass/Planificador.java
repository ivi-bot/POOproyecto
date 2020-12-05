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
    private List<Evento> eventos = new ArrayList<>();
    private List<Solicitud> solicitudes = new ArrayList<>();
    private List<Factura> ordendepagos = new ArrayList<>();
    

    public Planificador(List<Evento> eventos, ArrayList<Solicitud> solicitudes, List<Factura> ordendepagos, String nombre, String apellido, String nomUsuario, String contraseña, char tipo) {
        super(nombre, apellido, nomUsuario, contraseña, tipo);
        this.eventos = eventos;
        this.solicitudes = solicitudes;
        this.ordendepagos = ordendepagos;
    }
    
    public Planificador(String nombre, String apellido, String nomUsuario, String contraseña, char tipo){
            super(nombre, apellido, nomUsuario, contraseña, tipo);

    }
     public Planificador(ArrayList<Solicitud> solicitudes,String nombre, String apellido, String nomUsuario, String contraseña, char tipo){
            super(nombre, apellido, nomUsuario, contraseña, tipo);
            this.solicitudes = solicitudes;

    }
    public Planificador(String nombre, String apellido){
        super(nombre, apellido);

    }
    /**
     * Este metodo permite consultar todas la solicitudes que tiene cada planificar y no retorna nada.
     */
        public void consultarSolicitudes() {
        int cont = 1;
        System.out.println("/**********************SOLICITUDES PENDIENTES********"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b\t\t\t\t\t\t\t\t\t\t*/\n/****************"
                + "****************************************************/");
        for(Solicitud s: solicitudes){
            System.out.println(cont + ". " + s.getID() + " - " + s.getFechaEvento());
            cont++;
        }
    }
      public void registrarEvento() {
        System.out.println("Ingrese el id de la solicitud: ");
        Scanner sc2=new Scanner(System.in);
        int ID = sc2.nextInt();
        System.out.println("/**********************REGISTRO DE EVENTOS********"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b\t\t\t\t\t\t\t\t\t\t*/\n/****************"
                + "****************************************************/");
        
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
                hIni = sc2.nextLine();
                System.out.print("Hora Fin:");
                hFin = sc.nextLine();
                System.out.print("Capacidad: ");
                cap = sc2.nextInt();
                String op;
                List<Opcional> elemAdi = this.registrarAdicionales();
                double totalAdi = 0;
                for(Opcional o : elemAdi){
                    totalAdi += o.getValor();
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
                if(o.equalsIgnoreCase("S")){
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

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
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

    public List<Opcional> registrarAdicionales(){
        List<Opcional> elementosAdicionales = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ops = new ArrayList<>();
        String op = "S";
        int menu;
        double total = 0.00;
        while(op.equals("S")) {
            System.out.println("/***** REGISTRO DE ELEMENTOS ADICONALES PARA EL EVENTO *****/ \nLas opciones son: \n1. Comida\n" +
                    "2. Bocaditos \n3. Musica \n4. Bebida  \n5. Fotografia \n6. Regresar al menu anterior\n" );
            System.out.print("Elija elemento a adicionar: ");
            menu = sc.nextInt();
            while(ops.contains(menu)){
                System.out.print("Elija elemento a adicionar: ");
                menu = sc.nextInt();

            }
            System.out.println();
            ops.add(menu);
            String st;
            double pre;
            switch (menu){
                case 1:
                    System.out.print("Cantida de platos: ");
                    int c = sc.nextInt();
                    Opcional o1 = new Opcional(15.00,c,Adicional.COMIDA,"Comidas");
                    System.out.println("Total: " + o1.getValor());
                    sc.nextLine();
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if(op.equals("S")){
                        System.out.println("Se ha agregado su eleccion.");
                        total += o1.getValor();
                        elementosAdicionales.add(o1);
                    }else{
                        ops.remove((Integer) 1);
                    }

                    break;
                case 2:
                    System.out.print("Cantida de bocaditos: ");
                    c = sc.nextInt();
                    double p =  c < 150 ? 0.25 : 0.10;
                    Opcional o2 = new Opcional(p,c,Adicional.BOCADITO,"Bocaditos");
                    System.out.println(o2.getValor());
                    op = sc.nextLine();
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if(op.equals("S")) {
                        System.out.println("Se ha agregado su eleccion.");
                        total += o2.getValor();
                        elementosAdicionales.add(o2);
                    }else{
                        ops.remove((Integer) 2);
                    }
                    break;
                case 3:
                    System.out.println("Para musica se presentan las opciones de: \n1. DJ ($300) \n2. Banda Musical ($2000)");
                    System.out.print("Que Prefiere? ");
                    menu = sc.nextInt();
                    if(menu == 1){
                        pre = 300.00;
                        st = "DJ";
                    }else{
                        pre = 2000.00;
                        st = "Banda";
                    }
                    Opcional o3 = new Opcional(pre,Adicional.MUSICA,st);
                    sc.nextLine();
                    System.out.println("Total: " + o3.getValor());
                    if(elementosAdicionales.size() >= 1 ){
                        for(Opcional o: elementosAdicionales){
                            if(o.equals(o3)){
                                System.out.println("YA HA AGRAGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO");
                                ops.remove((Integer) 3);
                            }
                        }
                    }else{
                        System.out.println("Agregar? (S/N)");
                        op = sc.nextLine();
                        if(op.equals("S")){
                            System.out.println("Se ha agregado su eleccion.");
                            total += o3.getValor();
                            elementosAdicionales.add(o3);
                            ops.remove((Integer) 3);
                        }else{
                            ops.remove((Integer) 3);
                        }
                    }
                    System.out.println(elementosAdicionales);
                    o3 = null;
                    break;
                case 4:
                    System.out.println("Para las bebidas se presentan las opciones de: \n1. Wisky ($50 x1) \n2. Vodka ($25 x1) \n3. Cerveza ($3 x1) \n4. Refrescos");
                    System.out.print("Que Desea Bebida Prefiere? ");
                    menu = sc.nextInt();
                    System.out.print("Cantidad de Bebidas: ");
                    c = sc.nextInt();
                    if(menu == 1){
                        pre = 300.00;
                        st = "Wisky";
                    }else if(menu == 2){
                        pre = 2000.00;
                        st = "Vodka";
                    }else if(menu == 3){
                        pre = 2000.00;
                        st = "Cerveza";
                    }else{
                        pre = 50;
                        st = "Refrescos";
                    }
                    Opcional o4 = new Opcional(pre,c,Adicional.BEBIDA,st);
                    sc.nextLine();
                    System.out.println(o4.getValor());
                    if(elementosAdicionales.size() >= 1){
                        for(Opcional o: elementosAdicionales){
                            if(o.equals(o4)){
                                System.out.println("YA HA AGRAGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO");
                                ops.remove((Integer) 4);
                            }
                        }
                    }else{
                        System.out.println("Desea Agregar? (S/N)");
                        op = sc.nextLine();
                        if(op.equals("S")){
                            System.out.println("Se ha agregado su eleccion.");
                            total += o4.getValor();
                            elementosAdicionales.add(o4);

                        }else{
                            ops.remove((Integer) 4);
                        }
                    }
                    o4 = null;
                    break;
                case 5:
                    sc.nextLine();
                    Opcional o5 = new Opcional(500,Adicional.FOTOGRAFIA,"Fotografias y PhotoShots");
                    System.out.println("Se dispone de los mejores fotografos para una major experiencia");
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if(op.equals("S")){
                        System.out.println("Se ha agregado su eleccion.");
                        total += o5.getValor();
                        elementosAdicionales.add(o5);

                    }else{
                        ops.remove((Integer) 5);
                    }
                    break;
                default:
                    System.out.println("Volviendo al Menu ");
                    break;
            }
            if(menu > 5){
                op = "N";
                System.out.println("El Total A Pagar Es: " + total);
                ops.clear();
            }else{
                System.out.println("El Total A Pagar Es: " + total);
                System.out.println("Desea registrar elementos adicionales (S/N)?");
                op = sc.nextLine().strip();
            }
        } //endwhile
        System.out.println("El Total A Pagar Es: " + total);
        sc.close();
        return elementosAdicionales;
    }

}
