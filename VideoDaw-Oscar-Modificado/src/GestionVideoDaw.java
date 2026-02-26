import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionVideoDaw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

            System.out.println("Pulse 0 para ver informacion del los videoclubs");
            System.out.println("Pulse 1 crear y registrar VideoClub en la franquicia.");
            System.out.println("Pulse 2 para registrar pelicula en VideoClub");
            System.out.println("Pulse 3 para crear y registrar cliente en video club");
            System.out.println("Pulsa 4 para alquilar Pelicula");
            System.out.println("Pulsa 5 para devolver pelicula");
            System.out.println("Pulsa 6 para dar de baja al cliente");
            System.out.println("Pulsa 7 para dar de baja a una pelicula");
            System.out.println("Pulsa 8 para ver la informacion de usuarios y peliculas");
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
                    }catch (Validaciones e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    break;

                case "7":
                    break;

                case "8":
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

    private static void validarCif(LinkedList<VideoDaw> videoDaws, String cif) throws Validaciones {

        for (VideoDaw videoDaw : videoDaws) {
            if(videoDaw.getCif().equals(cif)) {
                throw new Validaciones("");
            }
        }
    }

}