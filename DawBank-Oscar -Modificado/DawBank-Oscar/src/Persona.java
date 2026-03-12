import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = -4133781778175645558L;
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
