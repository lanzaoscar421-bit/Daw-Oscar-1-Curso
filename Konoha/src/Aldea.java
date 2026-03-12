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




    @Override
    public String toString() {
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
            System.out.println(equipo);
        }
    }
    //Ver todos los equipos por id

    public  boolean buscarEquipoid(Equipo idEquipo){



        for (Equipo equipo : equipos){
            if (equipo.getCodigoEquipo().equals(idEquipo.getCodigoEquipo())){
                System.out.println(equipo);
                return true;
            }
        }

        System.out.println("Equipo no exsiste");
        return  false;
    }

    public Equipo buscarEquipo (String idEquipo){
        for (Equipo equipo : equipos) {
            if (equipo.getCodigoEquipo().equalsIgnoreCase(idEquipo)) {
                return equipo;
            }
        }
        return null;
    }

    public void agregarNinjaEquipo(String codEquipo, Ninja ninja){
        for (Equipo equipo : equipos){
            if (equipo.getCodigoEquipo().equals(codEquipo)){
                equipo.addNinja(ninja);
                System.out.println("Ninja Añadido");
            }

        }

    }
    public int numeroNinjas(){

        int total = 0;

        for (Equipo e : equipos){
            total += e.numeroNinjas();
        }

        if (total == 0){
            System.out.println("No hay ninjas");
        }

        return total;
    }


//    public void numeroDeNinjas(){
//
//        for (Ninja ninja: ninjas)
//    }


}

