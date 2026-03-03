import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;
import Excepciones.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionVideoDaw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Almacen Cliente
        final String pathClientes = "./src/Resources/";
        final String fileNameClientes = "Clientes.dat";
        boolean fileModeCliente = false;


        //Almacen Peliculas
        final String pathPeliculas = "./src/Resources/";
        final String fileNamePeliculas = "Peliculas.dat";
        boolean fileModePeliculas = false;

        //Link

        System.out.println("Bienvenido a Video Daw 🎮");


        LinkedList<VideoDaw> videoDaws = new LinkedList<>();

        String cif;
        do {
            System.out.println("Primero inserte el CIF del VideoClub:");
            System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)\" \n");
            cif = sc.nextLine();
        }while (!PatronCIF(cif));

        System.out.println("Inserte el nombre del VideoClub:");
        String NombreVideoDaw = sc.nextLine();

        System.out.println("Ahora insete la direccion :");
        String DireccionVideoDaw = sc.nextLine();

        VideoDaw videoDawPrimero = new VideoDaw(cif, NombreVideoDaw, DireccionVideoDaw);
        videoDaws.add(videoDawPrimero);


        String opcion = "";

        do {

            sc = new Scanner(System.in); // Reiniciar Scanner

            System.out.println("Pulse 0 ver informacion del los videoclubs");
            System.out.println("Pulse 1 crear y registrar VideoClub en la franquicia.");
            System.out.println("Pulse 2 crear y registrar pelicula");
            System.out.println("Pulse 3 crear y registrar cliente");
            System.out.println("Pulsa 4 alquilar Pelicula");
            System.out.println("Pulsa 5 devolver pelicula");
            System.out.println("Pulsa 6 dar de baja cliente");
            System.out.println("Pulsa 7 dar de baja pelicula");
            System.out.println("Pulsa 8 ver informacion usuarios y peliculas");
            System.out.println("Pulsa 9 si desea Salir");

            opcion = sc.nextLine();

            switch (opcion) {

                case "0":
                    for (VideoDaw videoDaw : videoDaws) {
                        System.out.println(videoDaw.toString());
                    }
                    break;

                case "1":

                    String cifAdd;
                    do {
                        System.out.println("Primero inserte el CIF del VideoClub:");
                        System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)");
                        System.out.println("EL Cif no puede ser repetido");
                        cifAdd = sc.nextLine();
                    } while (!PatronCIF(cifAdd));

                    System.out.println("Inserte el nombre del VideoClub:");
                    String NombreVideoDawadd = sc.nextLine();

                    System.out.println("Ahora inserte la direccion:");
                    String DireccionVideoDawadd = sc.nextLine();

                    try {
                        validarCif(videoDaws,cifAdd);
                        VideoDaw nuevoVideoDaw = new VideoDaw(cifAdd, NombreVideoDawadd, DireccionVideoDawadd);
                        videoDaws.add(nuevoVideoDaw);
                        System.out.println("VideoClub añadido correctamente");
                    }catch (ValidacionCIF e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":

                    String codigoPeliculaADD;
                    do {
                        System.out.println("El codigo de la pelicula no se podra repetir");
                        System.out.println("Introduce el numero de la pelicula");
                        System.out.println("El formato el el siguiente:");
                        System.out.println("Ejemplo:  P-0001");
                        codigoPeliculaADD = sc.nextLine();
                    }while (!PatronCodigoPeli(codigoPeliculaADD));

                    System.out.println("Ahora Inserte el titulo de la pelicula");
                    String tituloPeliculaAdd = sc.nextLine();


                    System.out.println("Ahora inserte el Genero acontinuacion te pondre los disponibles");
                    for (Genero g : Genero.values()) {
                        System.out.println("- " + g);
                    }

                    Genero genero = null;

                    while (genero == null){
                        System.out.println("Escribe bien el nombre del genero");
                        String entrada = sc.nextLine().toUpperCase();


                        for (Genero g : Genero.values()){
                            if (g.name().equalsIgnoreCase(entrada)){
                                genero = g;
                                break;
                            }
                        }
                        if (genero == null){
                            System.out.println("El genero que pusiste es invalido");
                        }
                    }

                    try {
                        videoDawPrimero.validarCodigoPelicula(codigoPeliculaADD);

                        Pelicula nuevapelicula = new Pelicula(codigoPeliculaADD,tituloPeliculaAdd,genero);
                        videoDawPrimero.addPelicula(nuevapelicula);

                        try (FileOutputStream file = new FileOutputStream(pathPeliculas+fileNamePeliculas,fileModePeliculas);
                        ObjectOutputStream buffer = new ObjectOutputStream(file)){
                            buffer.writeObject(nuevapelicula);

                            System.out.println("Se añadio correctamente al Array y al almacen");

                        }catch (IOException e){
                            System.out.println(e.getMessage());
                        }

                    }catch (ValidacionCodPelicula e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":

                    String dniAdd;
                    System.out.println("Primero inserte su DNI");
                    do {
                        System.out.println("El DNI consta de 8 números + 1 letra ");
                        System.out.println("Ejemplo: 12345678Z");
                        System.out.println("El Dni no se puede repetir");
                        dniAdd = sc.nextLine();
                    } while (!PatronDNI(dniAdd));

                    System.out.println("Inserte su nombre");
                    String NombreAdd = sc.nextLine();

                    System.out.println("Ahora inserte la direccion:");
                    String direccionAdd = sc.nextLine();

                    LocalDate fechaNacimiento = null;

                    System.out.println("Inserte su fecha de nacimiento");
                    System.out.println("Ejemplo de formato: 2007-12-06");

                    while (fechaNacimiento == null) {
                        try {
                            fechaNacimiento = LocalDate.parse(sc.nextLine());

                        } catch (Exception e) {
                            System.out.println("Por favor, inserte bien el formato (YYYY-MM-DD)");
                        }
                    }


                    String numSocio;
                    do {
                        System.out.println("El numero de socio no se podra repetir");
                        System.out.println("Introduce el numero de Socio del VideoClub");
                        System.out.println("El formato el el siguiente:");
                        System.out.println("Ejemplo:  S-0001");
                        numSocio = sc.nextLine();
                    }while (!PatronNumSocio(numSocio));


                    try {

                        videoDawPrimero.validacioMayoriaEdad(fechaNacimiento);

                        videoDawPrimero.validarDni_NumSocio(numSocio, dniAdd);

                        videoDawPrimero.validarDni(dniAdd);

                        videoDawPrimero.validarNumSocio(numSocio);

                        Cliente nuevocliente = new Cliente(dniAdd, NombreAdd, direccionAdd, fechaNacimiento, numSocio);

                        videoDawPrimero.addCliente(nuevocliente);


                        try (FileOutputStream file = new FileOutputStream(pathClientes + fileNameClientes, fileModeCliente);
                             ObjectOutputStream buffer = new ObjectOutputStream(file)) {

                            buffer.writeObject(nuevocliente);


                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }

                        System.out.println("Cliente insertado correctamente\n");

                    }catch (ValidacionEdad e) {
                            System.out.println(e.getMessage());
                    }catch (ValidacionDNI_NumSocio e){
                        System.out.println(e.getMessage());
                    }catch (ValidacionDNI e){
                        System.out.println(e.getMessage());
                    }catch (ValidacionNumSocio e) {
                        System.out.println(e.getMessage());
                    }


                    break;
                case "4":


                    Pelicula peliculaSeleccionadaAlquilar;
                    Cliente clienteSeleccionadoAlquilar;

                    System.out.println("Inserte el numero de socio");
                    String numeroSocioAlquilar = sc.nextLine();

                    System.out.println("Inserte el codigo de la pelicula");
                    String codigoPeliculaAlquilar = sc.nextLine();

                    clienteSeleccionadoAlquilar = videoDawPrimero.buscarCliente(numeroSocioAlquilar);
                    peliculaSeleccionadaAlquilar = videoDawPrimero.buscarPelicula(codigoPeliculaAlquilar);


                    boolean resultado = videoDawPrimero.alquilarPeli(clienteSeleccionadoAlquilar,peliculaSeleccionadaAlquilar);

                    if (resultado){
                        System.out.println("La pelicula fue alquilada con exsito");
                    }else{
                        System.out.println("Hubo un problea, revise si el numero del socio o el codigo de la peli son correctos");
                    }


                    break;

                case "5":

                    Pelicula peliculaSeleccionadaDevolver;
                    Cliente clienteSeleccionadoDevolver;

                    System.out.println("Inserte el numero de socio");
                    String numeroSocioDevolver = sc.nextLine();

                    System.out.println("Inserte el codigo de la pelicula");
                    String codigoPeliculaDevolver = sc.nextLine();

                    clienteSeleccionadoDevolver = videoDawPrimero.buscarCliente(numeroSocioDevolver);
                    peliculaSeleccionadaDevolver = videoDawPrimero.buscarPelicula(codigoPeliculaDevolver);


                    boolean resultadoDevolver = videoDawPrimero.devolverPelicula(clienteSeleccionadoDevolver,peliculaSeleccionadaDevolver);

                    if (resultadoDevolver){
                        System.out.println("La pelicula fue devuelta con existo");
                    }else{
                        System.out.println("Hubo un problea, revise si el numero del socio o el codigo de la peli son correctos");
                    }




                    break;
                case "6":

                    Cliente clienteSeleccionado;
                    boolean resultadoClienteBaja;

                    System.out.println("Inserte el numero de socio para darlo de baja");
                    videoDawPrimero.infoCliente();
                    String numSocioBaja = sc.nextLine();

                    clienteSeleccionado = videoDawPrimero.buscarCliente(numSocioBaja);
                    resultadoClienteBaja = videoDawPrimero.bajaCliente(clienteSeleccionado);
                    if (resultadoClienteBaja) {
                        System.out.println("Este socio se dio de baja");
                    }else{
                        System.out.println("Hubo fallo, mire mejor el numero del socio");
                    }
                    break;

                case "7":
                    Pelicula peliculaSeleccionada;
                    boolean resultadoPeliculaBaja;

                    System.out.println("Inserte el codigo de pelicula para darla de baja");
                    videoDawPrimero.infoPeliculas();
                    String numeroPeliculaBaja = sc.nextLine();


                    peliculaSeleccionada = videoDawPrimero.buscarPelicula(numeroPeliculaBaja);
                    resultadoPeliculaBaja = videoDawPrimero.bajaPelicula(peliculaSeleccionada);


                    if (resultadoPeliculaBaja) {
                        System.out.println("Este pelicula se dio de baja");
                    }else{
                        System.out.println("Hubo fallo, mire mejor el numero de pelicula");
                    }
                    break;

                case "8":
                    videoDawPrimero.infoCliente();
                    System.out.println("");
                    videoDawPrimero.infoPeliculas();
                    break;

                case "9":
                    System.out.println("Adios.");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!opcion.equals("9"));
    }
    static boolean PatronCIF(String CIF) {
        String patron = "^[A-HJUV][0-9]{7}[A-Z0-9]$";
        return Pattern.matches(patron,CIF);
    }
    static boolean PatronDNI(String DNI){
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron,DNI);
    }
    static boolean PatronNumSocio(String numeroSocio){
        String Patron = "S-[0-9]{4}";
        return Pattern.matches(Patron, numeroSocio);
    }
    static boolean PatronCodigoPeli(String codidoPeli){
        String Patron = "P-[0-9]{4}";
        return Pattern.matches(Patron, codidoPeli);
    }

    private static void validarCif(LinkedList<VideoDaw> videoDaws, String cif) throws ValidacionCIF {
        for (VideoDaw videoDaw : videoDaws) {
            if(videoDaw.getCif().equals(cif)) {
                throw new ValidacionCIF("Este CIF ya exsiste");
            }
        }
    }

}