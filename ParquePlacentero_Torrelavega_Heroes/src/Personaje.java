import java.time.LocalDate;
import java.time.LocalDateTime;

public class Personaje {

    private String nombre;
    private Rangos rango;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaRetiro;

    public Personaje(String nombre, Rangos rango) {
        this.nombre = nombre;
        this.rango = rango;
        this.fechaCreacion = fechaCreacion;
        this.fechaRetiro = fechaRetiro;
    }

    public String getNombre() {
        return nombre;
    }

    public Personaje setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Rangos getRango() {
        return rango;
    }

    public Personaje setRango(Rangos rango) {
        this.rango = rango;
        return this;
    }

    public LocalDateTime getFechaRetiro() {
        return fechaRetiro;
    }

    public Personaje setFechaRetiro(LocalDateTime fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
        return this;
    }
}
