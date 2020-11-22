package EventProclass;

import java.util.ArrayList;
import java.util.Scanner;

public class Opcional {
    private double precio;
    private int cantidad;
    private double valor;
    private Adicional tipo;

    public static void main(String[] args){
        ArrayList<Integer> opsL = new ArrayList<>();
        opsL.add(1);
        opsL.add(2);
        int i = 3;
        if(opsL.contains(i)){
            System.out.println("No Puede Elegir Esta Opcion De Nuevo");
        }else{
            System.out.println("Desea Llevar? ");
        }

    }

    public void verificarTipo(){
        Scanner sc = new Scanner(System.in);
        double total = 0.00;
        int ops;
        String op = "S";
        while(op.equals("S")){
            System.out.println("/***** REGISTRO DE ELEMENTOS ADICONALES PARA EL EVENTO *****/ \nLas opciones son: \n1. Comida\n" +
                    "2. Bocaditos \n3. Musica \n4. Fotografia \n5. Bebida \n6. Regresar al menu anterior" );
            ops = sc.nextInt();
            switch (ops){
                case 1:
                    //Comida
                    this.precio = 15.0;
                    System.out.println("Elija elemento a adicionar: ");
                    System.out.print("Cantida de platos: ");
                    this.cantidad = sc.nextInt();
                    this.valor = this.cantidad * this.precio;
                    System.out.println("Total: " + this.valor);
                    break;
                case 2:
                    //Bocaditos
                    System.out.println("Cantidad de bocaditos: ");
                    this.cantidad = sc.nextInt();
                    if(this.cantidad < 150)
                        this.precio = 0.25;
                    else
                        this.precio = 0.10;
                    this.valor = this.cantidad * this.precio;
                    System.out.println("Total: " + this.valor);
                    break;
                case 3:
                    //Musica
                    do {
                        System.out.println("Para musica se presentan las opciones de: \n 1. DJ ($300) \n2. Banda Musical ($2000");
                        ops = sc.nextInt();
                    }while(!(ops >= 1 && ops <=2));
                    if (ops == 1)
                        this.valor = 300;
                    else
                        this.valor = 2000;
                    break;
                case 4:
                    //Fotografia
                    System.out.println("Fotografia ($500)");
                    this.valor = 500;

                    break;
                case 5:
                    //Bebida
                    do {
                        System.out.println("Elija el tipo de bebida: \n 1. Wisky ($50) \n2. Vodka ($25) \n3. Cerveza ($3) \n4. Refrescos ($1)");

                        ops = sc.nextInt();
                    }while(!(ops >= 1 && ops <=4));
                    System.out.print("Cantidad: ");
                    this.cantidad = sc.nextInt();
                    if(ops == 1)
                        this.precio = 50.0;
                    else if(ops == 2)
                        this.precio = 25.0;
                    else if (ops == 3)
                        this.precio = 3.0;
                    else
                        this.precio = 1;
                    this.valor = this.precio * this.cantidad;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
            System.out.println("Agregar (S/N)? ");
            op = sc.nextLine().strip();
            if(op.equals("S")){
                total += this.valor;
                System.out.println("Total a pagar: ");
            }
            System.out.println("Desea registrar elementos adicionales (S/N)?");
            op = sc.nextLine().strip();
        }






        sc.close();
    }

}
