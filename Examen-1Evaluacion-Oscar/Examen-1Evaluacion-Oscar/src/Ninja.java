import java.time.LocalDate;

public class Ninja extends Persona {

    private Chakra chakra;
    private Rango rango;
    private String idNinja;
    private String tecnicaSecreta;
    private LocalDate fechAlta;
    private double Ataque;
    private double Defensa;
    private static int contadorNinjas = 0;
    private boolean isAsignado;


    public Ninja (String nombre, String direccion, String dni,LocalDate fechaNacimiento, Chakra chakra, Rango rango, String tecnicaSecreta) {
        super(nombre, direccion, dni, fechaNacimiento);
        this.chakra = chakra;
        this.rango = rango;
        this.idNinja = "N-00"+contadorNinjas;
        contadorNinjas ++;
        this.tecnicaSecreta = tecnicaSecreta;
        this.fechAlta = fechaNacimiento;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.isAsignado = false;
    }


    public Chakra getChakra() {
        return chakra;
    }

    public static int getContadorNinjas() {
        return contadorNinjas;
    }

    public double getDefensa() {
        return Defensa;
    }

    public double getAtaque() {
        return Ataque;
    }

    public LocalDate getFechAlta() {
        return fechAlta;
    }

    public String getTecnicaSecreta() {
        return tecnicaSecreta;
    }

    public String getIdNinja() {
        return idNinja;
    }

    public Rango getRango() {
        return rango;
    }

    public boolean isAsignado(boolean b) {
        return isAsignado;
    }

    //Metodo
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
