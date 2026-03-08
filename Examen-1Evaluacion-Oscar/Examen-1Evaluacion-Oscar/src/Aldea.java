import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Aldea {
    private String nombreAldea;
    private String codigoAldea;
    private LocalDate fechaCreccion;
    private int maximoEquipos;
    private String kage;
    private Equipo [] equiposRegistrados;
    private int contadorEquipos = 0;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    Equipo nuevoEquipo;
    Ninja ninja;

    public Aldea(String nombreAldea, String kage, String codigoAldea) {
        this.nombreAldea = nombreAldea;
        this.codigoAldea = codigoAldea;
        this.kage = kage;
        this.fechaCreccion = LocalDate.now();
        this.equiposRegistrados = new Equipo[10];


    }

    public String getNombreAldea() {
        return nombreAldea;
    }

    public int getContadorEquipos() {
        return contadorEquipos;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public Equipo[] getEquiposRegistrados() {
        return equiposRegistrados;
    }

    public String getKage() {
        return kage;
    }

    public int getMaximoEquipos() {
        return maximoEquipos;
    }

    public LocalDate getFechaCreccion() {
        return fechaCreccion;
    }

    public String getCodigoAldea() {
        return codigoAldea;
    }
    //Metodos
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


    public boolean registrarEquipo(Equipo e){
        boolean resultado = false;
        if(e != null){
            int index = -1;
            for (int i = 0; i < this.contadorEquipos; i++){
                if (this.equiposRegistrados[i].getCodigoEquipo().equalsIgnoreCase(e.getCodigoEquipo())){
                    index = i;
                    break;
                }

            }
            if(index == -1){
                this.equiposRegistrados[this.contadorEquipos] = e;
                this.contadorEquipos++;
                resultado = true;
            }
        }
        return resultado;

    }

    public Equipo buscarEquipo (String codigoEquipo){
        for (int i = 0; i < contadorEquipos; i++){
            if (equiposRegistrados[i].getCodigoEquipo().equalsIgnoreCase(codigoEquipo)) {
                return equiposRegistrados[i];
            }
        }
        return null;

    }
    public String mostrarEquipos (){
        String infoClientes = "No hay Equipos registrados";
        if (this.contadorEquipos > 0){
            infoClientes = "";
            for (int i = 0; i < this.contadorEquipos; i++){
                infoClientes += this.equiposRegistrados[i].informacionEquipo();//
            }
        }
        return infoClientes;
    }
    public String numeroNinjas(Equipo equipo){
        String info = "";
        if (equipo.getContadorNinjas() > 0){
            info = "";
            System.out.println(equipo.getContadorNinjas());
        }
        return info;
    }




}
