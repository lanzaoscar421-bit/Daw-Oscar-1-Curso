
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Movimientos {

    private double ingreso;
    private double retirada;
    private int IDmovimiento;
    private LocalDate fecha;// Ponemos local date para la fehca, lo cambiamos desde el principio
    private double Cantidad;
    private String Tipo;
    private static int contador = 0;

    //Constructores
    public Movimientos(double cantidad, String tipo) { //No ponemos arriba ni su Idmovimiento, Fecha ni su Fecha porque no tiene sentido de que el usuario lo modifique
        this.IDmovimiento = contador++;
        this.fecha = LocalDate.now();
        this.Cantidad=cantidad;
        this.Tipo=tipo;
    }

    //Getters-Setters

    public double getingreso() {
        return ingreso; //No setter porque una vez hecho el ingreso no se puede modificar
    }
    public double getretirada() {
        return retirada;//No setter porque una vez hecho la retirada no se puede modificar
    }
    public int getIDmovimiento() {
        return IDmovimiento;
    }
    public LocalDate getfecha() {
        return fecha;
    }
    public double getCantidad(){
        return this.Cantidad;
    }
    public String getTipo(){
        return  this.Tipo;
    }
    //Metodos

    public String InformacionMovimiento(){ //Queremos almacenar tod0 para despues imprimir en el Main
        String Info = "";
        Info+="Cantidad: " + this.Cantidad + "\n";
        Info+="IDmovimiento: " + this.IDmovimiento + "\n";
        Info+="Fecha: " + this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
        Info+="Tipo: " + this.Tipo + "\n";
        return Info;
    }


}

