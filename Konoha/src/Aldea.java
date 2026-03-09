import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Aldea implements Serializable {

    @Serial
    private static final long serialVersionUID = 8811024307035672149L;
    private String nombreAldea;
    private String codigoAldea;
    private LocalDate fechaCreccion;
    private int maximoEquipos;
    private String kage;
    private List<Equipo> equipos;

    public Aldea(String nombreAldea, String codigoAldea,String kage) {
        this.nombreAldea = nombreAldea;
        this.codigoAldea = codigoAldea;
        this.fechaCreccion = LocalDate.from(LocalDateTime.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.maximoEquipos = 0;
        this.kage = kage;
        this.equipos = new LinkedList<>();
    }




    public String informacionAldea() {
        String info = "";
        info += "===== INFORMACIÓN DE LA Aldea =====\n";
        info += "Nombre: " + this.nombreAldea + "\n";
        info += "Codigo Aldea: " + this.codigoAldea + "\n";
        info += "Fecha creacion: " + this.fechaCreccion + "\n";
        info += "Kage: " + this.kage + "\n";
        info += "--------------------------------------\n";
        return info;
    }
    //Añadir equipo
    public void addEquipo(Equipo equipo){
        equipos.add(equipo);
    }
    //Ver todos los Equipos
    public void verTodosEquipos(){
        for (Equipo equipo : equipos){
            System.out.println(equipo.informacionEquipo());
        }
    }
    //Ver todos los equipos por id
    public void buscarEquipo (String idEquipo){

        for (Equipo equipo :equipos){
            if (equipo.getCodigoEquipo().equalsIgnoreCase(idEquipo)){
                equipo.toString();
            }
        }

    }


}

