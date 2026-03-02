import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = 6987292209768525570L;
    private String numSocio;
    private LocalDate fechaBaja;
    private String ArticulosAlquilados;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio ) {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.fechaBaja = fechaBaja;
        this.ArticulosAlquilados = ArticulosAlquilados;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public String getArticulosAlquilados() {
        return ArticulosAlquilados;
    }

    public Cliente setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
        return this;
    }

    @Override
    public String toString() {
        return "\n===== Cliente =====" +
                "\nDNI: " + getDni() +
                "\nNombre: " + getNombre() +
                "\nDirección: " + getDireccion() +
                "\nFecha nacimiento: " + getFechaNacimiento() +
                "\nNum. Socio: " + numSocio +
                "\nFecha Baja: " + fechaBaja +
                "\nArtículos alquilados: " + ArticulosAlquilados +
                "\n===================";
    }


}
