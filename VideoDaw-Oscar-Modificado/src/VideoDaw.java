import Excepciones.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
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

        if(clientes.isEmpty()){
            System.out.println("No existen clientes");
        }else{
            for(Cliente cliente : clientes){
                System.out.println(cliente);
            }
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

    public boolean validarDni(String dni) throws ValidacionDNI {
        boolean resultado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                throw new ValidacionDNI("El dni ya exsiste en el sistema");
            }
        }
        return resultado;
    }

    public boolean validarNumSocio(String numSocio) throws ValidacionNumSocio {
        boolean resultado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getNumSocio().equals(numSocio)) {
                throw new ValidacionNumSocio("El numero de Socio ya existe en el sistema");
            }
        }
        return resultado;
    }




    //Metodo alquilar pelicula a cliente

    public boolean alquilarPeli(Cliente c, Pelicula p){
        boolean resultado = false;

        if(p!=null && c!=null && p.isAlquilada() == false && p.getFechaBaja() == null && c.getFechaBaja() == null){

            p.setAlquilador(c);
            p.setAlquilada(true);
            p.setFechaAlquiler(LocalDateTime.now());
            c.getPeliculasAlquilas().add(p);

            resultado = true;
        }
        return resultado;
    }

    //Devolver Pelicula

    public boolean devolverPelicula(Cliente c,Pelicula p){
        boolean resultado = false;

        if (p!=null && c!=null && p.isAlquilada() == true && p.getFechaBaja() == null && c.getFechaBaja() == null){


            if (p.getFechaAlquiler() != null) {

                long fechaActualEpoc = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                long fechaAlquilerEpoc = p.getFechaAlquiler().toEpochSecond(ZoneOffset.UTC);

                if (fechaActualEpoc - fechaAlquilerEpoc > 172800) {
                    System.out.println("AVISO: Se devolvió con más de 48 horas de retraso");
                }
            }

            p.setAlquilador(null);
            p.setAlquilada(false);

            p.setFechaAlquiler(null);



            resultado = true;

        }

        return resultado;
    }

    public boolean bajaCliente(Cliente cliente){

        boolean resultado = false;

        if(cliente !=null && cliente.getFechaBaja() == null) {
            cliente.setFechaBaja(LocalDate.now());
            resultado = true;
        }

        return resultado;
    }

    public Cliente buscarCliente (String numSocio){
        for (Cliente cliente : clientes) {
            if (cliente.getNumSocio().equalsIgnoreCase(numSocio)) {
                return cliente;
            }
        }
        return null;
    }


    public void validarDni_NumSocio(String numSocio, String dni) throws ValidacionDNI_NumSocio {

        if (numSocio == null || dni == null) {
            return;
        }
        for (Cliente cliente : clientes) {
            if(cliente.getNumSocio().equals(numSocio)&&cliente.getDni().equals(dni)){
                throw new ValidacionDNI_NumSocio("");
            }
        }
    }

    public boolean validacioMayoriaEdad(LocalDate fechaNacimiento) throws ValidacionEdad {

        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

        if (edad < 18) {
            throw new ValidacionEdad("No se puede ser menor de edad");
        }

        return true;

    }

    //

    //Peliculas
    public void addPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
    }

    public void removePelicula(Pelicula pelicula){
        peliculas.remove(pelicula);
    }

    public void infoPeliculas(){


        if (peliculas.isEmpty()){
            System.out.println("No existen peliculas");
        }else{
            for(Pelicula pelicula : peliculas){
                System.out.println(pelicula);
            }
        }

    }

    public boolean validarCodigoPelicula(String codigoPelicula) throws ValidacionCodPelicula {
        boolean resultado = false;

        for (Pelicula pelicula : peliculas){
            if (pelicula.getCodigo().equals(codigoPelicula)) {
                throw new ValidacionCodPelicula("El codigo de pelicula no se puede repetir");
            }
        }
        return resultado;
    }

    public boolean bajaPelicula(Pelicula pelicula){

        boolean resultado = false;

        if(pelicula!=null && pelicula.getFechaBaja() == null) {
            pelicula.setFechaBaja(LocalDate.now());
            resultado = true;
        }

        return resultado;
    }

    public Pelicula buscarPelicula (String codPelicula){
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codPelicula)) {
                return pelicula;
            }
        }
        return null;
    }





}



