import java.time.LocalDate;

public class Sensei extends Ninja {

    public String codigoSensei;
    public double estrategia;
    public double liderazgo;


    public Sensei(String nombre, String numeroContrato, String direccion, String dni, LocalDate fechaNacimiento, Chakra chakra, Rango rango, String tecnicaSecreta, String numeroNinja, String codigoEquipo, double estrategia, double liderazgo) {
        super(nombre, numeroContrato, direccion, dni, fechaNacimiento, chakra, rango, tecnicaSecreta, numeroNinja);
        this.codigoSensei = codigoEquipo;
        this.estrategia = estrategia;
        this.liderazgo = liderazgo;
    }


    public String getCdigoSensei() {
        return codigoSensei;
    }

    public double getLiderazgo() {
        return liderazgo;
    }

    public double getEstrategia() {
        return estrategia;
    }
    //Metodos
    public String informacionSensei() {
        String info = "";
        info += "===== INFORMACIÓN DEL SENSEI =====\n";
        info += "Nombre: " + this.getNombre() + "\n";
        info += "Cod: " + this.codigoSensei + "\n";
        info += "Fecha creacion: " + this.getFechAlta() + "\n";
        info += "Chakra: " + this.getChakra() + "\n";
        info += "direccion: " + this.getDireccion() + "\n";
        info += "tecnica Secreta: " + this.getTecnicaSecreta() + "\n";
        info += "--------------------------------------\n";
        return info;
    }
}

