import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Trabajador extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 2482708410233042990L;
    private String numeroSS;
    private String email;
    private double salario;
    private Departamento departamento;

    public Trabajador(String nombre, LocalDate fechNacimiento, String dni, String direccion, String numeroSS, String email, double salario, Departamento departamento) {
        super(nombre, fechNacimiento, dni, direccion);
        this.numeroSS = numeroSS;
        this.email = email;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public String getEmail() {
        return email;
    }

    public double getSalario() {
        return salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + getNombre() + '\'' +
                ", fechNacimiento=" + getFechNacimiento() +
                ", dni='" + getDni() + '\'' +
                ", direccion='" + getDni() + '\'' +
                "numeroSS='" + numeroSS + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                ", departamento=" + departamento +
                '}';
    }


}
