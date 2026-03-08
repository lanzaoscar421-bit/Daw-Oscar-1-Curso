import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Ninja extends Persona implements Serializable {


    @Serial
    private static final long serialVersionUID = 2482708410233042990L;
    private Chakra chakra;
    private Rango rango;
    private String idNinja;
    private String tecnicaSecreta;
    private LocalDate fechAlta;
    private double Ataque;
    private double Defensa;
    private boolean isAsignado;


    public Ninja(String nombre, String direccion, LocalDate fechaNacimiento, Chakra chakra, Rango rango, String idNinja, String tecnicaSecreta,double ataque, double defensa) {
        super(nombre, direccion, fechaNacimiento);
        this.chakra = chakra;
        this.rango = rango;
        this.idNinja = idNinja;
        this.tecnicaSecreta = tecnicaSecreta;
        this.fechAlta = LocalDate.now();
        Ataque = ataque;
        Defensa = defensa;
        this.isAsignado = isAsignado;
    }

    public String getIdNinja() {
        return idNinja;
    }

    public String informacionNinja() {
        String info = "";
        info += "===== INFORMACIÓN DE Ninja =====\n";
        info += "Nombre: " + this.getNombre() + "\n";
        info += "Cod: " + this.idNinja + "\n";
        info += "Fecha creacion: " + this.fechAlta + "\n";
        info += "Chakra: " + this.chakra + "\n";
        info += "direccion: " + this.getDireccion() + "\n";
        info += "tecnica Secreta: " + this.tecnicaSecreta + "\n";
        info += "Tiene equipo: " + this.isAsignado + "\n";
        info += "--------------------------------------\n";
        return info;
    }
}
