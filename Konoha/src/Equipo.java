import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Equipo implements Serializable {


    @Serial
    private static final long serialVersionUID = -7186842677097308792L;
    private String nombreEquipo;
    private String codigoEquipo;
    private LocalDate fechaCreacion;
    private String  sensei;
    private int maximoNinjas;
    private String nuevoNinja;
    private Map<String,Ninja> ninjas;

    public Equipo(String nombreEquipo, String codigoEquipo, String sensei) {

        this.nombreEquipo = nombreEquipo;
        this.codigoEquipo = codigoEquipo;
        this.sensei = sensei;
        this.maximoNinjas = 0;
        this.fechaCreacion = LocalDate.now();
        this.ninjas = new HashMap<>();
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public String informacionEquipo() {
        String info = "";
        info += "===== INFORMACIÓN DEl Equipo =====\n";
        info += "Nombre: " + this.nombreEquipo + "\n";
        info += "Cod: " + this.codigoEquipo + "\n";
        info += "Fecha creacion: " + this.fechaCreacion + "\n";
        info += "Sensei: " + this.sensei + "\n";
        info += "--------------------------------------\n";
        return info;
    }


    //Añadir Ninja
    public void addNinja(Ninja ninja){
        ninjas.put(ninja.getIdNinja(),ninja);
    }
    //Ver todos info de ninjas
}
