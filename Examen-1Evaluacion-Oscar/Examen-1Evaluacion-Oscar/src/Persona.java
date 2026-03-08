import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;
    private String numeroContrato;

    public Persona(String nombre, String numeroContrato, String direccion, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.numeroContrato = numeroContrato;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
}
