import java.time.LocalDate;

public class Mision {

    private String nombre;
    private Dificultad dificultad;
    private Heroe heroeAsignado;
    private LocalDate fechaInicio;

    public Mision(String nombre, Dificultad dificultad, Heroe heroeAsignado, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.heroeAsignado = heroeAsignado;
        this.fechaInicio = fechaInicio;
    }

    public Mision setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Mision setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
        return this;
    }

    public Mision setHeroeAsignado(Heroe heroeAsignado) {
        this.heroeAsignado = heroeAsignado;
        return this;
    }

    public Mision setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }
}
