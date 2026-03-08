import java.time.LocalDate;

public class Equipo {

    private String nombreEquipo;
    private String codigoEquipo;//Dos letras mayusculas y 7 digitos
    private LocalDate fechaCreacion;
    private String  sensei;
    private int maximoNinjas;
    private Ninja [] ninjasRegistrados;
    private int contadorNinjas;
    Ninja nuvoninja;

    public Equipo(String nombreEquipo, String codigoEquipo, String sensei) {

        this.nombreEquipo = nombreEquipo;
        this.codigoEquipo = codigoEquipo;
        this.sensei = sensei;
        this.maximoNinjas = 0;
        this.fechaCreacion = LocalDate.now();
        this.ninjasRegistrados = new Ninja[10];
        this.contadorNinjas = 0;

    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public int getContadorNinjas() {
        return contadorNinjas;
    }


    public Ninja[] getNinjasRegistrados() {
        return ninjasRegistrados;
    }

    public int getMaximoNinjas() {
        return maximoNinjas;
    }

    public String getSensei() {
        return sensei;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }
    //Metodos

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
    //Crear Ninja

    public boolean registrarNinja(Ninja n){
        boolean resultado = false;
        if(n != null){
            int index = -1;
            for (int i = 0; i < this.contadorNinjas; i++){
                if (this.ninjasRegistrados[i].getIdNinja().equalsIgnoreCase(n.getIdNinja())){
                    index = i;
                    break;
                }

            }
            if(index == -1){
                this.ninjasRegistrados[this.contadorNinjas] = n;
                this.contadorNinjas++;
                resultado = true;
            }
        }
        return resultado;
    }




    public boolean eliminarNinja(String dni){
        boolean resultado = false;
        int index = -1;

        for (int i = 0; i < this.contadorNinjas; i++){
            if (this.ninjasRegistrados[i] != null){
                if (this.ninjasRegistrados[i].getDni().equalsIgnoreCase(dni)){
                    index = i;
                    break;
                }
            }
        }

        if (index != -1){
            this.ninjasRegistrados[index] = this.ninjasRegistrados[contadorNinjas - 1];
            this.ninjasRegistrados[contadorNinjas - 1] = null;
            contadorNinjas--;
            resultado = true;
        }

        return resultado;
    }
    public Ninja buscarninja(String dni){
        for (int i = 0; i < contadorNinjas; i++){
            if (ninjasRegistrados[i].getDni().equalsIgnoreCase(dni)) {
                return ninjasRegistrados[i];
            }
        }
        return null;
    }

    public String numeroNinjas(){
        String info = "";
        if (this.contadorNinjas > 0){
            info = "";
            System.out.println(contadorNinjas);
        }
        return info;
    }





}
