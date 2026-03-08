import java.io.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;
import Excepciones.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionVideoDaw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<VideoDaw> videoDaws = new LinkedList<>();
        //Link https://github.com/lanzaoscar421-bit/Daw-Oscar-1-Curso/tree/main/VideoDaw-Oscar-Modificado

        VideoDaw videoDawPrimero = null;



        //Almacen para el videoDAW
        final String pathVideoDaw = "./src/Resources/";
        final String fileNameVideoDaw= "VideoDaw.dat";
        boolean fileModeVideodaw = false;
        boolean eof = false;
        boolean isReadingSerializable = false;

        File vdFile = new File(pathVideoDaw+fileNameVideoDaw);

        if (vdFile.exists()) {

            System.out.print("Existe un VideoDaw.dat con datos de uso anteriormente." +
                    "\nPresione 1 si desea usar este o presione cualquier otra tecla si desea usar los archivos por defecto en su lugar." +
                    "\nEscoja su opcion: ");

            Scanner sc1 = new  Scanner(System.in);

            String input = sc1.nextLine();



            if (!input.isEmpty() && input.charAt(0) == '1') {
                isReadingSerializable = true;


                try (FileInputStream fileReader = new FileInputStream(vdFile);
                     ObjectInputStream bufferedReader = new ObjectInputStream(fileReader)) {

                    while (eof == false) {

                        //Lectura
                        VideoDaw temp = (VideoDaw) bufferedReader.readObject();
                        videoDaws.add(temp);

                    }

                } catch (EOFException e) {

                    eof = true;

                } catch (IOException e) {
                    System.out.println("No se pudo usar el documento en el I/O");
                    System.out.println(e.getMessage());
                    return;
                } catch (InputMismatchException e) {
                    System.out.println("Uno de los datos no se pudo leer");
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Algo fue mal");
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }

        }
        //Link

        System.out.println("Bienvenido a Video Daw 🎮");


        if(!isReadingSerializable){

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

            videoDawPrimero = new VideoDaw(cif, NombreVideoDaw, DireccionVideoDaw);
            videoDaws.add(videoDawPrimero);
        }

        videoDawPrimero = videoDaws.get(0);


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
            System.out.println("Pulsa 9 para guardar los datos en el almacen");
            System.out.println("Pulsa 10 si desea Salir");

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



                    try {
                        boolean resultadoDevolver = videoDawPrimero.devolverPelicula(clienteSeleccionadoDevolver,peliculaSeleccionadaDevolver);

                        if (resultadoDevolver){
                            System.out.println("La pelicula fue devuelta con existo");
                        }else{
                            System.out.println("Hubo un problea, revise si el numero del socio o el codigo de la peli son correctos");
                        }

                    }catch (ValidacionCaducacion e) {
                        System.out.println(e.getMessage());
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

                    try(FileOutputStream file = new FileOutputStream(pathVideoDaw+fileNameVideoDaw, fileModeVideodaw);
                        ObjectOutputStream buffer = new ObjectOutputStream(file)){

                        for (VideoDaw v: videoDaws){
                          buffer.writeObject(v);
                        }

                    } catch (IOException e) {
                        System.err.println("Ha habido un problema al guardar: " + e.getMessage());
                    }


                    break;
                case "10":
                        System.out.println("Adios.");
                    break;


                case "11":

                    Cliente ClienteSeleccionadoDel;
                    System.out.println("Para eliminar el Cliente debe insertar Su numero de referencia");
                    String referenciaDel = sc.nextLine();


                    ClienteSeleccionadoDel = videoDawPrimero.buscarCliente(referenciaDel);

                    videoDawPrimero.eliminarCliente(ClienteSeleccionadoDel);

                    break;


                case "12":

                    Pelicula peliculaSeleccionadaDel;

                    System.out.println("Inserte el codigo de referencia para eliminar la Pelicula");
                    String referenciaDelPel = sc.nextLine();

                    peliculaSeleccionadaDel = videoDawPrimero.buscarPelicula(referenciaDelPel);
                    videoDawPrimero.eliminarPelicula(peliculaSeleccionadaDel);



                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!opcion.equals("10"));
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