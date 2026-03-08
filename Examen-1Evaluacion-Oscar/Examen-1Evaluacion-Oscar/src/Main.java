import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        String nombreAldea;
        String codigoAldea;
        String kage;
        Aldea nuevaAldea;
        Equipo nuevoEquipo;
        Ninja nuevoNinja;


        nuevaAldea = aldea(sc);


        String opcion = "";

        do{
            sc = new Scanner(System.in);

            menu();


            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    equipo(sc, nuevaAldea);

                    break;

                case "2":


                    Ninja(sc);


                    break;

                case "3":
                    numeroNinjaMetodo();

                    break;

                case "4":
                    busquedaEquipoMetodo(sc, nuevaAldea);

                    break;

                case "5":
                    System.out.println(nuevaAldea.mostrarEquipos());

                    break;

                case "6":
                    System.out.println(nuevaAldea.informacionAldea());

                    break;

                case "7":

                    break;

                case "8":

                    break;
                case "9":
                    borrarNinjaMetodo(sc);


                    break;
                case "10":
                    System.out.println("Adios Muchas Gracias");
                    break;


                default:
                    System.out.println("Por favor, escoja la opcion correcta (1-8) ejem ejem ");
            }

        }while(!opcion.equals("8"));




    }

    private static void numeroNinjaMetodo() {
        System.out.println("En la aldea hay:");
//                    System.out.println(nuevaAldea.numeroNinjas(nuevoNinja)); LLamariamos al metodo para ver el numero de ninjas
        System.out.println("Ninjas");
    }

    private static void busquedaEquipoMetodo(Scanner sc, Aldea nuevaAldea) {
        String codigoBuscarEquipo;
        System.out.println("Para buscar la informacion de un Equipo inserte su cod");
        codigoBuscarEquipo = sc.nextLine();
        Equipo encontrado = nuevaAldea.buscarEquipo(codigoBuscarEquipo);
        if (encontrado != null) {
            System.out.println(encontrado.informacionEquipo()); // Muestra la información completa
        } else {
            System.out.println("No se ha encontrado ningún Equipo .");
        }
    }

    private static void borrarNinjaMetodo(Scanner sc) {
        String dniBorarNinja;
        System.out.println("Para borrar un ninja tienes que insertar el DNI");
        dniBorarNinja = sc.nextLine();
//                    nuevoEquipo.eliminarNinja(dniBorarNinja); En esta linea accederia al metodo borrar y lo borraria
    }

    private static void Ninja(Scanner sc) {
        Ninja nuevoNinja;
        String nombreNinja;
        String direccion;
        String dniNinja;
        LocalDate fechaNacimiento;
        String tecnicaSecreta;
        System.out.println("Para registrar un ninja primero hay que creearle");
        System.out.println("Asi que inserte su nombre:");
        nombreNinja = sc.nextLine();

        System.out.println("Inserte su direccion");
        direccion = sc.nextLine();

        do {
            System.out.println("Inserte SU DNI");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dniNinja = sc.nextLine().toUpperCase().toUpperCase();
        } while (!PatronDNI(dniNinja));

        System.out.println("Inserte su fecha de nacimiento");
        System.out.println("El formtao es: 2006-07-30");
        fechaNacimiento = LocalDate.parse(sc.nextLine());


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
        tecnicaSecreta = sc.nextLine();
        nuevoNinja = new Ninja(nombreNinja,direccion,dniNinja,fechaNacimiento,chakra,rango,tecnicaSecreta);
//                    boolean resultado3 = nuevoEquipo.registrarNinja(nuevoNinja);  En estas lineas accederia al metodo añadir y añadiria Ninja
//                    boolean resultado2 = nuevaAldea.nuevoEquipo.registrarNinja(nuevoNinja);
//
//                    if (resultado2){
//                        System.out.println("Se asigno correctamente");
//                    }else {
//                        System.out.println("Hubo un problema");
//                    }

//                    String dniNinjaEquipo;
//                    String codEquipoAsignar;
//                    Ninja ninjaSeleccionado;  Y despues lo siguente seria asignar al Ninja un grupo
//                    Equipo equipoSeleccionado;
//                    System.out.println("Ya  se creo el ninja, ahora vamos a asignarle a un Equipo");
//                    System.out.println("Inserte el DNI del ninja");
//                    dniNinjaEquipo = sc.nextLine().toUpperCase();
//                    System.out.println("Ahora inserte el codigo del equipo:");
//                    codEquipoAsignar = sc.nextLine().toUpperCase();
    }

    private static void equipo(Scanner sc, Aldea nuevaAldea) {
        Equipo nuevoEquipo;
        String nombreEquipo;
        String codigoEquipo;
        String sensei;

        System.out.println("Para crear un equipo inserte el nombre: ");
        nombreEquipo = sc.nextLine();
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
        sensei = sc.nextLine();

        nuevoEquipo = new Equipo(nombreEquipo,codigoEquipo,sensei);
        boolean reasultado = nuevaAldea.registrarEquipo(nuevoEquipo);
        if (reasultado) {
            System.out.println("Se agrego con Exito");
        }else{
            System.out.println("Error, vuelve a intentarlo");
            System.out.println("No se puede crear dos equipos con el mismo coido");
        }
    }

    private static Aldea aldea(Scanner sc) {
        String nombreAldea;
        Aldea nuevaAldea;
        String codigoAldea;
        String kage;
        System.out.println("Primero inserte el Nombre de la Aldea");
        nombreAldea = sc.nextLine();

        System.out.println("Ahora inserte el nombre del Kage ");
        System.out.print("Ejemplo: Tobirama Senju, Minato Namikaze \n");

        kage = sc.nextLine();
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

        nuevaAldea = new Aldea(nombreAldea, kage, codigoAldea);
        return nuevaAldea;
    }

    private static void menu() {
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
    }

    static boolean patronAldea(String cod) {
        String patron = "[A-Z]{5}[1-9]{5}";
        return Pattern.matches(patron,cod);
    }
    static boolean patronEquipo(String codEquipo) {
        String patron = "[A-Z]{2}[1-9]{7}";
        return Pattern.matches(patron,codEquipo);
    }
    static boolean PatronDNI(String DNI) {
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron, DNI);
    }
}