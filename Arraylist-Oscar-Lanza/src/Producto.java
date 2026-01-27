import java.util.Collections;
import java.util.Comparator;

public class Producto implements Comparable<Producto> {

    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }


    @Override
    public int compareTo(Producto o) {

        if(o != null) {
            return this.nombre.compareToIgnoreCase(o.nombre);
        }

        return 1;
    }
}
