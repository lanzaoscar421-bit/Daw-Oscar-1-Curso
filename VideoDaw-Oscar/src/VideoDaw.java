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

    private int contadorPeliculas;
    private int contadorClientes;

    //Enlace para las otras clases//ARRAY
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;

    //Contructor
    VideoDaw(String Cif, String Direccion, String NombreVideo){//Entre parentesis lo que quieres que el usuario ponga obligatoriamente
        this.Cif = Cif;
        this.Direccion = Direccion; //Inicializa es decir que direccion inicia con la direccion de arriba
        this.fechaAlta = LocalDateTime.now().format(dtf);
        this.clientesRegistrados = new Cliente[10];//  Array de 10
        this.peliculasRegistradas = new  Pelicula[10];
        this.contadorPeliculas = 0;
        this.contadorClientes = 0;
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

    public void setCif(String cif) {
        Cif = cif;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

//Metodos


    public boolean sumarCliente(Cliente c){
        boolean resultado = false; //Si todo va mal no funciona

            if (c!=null){//Comprobamos que C exsiste
                if (comprobacionEdad(c)){//Antes de nada comprueba la edad
                    if (this.contadorClientes == this.clientesRegistrados.length) {// Comporbamos si esta todo lleno
                        Cliente nuevalista[] = new Cliente[this.clientesRegistrados.length + 10];//Si todo lleno creamos un nuevo array que sume 10 lugares y este nuevo array estara VACIO
                        for (int i = 0; i < this.clientesRegistrados.length; i++) {//Recorremos el array para todos los contenidos anteriores moverlos al nuevo array
                            nuevalista[i] = this.clientesRegistrados[i];//Estamos poniendo las posiciones de los clientes en el nuevo array, en la misma posicion que en el viejo array
                        }
                        this.clientesRegistrados = nuevalista;//Borramos viejo array para dejar solo el nuevo
                    }
                    clientesRegistrados[contadorClientes] = c;//Metiendo el cliente en la pocicion correcta de alrray que va a estar Vacia
                    contadorClientes++;
                    resultado = true;
                }

            }
        return resultado;
    }
    private boolean comprobacionEdad (Cliente c){
        boolean mayorEdad = false;//Mayor de eadad es falso
        long epocNacimiento = c.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        long epocFechactual = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        if (epocFechactual-epocNacimiento >= 568036800){//Comprobacion Edad
            mayorEdad = true;
        }


        return mayorEdad;
    }
    public boolean sumarPelicula(Pelicula p){
        boolean resultado = false; //Si todo va mal no funciona

        if (p!=null){//Comprobamos que P exsiste
            if (this.contadorPeliculas==this.peliculasRegistradas.length){// Comporbamos si esta todo lleno
                Pelicula nuevalista [] = new Pelicula[this.peliculasRegistradas.length + 10];//Si todo lleno creamos un nuevo array que sume 10 lugares y este nuevo array estara VACIO
                for (int i=0; i<this.peliculasRegistradas.length; i++){//Recorremos el array para todos los contenidos anteriores moverlos al nuevo array
                    nuevalista[i] = this.peliculasRegistradas[i];//Estamos poniendo las posiciones de la pelicula en el nuevo array, en la misma posicion que en el viejo array
                }
                this.peliculasRegistradas = nuevalista;//Borramos viejo array para dejar solo el nuevo
            }
            peliculasRegistradas[contadorPeliculas] = p;//Metiendo la pelicula en la pocicion correcta de array que va a estar Vacia
            contadorPeliculas++;
            resultado=true;

        }
        return resultado;
    }

    public boolean alquilar(Cliente c, Pelicula p){//Pasamos informacion del cliente y la pelicula para alquilar
        boolean resultado = false; //Si todo va mal te dice que a fallado
        if(p!=null && c!=null && p.isIsalquilada() == false && p.getFechabaja() == null && c.getFechaBaja() == null){//Aseguracion de que todo este bien
            c.sumarPelicula(p);//Estamos registrado que el cliente alquile la peli
            p.setIsalquilada(true);
            p.setFechaAlquiler(LocalDateTime.now());
            resultado = true;
        }

        return resultado;
    }


    public String InfoVideoDAW(){
        String info = "";

        info+="Cif:" + this.Cif + "\n";
        info+="Direccion:" + this.Direccion + "\n";
        info+="Fecha alta: "+ this.fechaAlta + "\n";
        return info;
    }


    public Cliente busquedaCliente (String NumeroSocio){
        //Array para recorrer usando el contador de clientes
        for (int i = 0; i < contadorClientes; i++){
            if (clientesRegistrados[i].getNumeroSocio().equalsIgnoreCase(NumeroSocio)) {
                return clientesRegistrados[i];
            }
        }
        return null;
    }

    public Pelicula buscarPelicula (String Cod){
        for (int i = 0; i < contadorPeliculas; i++){
            if (peliculasRegistradas[i].getCod().equalsIgnoreCase(Cod)) {
                return peliculasRegistradas[i];
            }
        }
        return null;
    }

    public boolean bajaCliente (Cliente c){
        boolean resultado = false;
        if (c!=null && c.getFechaBaja() == null){//Comprobacion de que exsiste cliente y que no este dado de baja

            c.setFechaBaja(LocalDate.now());
            resultado = true;

        }
        return resultado;
    }

    public boolean bajaPelicula (Pelicula p){
        boolean resultado = false;
        if (p!=null && p.getFechabaja() == null){
            p.setFechabaja(LocalDate.now());
            resultado = true;
        }

        return resultado;
    }
    public String mostrarClientes (){
         String infoClientes = "No hay Clientes registrados";
         if (this.contadorClientes > 0){
             infoClientes = "";
             for (int i = 0; i < this.contadorClientes; i++){
                infoClientes += this.clientesRegistrados[i].InfoUsuario();//
             }
         }
        return infoClientes;
    }
    public String mostrarPeliculas (){
        String infoPeliculas = "No hay peliculas registradas";

        if (this.contadorPeliculas > 0){
            infoPeliculas = "";
            for (int i = 0; i < this.contadorPeliculas; i++){
                infoPeliculas += this.peliculasRegistradas[i].infopeli();
            }

        }
        return infoPeliculas;
    }
    public void devolucion(Cliente c, Pelicula p) {
        String resultado = "No se pudo devolver";

        if (c != null && p != null && p.isIsalquilada()){
            if (c.buscarHistorialPeliculas(p.getCod()) == p) {

                p.setIsalquilada(false);
                resultado = "Se a devuelto correctamente";

                long fechActualEpoc = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                long fechaAlquilerEpoc = p.getFechaAlquiler().toEpochSecond(ZoneOffset.UTC);
                if (fechActualEpoc - fechaAlquilerEpoc > 172800) {

                    resultado += "\n AVISO se devolvio con 48 horas de retraso";
                }
            }

        }


    }

}



