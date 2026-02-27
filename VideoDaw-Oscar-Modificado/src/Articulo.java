import java.time.LocalDate;

public class Articulo {

    private String codigo;
    private String titulo;
    private LocalDate fechaAlquiler;
    private LocalDate fechaBaja;

    public Articulo(String codigo, String titulo, LocalDate fechaAlquiler, LocalDate fechaBaja) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaBaja = fechaBaja;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaBaja=" + fechaBaja +
                '}';
    }
}
