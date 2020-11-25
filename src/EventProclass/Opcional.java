package EventProclass;

import java.util.ArrayList;
import java.util.Scanner;

public class Opcional {
    private double precio;
    private int cantidad;
    private double valor;
    private Adicional tipo;

    public Opcional(double precio, int cantidad, Adicional tipo) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.valor = this.cantidad * this.precio;
    }

    public Opcional(double precio, Adicional tio) {
        this.valor = this.precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Adicional getTipo() {
        return tipo;
    }

    public void setTipo(Adicional tipo) {
        this.tipo = tipo;
    }

}
