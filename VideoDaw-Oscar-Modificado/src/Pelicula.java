import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Pelicula {
    //Atributos

    private static int contadorPeliculas = 1;
    private String Cod;
    private String Titulo;
    private Genero Genero;
    private String Fecha;
    private LocalDate Fechabaja;
    private LocalDateTime FechaAlquiler;
    private boolean Isalquilada;
    private String  dtf = "dd-MM-yyyy HH:mm:ss";
    private String df = "dd-MM-yyyy";


    //Constructores
    public Pelicula(String titulo, Genero genero) {
        this.Cod = String.format("P-%03d", contadorPeliculas);
        contadorPeliculas++;

        this.Titulo = titulo;
        this.Genero = genero;
        this.Fecha = LocalDate.now().toString();
        this.Fechabaja = null;
        this.FechaAlquiler = null;
        this.Isalquilada = false;
    }


    //Getters-Setters


    public static int getContadorPeliculas() {
        return contadorPeliculas;
    }

    public String getCod() {
        return Cod;
    }

    public String getTitulo() {
        return Titulo;
    }

    public Genero getGenero() {
        return Genero;
    }

    public String getFecha() {
        return Fecha;
    }

    public LocalDate getFechabaja() {
        return Fechabaja;
    }

    public void setFechabaja(LocalDate fechabaja) {
        Fechabaja = fechabaja;
    }

    public LocalDateTime getFechaAlquiler() {
        return FechaAlquiler;
    }

    public boolean isIsalquilada() {
        return Isalquilada;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setGenero(Genero genero) {
        Genero = genero;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public void setIsalquilada(boolean isalquilada) {
        Isalquilada = isalquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        FechaAlquiler = fechaAlquiler;
    }

    public String infopeli() {
        String fechas="Fecha Baja:     \n";
        String fechas2="Fecha Alquiler:     \n";
        if (this.Fechabaja != null){
            fechas = "Fecha baja:      " + DateTimeFormatter.ofPattern(df).format(this.Fechabaja) + "\n";
        }
        if ( this.FechaAlquiler != null){
            fechas2 =  DateTimeFormatter.ofPattern(dtf).format(this.FechaAlquiler) + "\n";
        }
        return  "--------- Información de la Película ---------\n" +
                "Código:          " + this.Cod + "\n" +
                "Título:          " + this.Titulo + "\n" +
                "Género:          " + this.Genero + "\n" +
                "Fecha alta:      " + this.Fecha + "\n" +
                fechas +
                fechas2 +
                "Alquilada?:     " + this.Isalquilada + "\n" +
                "------------------------------------------------";
    }



}
