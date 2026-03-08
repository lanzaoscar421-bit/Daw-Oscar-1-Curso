import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = 1956035110466620013L;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;
    private String numeroContrato;

    public Persona(String nombre, String direccion, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.numeroContrato = numeroContrato;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
