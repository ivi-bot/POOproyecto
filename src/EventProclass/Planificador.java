package EventProclass;

import Archivos.Archivo;
import Events.Estado;
import Events.Evento;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author
 */
public class Planificador extends Usuario {

    private static final SimpleDateFormat dateFormatHora = new SimpleDateFormat("HH:mm");
    private List<String> eventos = Archivo.LeeFichero("solicitudesTipoEvento.txt");
    private List<String> solicitudes = Archivo.LeeFichero("solicitudes.txt");
    private List<Factura> ordendepagos = new ArrayList<>();
    private List<Solicitud> solicitudes1 = new ArrayList<>();

    public Planificador(List<String> eventos, ArrayList<String> solicitudes, List<Factura> ordendepagos, String nombre, String apellido, String nomUsuario, String contraseña, char tipo) {
        super(nombre, apellido, nomUsuario, contraseña, tipo);
        this.eventos = eventos;
        this.solicitudes = solicitudes;
        this.ordendepagos = ordendepagos;
    }

    public Planificador(String nombre, String apellido, String nomUsuario, String contraseña, char tipo) {
        super(nombre, apellido, nomUsuario, contraseña, tipo);

    }

    public Planificador(String nombre, String apellido) {
        super(nombre, apellido);

    }

    /**
     * Este metodo permite consultar todas la solicitudes que tiene cada
     * planificar y no retorna nada.
     */
    public void consultarSolicitudes(String nombre1) {
        System.out.println("/**********************SOLICITUDES PENDIENTES********"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b\t\t\t\t\t\t\t\t\t\t*/\n/****************"
                + "****************************************************/");

        solicitudes = Archivo.LeeFichero("solicitudes.txt");
        List<String> imprimirCodigo = new ArrayList<>();
        List<String> imprimirFecha = new ArrayList<>();

        for (int i = 0; i < solicitudes.size(); i++) {
            String[] datos = solicitudes.get(i).split(",");
            if (datos[2].equalsIgnoreCase(nombre1)) {
                imprimirCodigo.add(datos[0]);
                imprimirFecha.add(datos[4]);
            }
        }

        if (imprimirCodigo.size() != 0) {
            System.out.println("Tiene " + imprimirCodigo.size() + " solicitudes pendientes");
            for (int i = 0; i < imprimirCodigo.size(); i++) {
                System.out.println(i + 1 + ". " + imprimirCodigo.get(i) + " - " + imprimirFecha.get(i));
            }
        }
    }

    /**
     *
     * ID de La Solictud recibe el codigo de la factura que previamente fue
     * generado para poder registrar el evento
     */
    //Esta Funcion le permite al planificador registrar un evento que el usuario a solicitado
    public void registrarEvento(String nombre3) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id de la solicitud: ");
        String ID = sc.nextLine();
        System.out.println("/*******REGISTRO DE EVENTOS***"
                + "*****/\n/\t\t\t\t\t\t\t\t\t\b\b\t\t\t\t\t\t\t\t\t\t*/\n/******"
                + "******************/");
        eventos = Archivo.LeeFichero("solicitudesTipoEvento.txt");
        List<String> imprimirCodigo = new ArrayList<>();
        List<String> nombreU = new ArrayList<>();
        List<String> nombreP = new ArrayList<>();
        List<String> fecha1 = new ArrayList<>();
        List<String> tipo = new ArrayList<>();
        List<String> fecha2 = new ArrayList<>();
        List<String> precio = new ArrayList<>();
        for (int i = 0; i < eventos.size(); i++) {
            String[] datos = eventos.get(i).split(",");
            imprimirCodigo.add(datos[0]);
            nombreU.add(datos[1]);
            nombreP.add(datos[2]);
            fecha1.add(datos[3]);
            tipo.add(datos[4]);
            fecha2.add(datos[5]);
            precio.add(datos[6]);
        }
        int indiceEvento = imprimirCodigo.indexOf(ID);
        System.out.println("DATOS:\n" + "CLIENTE: " + nombreU.get(indiceEvento) + "\n" + "PLANIFICADOR ASIGNADO: " + nombreP.get(indiceEvento) + "\n"
                + "FECHA DE REGISTRO: " + fecha1.get(indiceEvento) + "\n"
                + "TIPO EVENTO: " + tipo.get(indiceEvento) + "\n"
                + "FECHA DEL EVENTO: " + fecha2.get(indiceEvento) + "\n" + "PRECIO BASE: " + precio.get(indiceEvento));
        //CREAR OBJETOS 
        Factura factura = new Factura(Integer.parseInt(imprimirCodigo.get(indiceEvento)), fecha1.get(indiceEvento));
        Cliente cliente = new Cliente(nombreU.get(indiceEvento));
        Solicitud s = new Solicitud(cliente, nombreP.get(indiceEvento), tipo.get(indiceEvento), fecha1.get(indiceEvento), fecha2.get(indiceEvento), Integer.parseInt(imprimirCodigo.get(indiceEvento)));
        Evento e=new Evento(tipo.get(indiceEvento),fecha2.get(indiceEvento));
        solicitudes1.add(s);
        System.out.println("\n\n/*******REGISTRO DE DATOS DEL EVENTOS***"
                + "*****/\n/\t\t\t\t\t\t\t\t\t\b\b*/\n/******"
                + "***************/");
        String hIni, hFin;
        int cap;
        System.out.print("Hora Inicio: ");
        hIni = sc.nextLine();
        System.out.print("Hora Fin:");
        hFin = sc.nextLine();
        System.out.print("Capacidad: ");
        cap = sc.nextInt();
        System.out.print("¿Desea registrar elementos adicionales (S/N)? ");
        String opcion = sc.nextLine();
        ArrayList<String> opcionesV0 = new ArrayList<>();
        opcionesV0.add("S");
        opcionesV0.add("N");
        opcionesV0.add("s");
        opcionesV0.add("n");
        while (!opcionesV0.contains(opcion)) {
            System.out.print("Escriba una opcion correcta:");
            opcion = sc.nextLine();
        }
        if (opcion.equalsIgnoreCase("S")) {
            registrarAdicionales();
            int codigo = (int) (Math.random() * 9999 + 1);
            Adicional tipo1;
            int cantidad;
            double precio1;
            double total;
            for (int i = 0; i < registrarAdicionales().size(); i++) {
                tipo1 = registrarAdicionales().get(i).getTipo();
                cantidad = registrarAdicionales().get(i).getCantidad();
                precio1 = registrarAdicionales().get(i).getPrecio();
                total = registrarAdicionales().get(i).getValor();
                Archivo.EscribirArchivo("adicionales.txt", codigo + "," + tipo1 + "," + cantidad + "," + precio1 + "," + total);
            }
            //  Archivo.EscribirArchivo("src/Archivos/adicionales.txt",codigo+","+tipo1 );
            Archivo.EscribirArchivo("eventos.txt", s.getID() + "," + nombreU.get(indiceEvento) + "," + nombreP.get(indiceEvento) + "," + s.getFechaSolicitudS() + "," + s.getFechaEventoS() + "," + "APROBADA");
          //  Cliente c, ArrayList<Opcional> elementosAdicionales, Evento e
            factura.mostrarOrdendePago(cliente, registrarAdicionales(), e);
        } else {
            System.out.println("Gracias");
        }
//        String op;
//        List<Opcional> elemAdi = this.registrarAdicionales();
//        double totalAdi = 0;
//        for (Opcional o : elemAdi) {
//            totalAdi += o.getValor();
//            Archivo.EscribirArchivo("src/Archivos/adicionales.txt", o.toString());
//        }

//        if (solicitudes1.size() >= 1) {
//            for (Solicitud s1 : solicitudes1) {
//                if (s1.getID() == ID) {
//                    System.out.println("DATOS: ");
//                    System.out.println("CLIENTE: " + s.getCliente() + "\nPLANIFICADOR ASIGNADO: " + this.getApellido()
//                            + " " + this.nombre + "\nFECHA DE REGISTRO:  " + s.getFechaSolicitud() + "\nTIPO DE EVENTO: " + s.getTipoEvento()
//                            + "\nFECHA DEL EVENTO: " + s.getFechaEvento() + "\nPRECIO BASE: " + s.getPrecioBase());
//                    //anadirEvento(s.getEvento());
//                    System.out.println("\n\n/*******REGISTRO DE DATOS DEL EVENTOS***"
//                            + "*****/\n/\t\t\t\t\t\t\t\t\t\b\b*/\n/******"
//                            + "***************/");
//                    String hIni, hFin;
//                    int cap;
//                    System.out.print("Hora Inicio: ");
//                    hIni = sc.nextLine();
//                    System.out.print("Hora Fin:");
//                    hFin = sc.nextLine();
//                    System.out.print("Capacidad: ");
//                    cap = sc.nextInt();
//                    String op;
//                    List<Opcional> elemAdi = this.registrarAdicionales();
//                    double totalAdi = 0;
//                    for (Opcional o : elemAdi) {
//                        totalAdi += o.getValor();
//                        Archivo.EscribirArchivo("src/Archivos/adicionales.txt", o.toString());
//                    }
//                    double costototal = totalAdi + s.getPrecioBase();
//                    System.out.println("El costo totol de evento sera: " + costototal + "dolares.");
//                    s.setEstadoSolicitud(Estado.APROBADO);
//                    Evento e;
//                    if (s.getTipoEvento().equals("Boda")) {
//                        e = registrarBoda(s.getCliente(), s.getPlanificador(), s.getFechaEvento(), s.getFechaSolicitud(), s.getTipoEvento(), cap);
//                    } else if (s.getTipoEvento().equals("Fiesta Empresarial")) {
//                        e = registraFiestaEmpresarial(s.getCliente(), s.getPlanificador(), s.getFechaEvento(), s.getFechaSolicitud(), s.getTipoEvento(), cap);
//                    } else {
//                        e = registraFiestaInfantil(s.getCliente(), s.getPlanificador(), s.getFechaEvento(), s.getFechaSolicitud(), s.getTipoEvento(), cap);
//                    }
////                    anadirEvento(e);
//                    Factura odp = new Factura(s.getNumero(), e.getID(), costototal, Estado.PENDIENTE, s.getID(), new Date());
//                    String linea = e.getID() + "," + s.getCliente().getNombre() + "," + e.getTipo() + "," + e.getFechaEvento() + "," + hIni + "," + hFin + "," + cap + "," + this.apellido + "," + e.getEstado();
//                    Archivo.EscribirArchivo("src/Archivos/eventos.txt", linea);
//                }
//            }//endfor
//        } else {
//            System.out.println("Usted No Tiene Solicitudes");
//        }
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
        Scanner sc3 = new Scanner(System.in);
        id = sc3.nextInt();
        sc3.nextLine();
        eventos = Archivo.LeeFichero("solicitudesTipoEvento.txt");
        List<String> imprimirCodigo = new ArrayList<>();
        List<String> fecha1 = new ArrayList<>();
        for (int i = 0; i < eventos.size(); i++) {
            String[] datos = eventos.get(i).split(",");
            imprimirCodigo.add(datos[0]);
            fecha1.add(datos[3]);
        }
        int indiceEvento = imprimirCodigo.indexOf(String.valueOf(id));
        //    int codigoPago, int codigoEvento, double totalPagar, Estado estado, Date fechaRegistro
        Factura factura = new Factura(Integer.parseInt(imprimirCodigo.get(indiceEvento)), fecha1.get(indiceEvento));
        ordendepagos.add(factura);
        if (ordendepagos.size() >= 1) {
            for (Factura odp : ordendepagos) {
                System.out.println("El pago de este evento se ha realizado el: " + odp.getFechaFactura());
                System.out.print("Desea aprobar este pago? (S/N): ");
                String o = sc3.nextLine();
                if (o.equalsIgnoreCase("S")) {
                    System.out.println("El pago se ha aprobado.");
                    odp.setEstado(Estado.APROBADO);
                } else {
                    System.out.println("No se ha aprobado el pago!");
                }
            }
        } else {
            System.out.println("Usted No Tiene facturas");
        }
    }

    /**
     * Permite al planificador visualizar su lista de eventos
     */
    public void consultarEvento() {
        int op, nBoda = 0, nEmpre = 0, nInfa = 0;
        System.out.println("/**********************CONSULTAR EVENTOS******"
                + "****************/\n/*\t\t\t\t\t\t\t\t\t\b\b*/\n/****************"
                + "*******************************************/");
        System.out.println("TIPOS DE EVENTOS \n1. Boda\n2. Fiesta Infantil \n3. Fiesta Empresarial");
        System.out.print("Elija el tipo de eventos que requiere consultar: ");
        Scanner sc4 = new Scanner(System.in);
        op = sc4.nextInt();

        eventos = Archivo.LeeFichero("solicitudesTipoEvento.txt");
        List<String> imprimirCodigo = new ArrayList<>();
        List<String> fecha1 = new ArrayList<>();
        for (int i = 0; i < eventos.size(); i++) {
            String[] datos = eventos.get(i).split(",");
            imprimirCodigo.add(datos[0]);
            fecha1.add(datos[3]);
        }

        if (eventos.size() >= 1) {
            for (Evento e : eventos) {
                if (e.getPlanificador().getApellido().equals(apellido)) {
                    if (e instanceof Boda) {
                        nBoda++;
                        Boda b = (Boda) e;
                        b.mostrarPromociones();
                    } else if (e instanceof FiestaEmpresarial) {
                        nEmpre++;
                        FiestaEmpresarial fe = (FiestaEmpresarial) e;
                        fe.mostrarPromociones();
                    } else {
                        nInfa++;
                        FiestaInfantil fi = (FiestaInfantil) e;
                        fi.mostrarPromociones();
                    }
                } else {
                    System.out.println("Evento no encontrado!");
                }

            }
        } else {
            System.out.println("Usted No Tiene eventos");
            switch (op) {
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
    }

    public List<String> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<String> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void anadirEvento(String evento) {
        eventos.add(evento);
    }

    public void anadirSolicitud(String solicitud) {

        solicitudes.add(solicitud);
    }

    public void anadirOrdendePago(Factura ordendepago) {
        ordendepagos.add(ordendepago);
    }

    public ArrayList<Opcional> registrarAdicionales() {
        ArrayList<Opcional> elementosAdicionales = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ops = new ArrayList<>();
        int menu;
        double total = 0.00;
        System.out.println("/***** REGISTRO DE ELEMENTOS ADICONALES PARA EL EVENTO *****/ \nLas opciones son: \n1. Comida\n"
                + "2. Bocaditos \n3. Musica \n4. Bebida  \n5. Fotografia \n6. Regresar al menu anterior\n");
        System.out.print("Elija elemento a adicionar: ");
        menu = sc.nextInt();
        String op;
        while (ops.contains(menu)) {
            System.out.print("Elija elemento a adicionar: ");
            menu = sc.nextInt();
        }
        System.out.println();
        ops.add(menu);
        String st;
        double pre;
        switch (menu) {
            case 1:
                System.out.print("Cantida de platos: ");
                int c = sc.nextInt();
                Opcional o1 = new Opcional(15.00, c, Adicional.COMIDA, "Comidas");
                System.out.println("Total: " + o1.getValor());
                sc.nextLine();
                System.out.print("Agregar? (S/N)");
                op = sc.nextLine();
                if (op.equalsIgnoreCase("S")) {
                    System.out.println("Se ha agregado su eleccion.");
                    total += o1.getValor();
                    elementosAdicionales.add(o1);
                } else {
                    ops.remove((Integer) 1);
                }

                break;
            case 2:
                System.out.print("Cantida de bocaditos: ");
                c = sc.nextInt();
                double p = c < 150 ? 0.25 : 0.10;
                Opcional o2 = new Opcional(p, c, Adicional.BOCADITO, "Bocaditos");
                System.out.println(o2.getValor());
                op = sc.nextLine();
                System.out.println("Agregar? (S/N)");
                op = sc.nextLine();
                if (op.equals("S")) {
                    System.out.println("Se ha agregado su eleccion.");
                    total += o2.getValor();
                    elementosAdicionales.add(o2);
                } else {
                    ops.remove((Integer) 2);
                }
                break;
            case 3:
                System.out.println("Para musica se presentan las opciones de: \n1. DJ ($300) \n2. Banda Musical ($2000)");
                System.out.print("Que Prefiere? ");
                menu = sc.nextInt();
                if (menu == 1) {
                    pre = 300.00;
                    st = "DJ";
                } else {
                    pre = 2000.00;
                    st = "Banda";
                }
                Opcional o3 = new Opcional(pre, Adicional.MUSICA, st);
                sc.nextLine();
                total += o3.getValor();

                System.out.println("Total: " + o3.getValor());
                if (elementosAdicionales.size() >= 1) {
                    for (Opcional o : elementosAdicionales) {
                        if (o.equals(o3)) {
                            System.out.println("YA HA AGRAGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO");
                            ops.remove((Integer) 3);
                        }
                    }
                } else {
                    System.out.println("Agregar? (S/N)");
                    op = sc.nextLine();
                    if (op.equalsIgnoreCase("S")) {
                        System.out.println("Se ha agregado su eleccion.");
                        total += o3.getValor();
                        elementosAdicionales.add(o3);
                        ops.remove((Integer) 3);
                    } else {
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
                if (menu == 1) {
                    pre = 300.00;
                    st = "Wisky";
                } else if (menu == 2) {
                    pre = 2000.00;
                    st = "Vodka";
                } else if (menu == 3) {
                    pre = 2000.00;
                    st = "Cerveza";
                } else {
                    pre = 50;
                    st = "Refrescos";
                }
                Opcional o4 = new Opcional(pre, c, Adicional.BEBIDA, st);
                sc.nextLine();

                System.out.println(o4.getValor());
                if (elementosAdicionales.size() >= 1) {
                    for (Opcional o : elementosAdicionales) {
                        if (o.equals(o4)) {
                            System.out.println("YA HA AGRAGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO");
                            ops.remove((Integer) 4);
                        }
                    }
                } else {
                    System.out.println("Desea Agregar? (S/N)");
                    op = sc.nextLine();
                    if (op.equalsIgnoreCase("S")) {
                        System.out.println("Se ha agregado su eleccion.");
                        total += o4.getValor();
                        elementosAdicionales.add(o4);

                    } else {
                        ops.remove((Integer) 4);
                    }
                }
                o4 = null;
                break;
            case 5:
                sc.nextLine();
                Opcional o5 = new Opcional(500, Adicional.FOTOGRAFIA, "Fotografias y PhotoShots");
                System.out.println("Se dispone de los mejores fotografos para una major experiencia");
                System.out.println("Agregar? (S/N)");
                op = sc.nextLine();
                if (op.equalsIgnoreCase("S")) {
                    System.out.println("Se ha agregado su eleccion.");
                    total += o5.getValor();
                    elementosAdicionales.add(o5);

                } else {
                    ops.remove((Integer) 5);
                }
                break;
            default:
                System.out.println("Volviendo al Menu ");
                break;
        }
        if (menu > 5) {
            op = "N";
            System.out.println("El Total A Pagar Es: " + total);
            ops.clear();
        } else {
            System.out.println("El Total A Pagar Es: " + total);
            System.out.println("Desea registrar elementos adicionales (S/N)?");
            op = sc.nextLine().strip();

        }
        //endwhile
        System.out.println("El Total A Pagar Es: " + total);
        return elementosAdicionales;
    }

    public static Evento registrarBoda(Cliente c, Planificador p, Date fechaEvento, Date duraccion, String tipo, int capacidad) {
        String op;
        Scanner sc = new Scanner(System.in);
        String vehiTipo;
        System.out.println("Se Registra Los Datos De La Boda: ");
        System.out.println("Agregar Vehiculo? (S/N)");
        op = sc.nextLine();
        if (op.equals("S")) {
            System.out.print("Ingrese Tipo Vehiculo: ");
            vehiTipo = sc.nextLine();
        } else {
            vehiTipo = "NO APLICA";
        }
        Evento e = new Boda(vehiTipo, tipo, fechaEvento, p, c, Estado.PENDIENTE, duraccion, capacidad);
        return e;

    }

    public static Evento registraFiestaInfantil(Cliente c, Planificador p, Date fechaEvento, Date duraccion, String tipo, int capacidad) {
        Scanner sc = new Scanner(System.in);
        int cantDis, cantSor;
        String opc;
        boolean juegos;
        System.out.println("Se Registra Los Datos De La Fiesta Infantil: ");
        System.out.println("Desea Agregar Personajes Difrasados? (S/N)");
        opc = sc.nextLine();
        if (opc.equals("S")) {
            System.out.println("Cantidad de Personajes Disfrasados: ");
            cantDis = sc.nextInt();
        } else {
            cantDis = 0;
        }
        sc.nextLine();
        //Ingresar Si Desea Juegos
        System.out.println("Desea Tener Juegos En La Fiesta? (S/N)");
        opc = sc.nextLine();
        juegos = opc.equals("S");
        System.out.println("Cantidad de Sorpresas: ");
        cantSor = sc.nextInt();
        sc.nextLine();
        Evento e = new FiestaInfantil(cantSor, tipo, fechaEvento, p, c, Estado.PENDIENTE, duraccion, capacidad, juegos);
        sc.close();
        return e;
    }

    public static Evento registraFiestaEmpresarial(Cliente c, Planificador p, Date fechaEvento, Date duraccion, String tipo, int capacidad) {
        Scanner sc = new Scanner(System.in);
        String o;
        int cantPasajeros;
        boolean transporte;
        System.out.println("Se Registra Los Datos De La Fiesta Infantil: ");
        System.out.println("Desea Transporte? (S/N)");
        o = sc.nextLine();
        if (o.equals("S")) {
            transporte = true;
            System.out.println("Cantidad de Pasajeros: ");
            cantPasajeros = sc.nextInt();
        } else {
            transporte = false;
            cantPasajeros = 0;
        }
        Evento e = new FiestaEmpresarial(transporte, cantPasajeros, tipo, fechaEvento, p, c, Estado.PENDIENTE, duraccion, capacidad);
        sc.close();
        return e;
    }

}
