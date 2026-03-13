import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Director extends Trabajador implements Serializable {

    @Serial
    private static final long serialVersionUID = 2801787128416058566L;
    private String numeroTelefono;
    private String cocheEmpresa;

    public Director(String nombre, LocalDate fechNacimiento, String dni, String direccion, String numeroSS, String email, double salario, Departamento departamento, String numeroTelefono, String cocheEmpresa) {
        super(nombre, fechNacimiento, dni, direccion, numeroSS, email, salario, departamento);
        this.numeroTelefono = numeroTelefono;
        this.cocheEmpresa = cocheEmpresa;
    }


    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCocheEmpresa() {
        return cocheEmpresa;
    }

    @Override
    public String toString() {
        return "Director{" +
                "nombre='" + getNombre() + '\'' +
                ", fechNacimiento=" + getFechNacimiento() +
                ", dni='" + getDni() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", numeroSS='" + getNumeroSS() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", salario=" + getSalario() +
                ", departamento=" + getDepartamento() +
                ", numeroTelefono=" + numeroTelefono +
                ", cocheEmpresa=" + cocheEmpresa +
                '}';
    }
}
