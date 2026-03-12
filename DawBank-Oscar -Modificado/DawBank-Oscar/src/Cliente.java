import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = 9202232201750434854L;
    private String telefono;
    private String email;
    private String direccion;

    public Cliente(String nombre, String dni, LocalDate fechaNacimiento, String telefono, String email, String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String  getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "telefono=" + telefono +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
