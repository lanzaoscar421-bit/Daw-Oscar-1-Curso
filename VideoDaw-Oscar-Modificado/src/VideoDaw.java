import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class VideoDaw {

    private String Cif;
    private String Direccion;
    private String fechaAlta;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String NombreVideo;


    //Contructor
    VideoDaw(String Cif, String Direccion, String NombreVideo) {
        this.Cif = Cif;
        this.Direccion = Direccion;
        this.fechaAlta = LocalDateTime.now().format(dtf);
        this.NombreVideo = NombreVideo;
    }

    //Getter Setter

    public String getCif() {
        return Cif;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public String getNombreVideo() {
        return NombreVideo;
    }


    //Metodos
    @Override
    public String toString() {
        return "===== VideoDaw =====\n" +
                "CIF: " + Cif + "\n" +
                "Dirección: " + Direccion + "\n" +
                "Fecha Alta: " + fechaAlta + "\n" +
                "DTF: " + dtf + "\n" +
                "Nombre Video: " + NombreVideo + "\n" +
                "====================";
    }
}



