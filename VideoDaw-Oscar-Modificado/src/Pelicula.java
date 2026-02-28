import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Pelicula extends Articulo implements Serializable {

    @Serial
    private static final long serialVersionUID = 6340542229054207743L;
    private Genero genero;
    private LocalDate fechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String codigo, String titulo, Genero genero) {
        super(codigo, titulo);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    @Override
    public String toString() {
        return "\n===== Pelicula =====" +
                "\nCódigo: " + getCodigo() +
                "\nTítulo: " + getTitulo() +
                "\nFecha Alta: " + getFechaAlquiler() +
                "\nFecha Baja: " + getFechaBaja() +
                "\nGénero: " + genero +
                "\nFecha Alquiler: " + fechaAlquiler +
                "\nAlquilada: " + (isAlquilada ? "Sí" : "No") +
                "\n===================";
    }
}
