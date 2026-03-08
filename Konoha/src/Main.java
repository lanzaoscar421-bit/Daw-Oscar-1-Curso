import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Link https://github.com/lanzaoscar421-bit/Daw-Oscar-1-Curso/tree/main/VideoDaw-Oscar-Modificado

        final String pathVideoDaw = "./src/Resources/";
        final String fileNameVideoDaw= "VideoDaw.dat";
        boolean fileModeVideodaw = false;
        boolean eof = false;
        boolean isReadingSerializable = false;

        System.out.println("Bienvenido a Konoha"); System.out.println("Primero inserte el Nombre de la Aldea");
        String nombreAldea = sc.nextLine();

        System.out.println("Ahora inserte el nombre del Kage ");
        System.out.print("Ejemplo: Tobirama Senju, Minato Namikaze");
        System.out.println("");
        String kage = sc.nextLine();


        String codigoAldea;
        do {
            sc = new Scanner(System.in);
            System.out.println("Inserte el codigo de la Aldea");
            System.out.println("Este consta de 5 Letras Mayususculas y 5 digitos");
            System.out.println("Ejemplo: ABZDE12345");
            codigoAldea = sc.nextLine();
            if (!patronAldea(codigoAldea)){
                System.out.println("Error, vuelve a insertar el codigo de la Aldea");
            }
        } while (!patronAldea(codigoAldea));

        Aldea konoha = new Aldea(nombreAldea,kage,codigoAldea);


        String opcion = "";

        do{

            sc = new Scanner(System.in);


            System.out.println("1. Crear Equipo\n");
            System.out.println("2. Registrar Ninja en el equipo.\n");
            System.out.println("3. Mostrar el número de ninjas totales en la Aldea.\n");
            System.out.println("4. Mostrar información de un equipo.\n");
            System.out.println("5. Mostrar información de todos los equipos.\n");
            System.out.println("6. Mostrar información de toda la Aldea.\n");
            System.out.println("7. Calcular estadísticas de toda la Aldea.\n");
            System.out.println("8. Cambiar ninja de un equipo.\n");
            System.out.println("9. Eliminar ninja de la aldea\n");
            System.out.println("10. Salir \n");


            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    System.out.println("Para crear un equipo inserte el nombre: ");
                    String nombreEquipo = sc.nextLine();

                    String codigoEquipo;
                    do {
                        sc = new Scanner(System.in);
                        System.out.println("Inserte el codigo de Equipo");
                        System.out.println("Este consta de 2 Letras Mayususculas y 7 digitos");
                        System.out.println("Ejemplo: AB1234567");
                        codigoEquipo = sc.nextLine();
                        if (!patronEquipo(codigoEquipo)){
                            System.out.println("Error, vuelve a insertar el codigo de la Aldea");
                        }
                    } while (!patronEquipo(codigoEquipo));

                    System.out.println("Y ahora el nombre del Sensei: ");
                    String sensei = sc.nextLine();

                    Equipo nuevoEquipo = new Equipo(nombreEquipo,codigoEquipo,sensei);
                    konoha.addEquipo(nuevoEquipo);


                    break;

                case "2":

                    System.out.println("Para registrar un ninja primero hay que creearle");
                    System.out.println("Asi que inserte su nombre:");
                    String nombreNinja = sc.nextLine();

                    System.out.println("Inserte su direccion");
                    String direccion = sc.nextLine();

                    String idNinja;
                    do {
                        System.out.println("Inserte SU DNI");
                        System.out.println("El DNI consta de 8 números + 1 letra ");
                        System.out.println("Ejemplo: 12345678Z");
                        idNinja = sc.nextLine().toUpperCase().toUpperCase();
                    } while (!PatronDNI(idNinja));

                    System.out.println("Inserte su fecha de nacimiento");
                    System.out.println("El formtao es: 2006-07-30");
                    LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());


                    System.out.println("Ahora inserte su tipo de chakra");
                    for (Chakra g : Chakra.values()) {
                        System.out.println("- " + g);
                    }

                    Chakra chakra = null;

                    while (chakra == null){
                        System.out.println("Escribe bien el nombre de su Chakra");
                        String entrada = sc.nextLine().toUpperCase();
                        //Comprobacion para Si el genero que puso el usuario Exsiste

                        for (Chakra g : Chakra.values()){
                            if (g.name().equalsIgnoreCase(entrada)){//equalsIgnoreCase para que el usuario ponga mayusculas o minusculas
                                chakra = g;//Romper ciclo whilw
                                break;
                            }
                        }
                        if (chakra == null){
                            System.out.println("El Chakra que pusiste es invalido");
                        }
                    }


                    System.out.println("Ahora inserte su Rango");
                    for (Rango r : Rango.values()) {
                        System.out.println("- " + r);
                    }

                    Rango rango = null;

                    while (rango == null){
                        System.out.println("Escribe bien el rango");
                        String entrada = sc.nextLine().toUpperCase();
                        //Comprobacion para Si el genero que puso el usuario Exsiste

                        for (Rango r : Rango.values()){
                            if (r.name().equalsIgnoreCase(entrada)){//equalsIgnoreCase para que el usuario ponga mayusculas o minusculas
                                rango = r;//Romper ciclo whilw
                                break;
                            }
                        }
                        if (rango == null){
                            System.out.println("El rango que pusiste es invalido");
                        }
                    }
                    System.out.println("Y por ultimo su tecnica secreta");
                    System.out.println("Por cierto el chidori es el jutsu mas molon");
                    String tecnicaSecreta = sc.nextLine();


                    double ataque;
                    do{
                        System.out.println("Inserte el nivel de ataque entre el 1-100");
                        ataque = sc.nextDouble();

                    }while (ataque<0 || ataque>100);

                    double defensa;
                    do{
                        System.out.println("Inserte el nivel de ataque entre el 1-100");
                        defensa = sc.nextDouble();

                    }while (defensa<0 || defensa>100);


                    Ninja nuevoNinja = new Ninja(nombreNinja,direccion,fechaNacimiento,chakra ,rango ,idNinja,tecnicaSecreta,ataque,defensa);




                    break;

                case "3":

                    break;

                case "4":

                    System.out.println("Buscar un Equipo, inserte el ID");
                    String buscarEquipoId = sc.nextLine();



                    break;

                case "5":
                    konoha.verTodosEquipos();
                    break;

                case "6":

//                    System.out.println(konoha.informacionAldea());

                    break;

                case "7":

                    break;

                case "8":

                    break;
                case "9":

                    break;

                case "10":

                    try(FileOutputStream file = new FileOutputStream(pathVideoDaw+fileNameVideoDaw, fileModeVideodaw);
                        ObjectOutputStream buffer = new ObjectOutputStream(file)){

                            buffer.writeObject(konoha);


                    } catch (IOException e) {
                        System.err.println("Ha habido un problema al guardar: " + e.getMessage());
                    }
                    break;
                case "11":
                    System.out.println("Adios Muchas Gracias");
                    break;


                default:
                    System.out.println("Por favor, escoja la opcion correcta (1-8) ejem ejem ");
            }

        }while(!opcion.equals("11"));


    }
    static boolean PatronDNI(String DNI) {
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron, DNI);
    }

    static boolean patronEquipo(String codEquipo) {
        String patron = "[A-Z]{2}[1-9]{7}";
        return Pattern.matches(patron,codEquipo);
    }
    static boolean patronAldea(String cod) {
        String patron = "[A-Z]{5}[1-9]{5}";
        return Pattern.matches(patron,cod);
    }
}