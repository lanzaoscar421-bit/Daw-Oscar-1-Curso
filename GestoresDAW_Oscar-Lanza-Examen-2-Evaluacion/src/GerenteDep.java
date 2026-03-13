import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GerenteDep extends Trabajador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1956035110466620013L;
    private int numeroTrabajadoresDeP;
    private Departamento gerencia;

    public GerenteDep(String nombre, LocalDate fechNacimiento, String dni, String direccion, String numeroSS, String email, double salario, Departamento departamento, int numeroTrabajadoresDeP) {
        super(nombre, fechNacimiento, dni, direccion, numeroSS, email, salario, departamento);
        this.numeroTrabajadoresDeP = numeroTrabajadoresDeP;
    }

    public int getNumeroTrabajadoresDeP() {
        return numeroTrabajadoresDeP;
    }

    public Departamento getGerencia() {
        return gerencia;
    }

    @Override
    public String toString() {
        return "GerenteDep{" +
                "nombre='" + getNombre() + '\'' +
                ", fechNacimiento=" + getFechNacimiento() +
                ", dni='" + getDni() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", numeroSS='" + getNumeroSS() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", salario=" + getSalario() +
                ", departamento=" + getDepartamento() +
                "numeroTrabajadoresDeP=" + numeroTrabajadoresDeP +
                ", gerencia=" + gerencia +
                '}';
    }
}
