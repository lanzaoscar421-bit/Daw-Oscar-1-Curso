import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Locale;

public class Videojuego extends Articulo implements Serializable {


    @Serial
    private static final long serialVersionUID = 5661279320863049138L;
    private GeneroVideoJuego genero;
    private LocalDateTime FechaAlquiler;
    private boolean isAquilida;

    public Videojuego(String codigo, String titulo, GeneroVideoJuego genero, LocalDateTime fechaAlquiler, boolean isAquilida) {
        super(codigo, titulo);
        this.genero = genero;
        FechaAlquiler = fechaAlquiler;
        this.isAquilida = isAquilida;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "genero=" + genero +
                ", FechaAlquiler=" + FechaAlquiler +
                ", isAquilida=" + isAquilida +
                '}';
    }
}
