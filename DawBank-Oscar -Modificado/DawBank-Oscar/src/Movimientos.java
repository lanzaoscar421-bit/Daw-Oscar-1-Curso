
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Movimientos {

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

