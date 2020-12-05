package EventProclass;

import java.util.Objects;

public class Opcional {
    private final double precio;
    private final int cantidad;
    private final double valor;
    private final Adicional tipo;
    private final String subtipo;

    public Opcional(double precio, int cantidad, Adicional tipo,String subtipo) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.valor = this.cantidad * this.precio;
    }


    public Opcional(double precio, Adicional tipo, String subtipo) {
        this.tipo = tipo;
        this.cantidad = 1;
        this.precio = precio;
        this.subtipo = subtipo;
        this.valor = this.precio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValor() {
        return valor;
    }

    public Adicional getTipo() {
        return tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }
/**
 * 
 * @return Retorna  informacion del opcional elegido
 */
    @Override
    public String toString() {
        return "precio" + precio +
                ",cantidad" + cantidad +
                "valor" + valor +
                "tipo" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opcional opcional = (Opcional) o;
        return Double.compare(opcional.precio, precio) == 0 &&
                cantidad == opcional.cantidad &&
                Double.compare(opcional.valor, valor) == 0 &&
                tipo == opcional.tipo &&
                Objects.equals(subtipo, opcional.subtipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio, cantidad, valor, tipo, subtipo);
    }

}
