import java.time.LocalDate;

public class Pelicula extends Articulo{

    private Genero genero;
    private LocalDate fechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String codigo, String titulo, LocalDate fechaAlquiler, LocalDate fechaBaja, Genero genero, LocalDate fechaAlquiler1, boolean isAlquilada) {
        super(codigo, titulo, fechaAlquiler, fechaBaja);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler1;
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
