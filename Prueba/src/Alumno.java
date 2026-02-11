import java.io.Serial;
import java.io.Serializable;

public class Alumno implements Serializable {

    @Serial
    private static final long serialVersionUID = -1627143938218290622L;

    private String nombre;
    private int apellido;

    public Alumno(String nombre, int apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getApellido() {
        return apellido;
    }

    public void setApellido(int apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido=" + apellido +
                '}';
    }
}
