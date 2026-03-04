import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String pathVideoDaw = "./src/resources/";
        final String fileNameVideoDaw= "MediaDaw.dat";
        boolean fileModeVideodaw = false;
        boolean eof = false;



        System.out.println("Primero inserte el Cif de tu mediaDaw");
        String cif;
        do {
            System.out.println("Primero inserte el CIF del VideoClub:");
            System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)\" \n");
            cif = sc.nextLine();
        }while (!PatronCIF(cif));

        System.out.println("Inserte el nombre");
        String nombreVideoDaw = sc.nextLine();

        MediaDaw mediaDawPrimero= new MediaDaw(cif, nombreVideoDaw);



        String opcion = "";

        do {

            sc = new Scanner(System.in);

            System.out.println("1. Registrar artículo (Pelicula o Videojuego)");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Alquilar artículo");
            System.out.println("4. Devolver artículo");
            System.out.println("5. Dar de baja cliente");
            System.out.println("6. Dar de baja artículo");
            System.out.println("7. Mostrar todos los artículos");
            System.out.println("8. Mostrar todos los clientes");
            System.out.println("9. Guardar todo en el almacen");
            System.out.println("10. Salir");


            opcion = sc.nextLine();

            switch (opcion){

                case "1":

                    System.out.println("¿Qué tipo de artículo desea registrar?");
                    System.out.println("1. Pelicula");
                    System.out.println("2. VideoJuego");
                    String tipo = sc.nextLine();

                    System.out.println("Ingrese el título:");
                    String titulo = sc.nextLine();

                    switch(tipo) {
                        case "1":
                            System.out.println("Ingrese el id de la pelicula");
                            String idPelicula = sc.nextLine();

                            System.out.println("Ingrese el Titulo de la película:");
                            String tituloPelicula = sc.nextLine();

                            System.out.println("Inserte la duracion");
                            double duracionPelicula = sc.nextDouble();

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

                            Pelicula p = new Pelicula(idPelicula,tituloPelicula,duracionPelicula,genero);
                            mediaDawPrimero.addArticulo(p);
                            System.out.println("Se añadio perfectamente");


                            break;
                        case "2":

                            System.out.println("Ingrese el id del Videojuego");
                            String idVideojuego = sc.nextLine();

                            System.out.println("Ingrese el Titulo del Videojuego:");
                            String tituloVideojuego = sc.nextLine();

                            System.out.println("Inserte la plataforma");
                            String plataforma = sc.nextLine();

                            System.out.println("Opciones de PEGI disponibles:");
                            for (Pegi p1 : Pegi.values()) {
                                System.out.println("- " + p1);
                            }

                            Pegi pegi = null;

                            while (pegi == null) {
                                System.out.println("Escribe bien el Pegi:");
                                String entrada = sc.nextLine().toUpperCase();

                                for (Pegi p1 : Pegi.values()) {
                                    if (p1.name().equalsIgnoreCase(entrada)) {
                                        pegi = p1;
                                        break;
                                    }
                                }

                                if (pegi == null) {
                                    System.out.println("El Pegi que pusiste es inválido.");
                                }
                            }

                            Videojuego v = new Videojuego(idVideojuego,tituloVideojuego,plataforma,pegi);
                            mediaDawPrimero.addArticulo(v);

                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;
                case "2":

                    String dniAdd;

                    System.out.println("Inserte su DNI");
                    do {
                        System.out.println("El DNI consta de 8 números + 1 letra ");
                        System.out.println("Ejemplo: 12345678Z");
                        System.out.println("El Dni no se puede repetir");
                        dniAdd = sc.nextLine();
                    } while (!PatronDNI(dniAdd));

                    System.out.println("Inserte su nombre");

                    String nombre = sc.nextLine();

                    Cliente nuevoCliente = new Cliente(dniAdd,nombre);
                    mediaDawPrimero.addCliente(nuevoCliente);

                    break;


                case "7":

                    mediaDawPrimero.infoArticulos();

                    break;

                case "8":

                    mediaDawPrimero.infoClientes();

                    break;

                case "9":

                    try(FileOutputStream file = new FileOutputStream(pathVideoDaw+fileNameVideoDaw, fileModeVideodaw);
                        ObjectOutputStream buffer = new ObjectOutputStream(file)){

                        buffer.writeObject(mediaDawPrimero);

                    } catch (IOException e) {
                        System.err.println("Ha habido un problema al guardar: " + e.getMessage());
                    }

                    break;
            }
        }while (!opcion.equals("10"));
        
    }

    static boolean PatronDNI(String DNI){
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron,DNI);
    }
    static boolean PatronCIF(String CIF) {
        String patron = "^[A-HJUV][0-9]{7}[A-Z0-9]$";
        return Pattern.matches(patron,CIF);
    }
}