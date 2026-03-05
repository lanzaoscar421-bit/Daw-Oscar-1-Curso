import java.time.LocalDateTime;
import java.util.List;

public class Heroe extends Personaje{

    private Clase clase;

    public Heroe(String nombre, Rangos rango, Clase clase) {
        super(nombre, rango);
        this.clase = clase;
    }

    public Clase getClase() {
        return clase;
    }

    @Override
    public String toString() {
        return "Heroe{" +
                "clase=" + clase +
                '}';
    }
}
