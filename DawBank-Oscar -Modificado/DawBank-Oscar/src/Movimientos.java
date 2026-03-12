
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Movimientos implements Serializable {


    @Serial
    private static final long serialVersionUID = 1214428286972484478L;
    private int IDmovimiento;
    private LocalDateTime fecha;
    private double Cantidad;
    private String Tipo;
    private static int contador = 0;

    //Constructores
    public Movimientos(double cantidad, String tipo) {
        this.IDmovimiento = contador++;
        this.fecha = LocalDate.now().atStartOfDay();
        this.Cantidad=cantidad;
        this.Tipo=tipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    //Metodos

    @Override
    public String toString() {
        return "Movimientos{" +
                "IDmovimiento=" + IDmovimiento +
                ", fecha=" + fecha +
                ", Cantidad=" + Cantidad +
                ", Tipo='" + Tipo + '\'' +
                '}';
    }

}

