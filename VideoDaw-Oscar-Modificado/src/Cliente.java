import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
    //Atributos
    private static int contadorClientes = 1;

    private String DNI;
    private String Nombre;
    private String NumeroSocio;
    private String Direccion;
    private LocalDate FechaNacimiento; //Debe de ser mayor de edad
    private LocalDate FechaBaja;
    private int PeliculasAlquiladas;
    private String dtf ="dd-MM-yyyy";
    private int contadorPeliculas;
    private Pelicula[] historialPeliculasAlquiladas;

    //Constructores
    public Cliente(String DNI, String Nombre, LocalDate FechaNacimiento) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.NumeroSocio = String.format("S-%03d", contadorClientes);
        contadorClientes++;
        this.Direccion = Direccion;
        this.FechaNacimiento = FechaNacimiento;
        this.FechaBaja = FechaBaja;
        this.contadorPeliculas = 0;
        this.historialPeliculasAlquiladas = new Pelicula[10];
    }
    //Getters-Setters

    public String getDNI() {
        return DNI;
    }

    public String getNumeroSocio() {
        return NumeroSocio;
    }
    public void setNumeroSocio(String numeroSocio) {
        this.getNumeroSocio();
    }
    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return FechaBaja;
    }

    public int getPeliculasAlquiladas() {
        return PeliculasAlquiladas;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public void setFechaBaja(LocalDate fechaBaja) {
        FechaBaja = fechaBaja;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }
    //Metodos

    public String InfoUsuario() {
        String fechaBaja = "Fecha baja:    \n";
        if (this.FechaBaja != null){
            fechaBaja = "Fecha baja:      " + DateTimeFormatter.ofPattern(dtf).format(this.FechaBaja) + "\n";
        }
        return  "===== INFORMACIÓN DE USUARIO =====\n" +
                "DNI:                 " + this.DNI + "\n" +
                "Nombre:              " + this.Nombre + "\n" +
                "Número de Socio:     " + this.NumeroSocio + "\n" +
                "Fecha Nacimiento:    " + this.FechaNacimiento + "\n" +
                fechaBaja +
                "Películas alquiladas:" + this.PeliculasAlquiladas + "\n" +
                "==================================";
    }


    public boolean sumarPelicula(Pelicula p){
        boolean resultado = false; //Si todo va mal no funciona

        if (p!=null){//Comprobamos que P exsiste
            if (this.contadorPeliculas==this.historialPeliculasAlquiladas.length){// Comporbamos si esta todo lleno
                Pelicula nuevalista [] = new Pelicula[this.historialPeliculasAlquiladas.length + 10];//Si todo lleno creamos un nuevo array que sume 10 lugares y este nuevo array estara VACIO
                for (int i = 0; i<this.historialPeliculasAlquiladas.length; i++){//Recorremos el array para todos los contenidos anteriores moverlos al nuevo array
                    nuevalista[i] = this.historialPeliculasAlquiladas[i];//Estamos poniendo las posiciones de la pelicula en el nuevo array, en la misma posicion que en el viejo array
                }
                this.historialPeliculasAlquiladas = nuevalista;//Borramos viejo array para dejar solo el nuevo
            }
            historialPeliculasAlquiladas[contadorPeliculas] = p;//Metiendo la pelicula en la pocicion correcta de array que va a estar Vacia
            contadorPeliculas++;
            resultado=true;

        }
        return resultado;
    }
    public Pelicula buscarHistorialPeliculas (String Cod){
        for (int i = 0; i < contadorPeliculas; i++){
            if (historialPeliculasAlquiladas[i].getCod().equalsIgnoreCase(Cod)) {
                return historialPeliculasAlquiladas[i];
            }
        }
        return null;
    }

    
}
