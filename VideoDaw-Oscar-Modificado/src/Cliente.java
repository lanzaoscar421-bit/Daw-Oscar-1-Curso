import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = 7241247393840882058L;
    private String numSocio;
    private LocalDate fechaBaja;
    private List <Pelicula> peliculasAlquilas;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio ) {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.fechaBaja = null;
        this.peliculasAlquilas = new ArrayList<>();
    }

    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public List<Pelicula> getPeliculasAlquilas() {
        return peliculasAlquilas;
    }

    public Cliente setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
        return this;
    }


    public void setPeliculasAlquilas(List<Pelicula> peliculasAlquilas) {
        this.peliculasAlquilas = peliculasAlquilas;
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
                "\nArtículos alquilados: " + peliculasAlquilas +
                "\n===================";
    }


}
