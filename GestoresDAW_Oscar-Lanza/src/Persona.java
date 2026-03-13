import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = -7186842677097308792L;
    private String nombre;
    private LocalDate fechNacimiento;
    private String dni;
    private String direccion;

    public Persona(String nombre, LocalDate fechNacimiento, String dni, String direccion) {
        this.nombre = nombre;
        this.fechNacimiento = fechNacimiento;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechNacimiento() {
        return fechNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechNacimiento=" + fechNacimiento +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
