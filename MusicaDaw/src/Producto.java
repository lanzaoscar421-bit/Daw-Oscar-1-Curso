import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 3207286476861075642L;
    private String nombre;
    private String calidad;
    private String cod;

    public Producto(String nombre, String calidad) {
        this.nombre = nombre;
        this.calidad = calidad;
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", calidad='" + calidad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        if (false){
            System.out.println("No se puede repetir el id");
        }
        return Objects.equals(cod, producto.cod);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }
}
