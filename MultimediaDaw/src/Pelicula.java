import java.io.Serializable;

public class Pelicula extends Articulo implements Serializable {


    private static final long serialVersionUID = 6037712432852829433L;
    private double duracion;
    private Genero genero;
    private double precioFijo;

    public Pelicula(String id, String titulo, double duracion, Genero genero) {
        super(id, titulo);
        this.duracion = duracion;
        this.genero = genero;
        this.precioFijo = precioFijo;
    }

    public double getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public double getPrecioFijo() {
        return precioFijo;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setPrecioFijo(double precioFijo) {
        this.precioFijo = precioFijo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "duracion=" + duracion +
                ", genero=" + genero +
                ", precioFijo=" + precioFijo +
                '}';
    }
}
