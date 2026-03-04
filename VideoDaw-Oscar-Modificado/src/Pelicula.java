import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula extends Articulo implements Serializable {


    @Serial
    private static final long serialVersionUID = -4768993991450689188L;
    private Genero genero;
    private LocalDateTime fechaAlquiler;
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
    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    @Override
    public void setFechaBaja(LocalDate fechaBaja) {
        super.setFechaBaja(fechaBaja);
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
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
