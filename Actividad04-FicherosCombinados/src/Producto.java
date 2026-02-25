import java.io.Serial;
import java.io.Serializable;

public class Producto implements Serializable {

    @Serial private static final long serialVersionUID = 1928903910574057876L;
    private String Referencia;
    private String Descripcion;
    private String tipo;
    private int Cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean AplicarDto;


    public Producto(String referencia, String descripcion, String tipo, int cantidad, double precio, int descuento, int iva, boolean aplicarDto) {
        this.Referencia = referencia;
        this.Descripcion = descripcion;
        this.tipo = tipo;
        this.Cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.AplicarDto = aplicarDto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Referencia='" + Referencia + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", Cantidad=" + Cantidad +
                ", precio=" + precio +
                ", descuento=" + descuento +
                ", iva=" + iva +
                ", AplicarDto=" + AplicarDto +
                '}';
    }
}
