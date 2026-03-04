import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = 2801787128416058566L;
    private String dni;
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
