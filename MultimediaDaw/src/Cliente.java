import java.io.Serializable;

public class Cliente implements Serializable {


    private static final long serialVersionUID = -4617640573594032412L;
    private String dni;
    private String nombre;
    private int cantidadArticulos;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.cantidadArticulos = cantidadArticulos;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadArticulos=" + cantidadArticulos +
                '}';
    }
}
