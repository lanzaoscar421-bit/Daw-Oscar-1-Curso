import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionVideoDaw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Link: https://github.com/lanzaoscar421-bit/Proyectos/tree/main/VideoDaw-Oscar

        String Cif;
        String Nombre;
        String Direccion;
        LocalDate FechaNacimiento;

        VideoDaw nuestroVideoclub;
        Pelicula nuevaPelicula;
        Cliente nuevoCliente = null;
        Cliente clienteSeleccionado;
        Pelicula peliculaSeleccionada;
        String codcliente;
        String codpelicula;
        boolean exsitososPeli;
        boolean exsitosoCliente;


        System.out.println("Bienvenido a Video Daw 🎮");


        nuestroVideoclub = VideoClub(sc);


        int opcion = 0;


        while (opcion != 9) {

            decoracion();
            System.out.println("Pulse 1 crear y registrar VideoClub en la franquicia.");
            decoracion();
            System.out.println("Pulse 2 para registrar pelicula en VideoClub");
            decoracion();
            System.out.println("Pulse 3 para crear y registrar cliente en video club");
            decoracion();
            System.out.println("Pulsa 4 para alquilar Pelicula");
            decoracion();
            System.out.println("Pulsa 5 para devolver pelicula");
            decoracion();
            System.out.println("Pulsa 6 para dar de baja al cliente");
            decoracion();
            System.out.println("Pulsa 7 para dar de baja a una pelicula");
            decoracion();
            System.out.println("Pulsa 8 para ver la informacion de usuarios y peliculas");
            decoracion();
            System.out.println("Pulsa 9 si desea Salir");
            decoracion();

            if (!sc.hasNextInt()) {
                System.out.println("Introduce un número (no letras).");
                sc.nextLine(); // Medida para usuarios
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {

                case 1:
                    System.out.println(nuestroVideoclub.InfoVideoDAW());//Pongo la información de VideoDAW

                    break;
                case 2:
                    Pelicula(nuestroVideoclub);

                    break;
                case 3:
                    nuevocliente(nuestroVideoclub);//El usuario videoDaw lo usamos para guardar toda la informacion
                    break;
                case 4:
                    alquilarPyC(sc, nuestroVideoclub);

                    break;
                case 5:
                    devolucionPeli(sc, nuestroVideoclub);
                    break;

                case 6:
                    bajaCliente(nuestroVideoclub, sc);
                    break;
                case 7:
                    bajaPelicula(nuestroVideoclub, sc);

                    break;
                case 8:
                    System.out.println(nuestroVideoclub.mostrarClientes());
                    decoracion();
                    System.out.println(nuestroVideoclub.mostrarPeliculas());

                    break;
                case 9:
                    System.out.println("Adios.");

                    break;
                case 10:

                    break;
            }


        }
    }

    private static void devolucionPeli(Scanner sc, VideoDaw nuestroVideoclub) {
        String codpelicula;
        Cliente clienteSeleccionado;
        String codcliente;
        Pelicula peliculaSeleccionada;
        System.out.println("Para devolver inserte el código del Cliente:");
        codcliente = sc.nextLine().toUpperCase();
        System.out.println("Ahora inserte el código de la Película:");
        codpelicula = sc.nextLine().toUpperCase();

        clienteSeleccionado = nuestroVideoclub.busquedaCliente(codcliente);
        peliculaSeleccionada = nuestroVideoclub.buscarPelicula(codpelicula);

        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado, porfavor vuelve a comprobarlo");
        }
        if (peliculaSeleccionada == null) {
            System.out.println("Pelicula no encontrada, porfavor vuelve a comprobarlo");
        }
        nuestroVideoclub.devolucion(clienteSeleccionado, peliculaSeleccionada);
        System.out.println("Película devuelta correctamente.");
    }

    private static void bajaCliente(VideoDaw nuestroVideoclub, Scanner sc) {
        Cliente clienteSeleccionado;
        boolean exsitosoCliente;
        String codcliente;
        System.out.println("Para Dar de baja al cliente inserte el cod del Cliente");
        System.out.println(nuestroVideoclub.mostrarClientes());
        codcliente = sc.nextLine().toUpperCase();
        clienteSeleccionado= nuestroVideoclub.busquedaCliente(codcliente);
        exsitosoCliente = nuestroVideoclub.bajaCliente(clienteSeleccionado);
        if (exsitosoCliente){
            System.out.println("Se dio de baja Exitosamente");
        }else {
            System.out.println("Hubo un error");
        }
    }

    private static void bajaPelicula(VideoDaw nuestroVideoclub, Scanner sc) {
        Pelicula peliculaSeleccionada;
        boolean exsitososPeli;
        String codpelicula;
        System.out.println("Para Dar de baja a la pelicula inserte el cod de la pelicula");
        System.out.println(nuestroVideoclub.mostrarPeliculas());
        codpelicula = sc.nextLine().toUpperCase();
        peliculaSeleccionada= nuestroVideoclub.buscarPelicula(codpelicula);
        exsitososPeli = nuestroVideoclub.bajaPelicula(peliculaSeleccionada);
        if (exsitososPeli){
            System.out.println("Se dio de baja Exitosamente");
        }else {
            System.out.println("Hubo un error");
        }
    }

    private static void alquilarPyC(Scanner sc, VideoDaw nuestroVideoclub) {
        Pelicula peliculaSeleccionada;
        Cliente clienteSeleccionado;
        System.out.println("Para alquilar inserte el cod del Cliente");
        String codcliente = sc.nextLine().toUpperCase();
        System.out.println("Inserte el codigo de la Pelicula");
        String codpelicula = sc.nextLine().toUpperCase();
        clienteSeleccionado= nuestroVideoclub.busquedaCliente(codcliente);
        peliculaSeleccionada= nuestroVideoclub.buscarPelicula(codpelicula);

        boolean resultado = nuestroVideoclub.alquilar(clienteSeleccionado,peliculaSeleccionada);
        if (resultado){
            System.out.println("Se alquilo existosamente");
        }else{
            System.out.println("Hubo un Error");
        }

    }

    private static void Pelicula(VideoDaw videoclub) {//Recordar poner poner el Input
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Inserte el Titulo de la pelicula");
        String titulo = sc.nextLine();


        System.out.println("Ahora inserte el Genero acontinuacion te pondre los disponibles");
        for (Genero g : Genero.values()) {
            System.out.println("- " + g);
        }

        Genero genero = null;

        while (genero == null){
            System.out.println("Escribe bien el nombre del genero");
            String entrada = sc.nextLine().toUpperCase();
            //Comprobacion para Si el genero que puso el usuario Exsiste

            for (Genero g : Genero.values()){
                if (g.name().equalsIgnoreCase(entrada)){//equalsIgnoreCase para que el usuario ponga mayusculas o minusculas
                    genero = g;//Romper ciclo whilw
                    break;
                }
            }
            if (genero == null){
                System.out.println("El genero que pusiste es invalido");
            }
        }
        Pelicula nuevaPeli = new Pelicula(titulo,genero);
        boolean resultado = videoclub.sumarPelicula(nuevaPeli);
        if (resultado){
            System.out.println("Registraste Bien la peli");
            System.out.println(nuevaPeli.infopeli());
        }else{
            System.out.println("No se añadio");
        }

    }
    //Metodos

    private static void nuevocliente(VideoDaw videoclub) {
        Scanner sc;
        Cliente nuevoCliente;
        LocalDate FechaNacimiento;
        String DNI;
        do {
            sc = new Scanner(System.in);
            System.out.println("Inserte SU DNI");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            DNI = sc.nextLine();
            if (!PatronDNI(DNI)){
                System.out.println("Error, vuelve a insertar el DNI");
            }
        } while (!PatronDNI(DNI));
        System.out.println("Inserte su nombre");
        String NombreUsuario = sc.nextLine();
        System.out.println("Inserte su fecha nacimiento");
        System.out.println("Ejemplo: 2007-12-06");
        LocalDate FehcaNacimiento;
        FechaNacimiento = LocalDate.parse(sc.nextLine());
        nuevoCliente = new  Cliente(DNI,NombreUsuario,FechaNacimiento);
        System.out.println(nuevoCliente.InfoUsuario());
        boolean resultado = videoclub.sumarCliente(nuevoCliente);
        if (resultado){
            System.out.println("Añadimos cliente exsitosamente");
        }else{
            System.out.println("No se consigui añadir al cliente, revisa que sea mayor de Edad");
        }

    }


    //Metodos


    private static void decoracion() {
        System.out.println("*****************************************************");
    }

    private static VideoDaw VideoClub(Scanner sc) {
        String Cif;
        String Direccion;
        VideoDaw nuevoUsuario;
        String Nombre;
        do {
            System.out.println("Primero inserte el CIF del VideoClub:");
            System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)\" \n");
            Cif = sc.nextLine();
        }while (!PatronCIF(Cif));

        System.out.println("Inserte el nombre del VideoClub:");
        Nombre = sc.nextLine();

        System.out.println("Ahora insete la direccion :");
        Direccion = sc.nextLine();

        nuevoUsuario=new VideoDaw(Cif,Direccion,Nombre);//Inserta el dato del VideoDaw
        return nuevoUsuario;
    }

    static boolean PatronCIF(String CIF) {
        String patron = "^[A-HJUV][0-9]{7}[A-Z0-9]$";
        return Pattern.matches(patron,CIF);
    }
    static boolean PatronDNI(String DNI){
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron,DNI);
    }


}