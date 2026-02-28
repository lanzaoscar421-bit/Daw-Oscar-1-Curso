import Excepciones.ValidacionesException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class VideoDaw {

    private String Cif;
    private String Direccion;
    private String fechaAlta;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String NombreVideo;
    private List <Cliente> clientes;
    private List <Pelicula> peliculas;


    //Contructor
    VideoDaw(String Cif, String Direccion, String NombreVideo) {
        this.Cif = Cif;
        this.Direccion = Direccion;
        this.fechaAlta = LocalDateTime.now().format(dtf);
        this.NombreVideo = NombreVideo;
        this.clientes = new LinkedList<>();
        this.peliculas = new LinkedList<>();
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

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public String getNombreVideo() {
        return NombreVideo;
    }


    //Metodos
    @Override
    public String toString() {
        return "===== VideoDaw =====\n" +
                "CIF: " + Cif + "\n" +
                "Dirección: " + Direccion + "\n" +
                "Fecha Alta: " + fechaAlta + "\n" +
                "DTF: " + dtf + "\n" +
                "Nombre Video: " + NombreVideo + "\n" +
                "====================";
    }
    //Clientes
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public void infoCliente(){

        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }

    private boolean comprobacionEdad (Cliente c) {
        boolean mayorEdad = false;
        long epocNacimiento = c.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        long epocFechactual = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        if (epocFechactual - epocNacimiento >= 568036800) {
            mayorEdad = true;
        }

        return mayorEdad;
    }

    public boolean validarDni(String dni) throws ValidacionesException {
        boolean resultado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                throw new ValidacionesException("El dni ya exsiste en el sistema");
            }
        }
        return resultado;
    }

    public boolean validarNumSocio(String numSocio) throws ValidacionesException {
        boolean resultado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getNumSocio().equals(numSocio)) {
                throw new ValidacionesException("El numero de Socio ya existe en el sistema");
            }
        }
        return resultado;
    }

//    public Cliente buscarCliente (String numeroSocio){
//
//        for (Cliente cliente : clientes){
//            if (cliente.getNumSocio().equalsIgnoreCase(numeroSocio){
//
//            }
//        }
//    }


    //Peliculas
    public void addPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
    }

    public void removePelicula(Pelicula pelicula){
        peliculas.remove(pelicula);
    }

    public void infoPeliculas(){

        for(Pelicula pelicula : peliculas){
            System.out.println(pelicula);
        }
    }

    public boolean validarCodigoPelicula(String codigoPelicula) throws ValidacionesException {
        boolean resultado = false;

        for (Pelicula pelicula : peliculas){
            if (pelicula.getCodigo().equals(codigoPelicula)) {
                throw new ValidacionesException("El codigo de pelicula no se puede repetir");
            }
        }
        return resultado;
    }





}



