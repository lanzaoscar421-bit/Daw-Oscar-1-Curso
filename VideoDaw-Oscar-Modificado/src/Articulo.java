import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Articulo implements Serializable {


    @Serial
    private static final long serialVersionUID = -6837796801173722447L;
    private String codigo;
    private String titulo;
    private LocalDateTime fechaAlquiler;
    private LocalDate fechaBaja;
    private Cliente alquilador;

    public Articulo(String codigo, String titulo) {
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

    public Cliente getAlquilador() {
        return alquilador;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setAlquilador(Cliente alquilador) {
        this.alquilador = alquilador;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
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
