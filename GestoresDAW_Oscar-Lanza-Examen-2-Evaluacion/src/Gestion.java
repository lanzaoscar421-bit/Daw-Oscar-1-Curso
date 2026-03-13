import Excepciones.ValidacionDNI;
import Excepciones.ValidacionDirector;

import java.io.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Gestion{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Link Github https://github.com/lanzaoscar421-bit/Daw-Oscar-1-Curso/tree/main/GestoresDAW_Oscar-Lanza

        Empresa nuevaEmpresa = null;

        String opcion = "";

        System.out.println("Desea cargar los datos?");
        System.out.println("Pulsa S si lo desea, si no pulsa N");

        String cargarOpcion = sc.nextLine();

        if (cargarOpcion.equalsIgnoreCase("S")) {
            nuevaEmpresa = cargarCuenta();

        }else{
            nuevaEmpresa = getEmpresa(sc);
        }


        do {

            sc = new Scanner(System.in); // Reiniciar Scanner

            menu();

            opcion = sc.nextLine();

            switch (opcion) {

                case "1":

                    System.out.println("Ingresa:");
                    System.out.println("1. Para registrar Director");
                    System.out.println("2. Ingresar GerenteDep");
                    System.out.println("3. Ingresar Trabajador");

                    String registrarOpcion = sc.nextLine();
                    switch (registrarOpcion) {
                        case "1":

                            addDirector(sc, nuevaEmpresa);

                            break;
                        case "2":

                            addGerenteDep(sc, nuevaEmpresa);

                            break;
                        case "3":

                            addTrabajador(sc, nuevaEmpresa);

                            break;
                            default:
                                System.out.println("Inserte porfavor una opcion Valida");
                                break;
                    }
                    break;
                case "2":


                    estructura(nuevaEmpresa);


                    break;
                case "3":

                    System.out.println(nuevaEmpresa.numeroTrabajadoresEp());

                    break;
                case "4":

                    departamentos(sc, nuevaEmpresa);

                    break;
                case "5":

                    delTrabajador(sc, nuevaEmpresa);

                    break;
                case "6":

                    guardarEmpresa(nuevaEmpresa);

                    break;
                case "7":

                    guardarEmpresa(nuevaEmpresa);
                    System.out.println("Adios.");

                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!opcion.equals("7"));
    }

    private static void departamentos(Scanner sc, Empresa nuevaEmpresa) {
        System.out.println("Inserta el departamento que quieres mirar");
        for (Departamento d : Departamento.values()) {
            System.out.println("- " + d);
        }

        Departamento departamentoID = null;

        while (departamentoID == null){
            System.out.println("Escribe bien el nombre de su departamento");
            String entrada = sc.nextLine().toUpperCase();

            for (Departamento d : Departamento.values()){
                if (d.name().equalsIgnoreCase(entrada)){
                    departamentoID = d;
                    break;
                }
            }
            if (departamentoID == null){
                System.out.println("El departamento no existe");
            }
        }

        System.out.println(nuevaEmpresa.Departamentos(departamentoID));


        final String path2= ".\\src\\Resources\\";
        final String fileName2 = "departamentos.dat";


        try (FileWriter writer = new FileWriter(path2+fileName2);
             BufferedWriter bw = new BufferedWriter(writer)){

            bw.write(nuevaEmpresa.Departamentos(departamentoID));

        }catch (IOException e){
            System.err.println("Error al escribir el archivo");
        }
    }

    private static void addDirector(Scanner sc, Empresa nuevaEmpresa) {
        System.out.println("Ingresa el nombre del Director:");
        String nombreDirector = sc.nextLine();

        System.out.println("Ingresa la fecha de Nacimiento:");
        LocalDate fechaNacimientoTrabajadorDirector = null;

        System.out.println("Ejemplo de formato: 2007-12-06");

        while (fechaNacimientoTrabajadorDirector == null) {
            try {
                fechaNacimientoTrabajadorDirector = LocalDate.parse(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Por favor, inserte bien el formato (YYYY-MM-DD)");
            }
        }

        System.out.println("Ingresa el dni ");
        String dniDirector;
        do {
            System.out.println("Inserte SU DNI");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dniDirector = sc.nextLine().toUpperCase().toUpperCase();
        } while (!PatronDNI(dniDirector));

        System.out.println("Ingresa la direccion :");
        String direccionDirector = sc.nextLine();

        System.out.println("Ingresa el nombre numero de la SeguridadSocial:");
        String numeroLaSeguridadSocialDirector;

        do {
            System.out.println("Inserte SU numero de SSS");
            System.out.println("El SS consta de 10 números");
            System.out.println("Ejemplo: 1234567899");
            numeroLaSeguridadSocialDirector = sc.nextLine().toUpperCase();
        }while (!PatronSS(numeroLaSeguridadSocialDirector));


        System.out.println("Ingresa el Email:");
        String emailDirector = sc.nextLine();


        System.out.println("Ingrese el Salario del Director:");

        double salarioDirector= 0;
        try {
            salarioDirector = sc.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Por favor, inserte bien el Salario del Director)");
        }

        System.out.println("Ahora inserte su departamente");
        for (Departamento d : Departamento.values()) {
            System.out.println("- " + d);
        }

        Departamento departamentoDirector = null;

        while (departamentoDirector == null){
            System.out.println("Escribe bien el nombre de su departamento");
            String entrada = sc.nextLine().toUpperCase();

            for (Departamento d : Departamento.values()){
                if (d.name().equalsIgnoreCase(entrada)){
                    departamentoDirector = d;
                    break;
                }
            }
            if (departamentoDirector == null){
                System.out.println("El departamento no existe");
            }
        }


        String telefonoDirector = "";

        do {
            System.out.println("Inserte SU telefono con su formato correcto:");
            System.out.println("Ejemplo: 123456789");
            telefonoDirector = sc.nextLine();

        }while (!PatronNumero(telefonoDirector));

        System.out.println("Ingresa el modelo de coche:");
        String modeloCocheDirector = sc.nextLine();


        try {
            nuevaEmpresa.validarDni(dniDirector);
            Director nuevoDirector = new Director(nombreDirector,fechaNacimientoTrabajadorDirector,dniDirector, direccionDirector,numeroLaSeguridadSocialDirector,emailDirector,salarioDirector,departamentoDirector,telefonoDirector,modeloCocheDirector);
            nuevaEmpresa.addTrabajador(nuevoDirector);


        }catch (ValidacionDNI e){
            System.out.println(e.getMessage());
        }
    }

    private static void delTrabajador(Scanner sc, Empresa nuevaEmpresa) {
        Trabajador trabajadorSeleccionado;

        System.out.println("Ingresa el dni del trabajador que desea eliminar: ");
        String dniTrabajadorDel = sc.nextLine();

        trabajadorSeleccionado = nuevaEmpresa.buscarTrabajador(dniTrabajadorDel);
        nuevaEmpresa.removeTrabajador(trabajadorSeleccionado);
    }

    private static void estructura(Empresa nuevaEmpresa) {
        System.out.println(nuevaEmpresa.toString());

        final String path2= ".\\src\\Resources\\";
        final String fileName2 = "estrucutra.dat";


        try (FileWriter writer = new FileWriter(path2+fileName2);
        BufferedWriter bw = new BufferedWriter(writer)){

            bw.write(nuevaEmpresa.toString());

        }catch (IOException e){
            System.err.println("Error al escribir el archivo");
        }
    }

    private static void addGerenteDep(Scanner sc, Empresa nuevaEmpresa) {
        System.out.println("Ingresa el nombre:");
        String nombreGerenteDepo = sc.nextLine();

        System.out.println("Ingresa la fecha de Nacimiento:");
        LocalDate fechaNacimientoGerenteDep = null;

        System.out.println("Ejemplo de formato: 2007-12-06");

        while (fechaNacimientoGerenteDep== null) {
            try {
                fechaNacimientoGerenteDep = LocalDate.parse(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Por favor, inserte bien el formato (YYYY-MM-DD)");
            }
        }

        System.out.println("Ingresa el dni ");
        String dniGerenteDep;
        do {
            System.out.println("Inserte SU DNI");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dniGerenteDep = sc.nextLine().toUpperCase().toUpperCase();
        } while (!PatronDNI(dniGerenteDep));

        System.out.println("Ingresa la direccion :");
        String direccionGerenteDep = sc.nextLine();

        System.out.println("Ingresa el nombre numero de la SeguridadSocial:");
        String numeroLaSeguridadSocialGerenteDep = "";

        do {
            System.out.println("Inserte SU numero de SSS");
            System.out.println("El SS consta de 10 números");
            System.out.println("Ejemplo: 1234567899");
            numeroLaSeguridadSocialGerenteDep = sc.nextLine();
        }while (!PatronSS(numeroLaSeguridadSocialGerenteDep));


        System.out.println("Ingresa el Email:");
        String emailGerenteDep = sc.nextLine();


        System.out.println("Ingrese el Salario :");

        double salarioGerenteDep= 0;
        try {
            salarioGerenteDep = sc.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Por favor, inserte bien el Salario del Director)");
        }

        System.out.println("Ahora inserte su departamente");
        for (Departamento d : Departamento.values()) {
            System.out.println("- " + d);
        }

        Departamento departamentoGerenteDep = null;

        while (departamentoGerenteDep == null){
            System.out.println("Escribe bien el nombre de su departamento");
            String entrada = sc.nextLine().toUpperCase();

            for (Departamento d : Departamento.values()){
                if (d.name().equalsIgnoreCase(entrada)){
                    departamentoGerenteDep = d;
                    break;
                }
            }
            if (departamentoGerenteDep == null){
                System.out.println("El departamento no existe");
            }
        }

        System.out.println("Ingresa el numero de trabajadores en la direccion:");
        int numeroTrabajadoresDeP = 0;
        try {

            numeroTrabajadoresDeP = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }

        try {
            nuevaEmpresa.validarDni(dniGerenteDep);
            GerenteDep nuevoGerenteDep = new GerenteDep(nombreGerenteDepo,fechaNacimientoGerenteDep,dniGerenteDep,direccionGerenteDep,numeroLaSeguridadSocialGerenteDep,emailGerenteDep,salarioGerenteDep,departamentoGerenteDep,numeroTrabajadoresDeP);
            nuevaEmpresa.addTrabajador(nuevoGerenteDep);
        }catch (ValidacionDNI e){
            System.out.println(e.getMessage());
        }
    }

    private static void addTrabajador(Scanner sc, Empresa nuevaEmpresa) {
        System.out.println("Ingresa el nombre del trabajador:");
        String nombreTrabajador = sc.nextLine();

        System.out.println("Ingresa la fecha de Nacimiento:");
        LocalDate fechaNacimientoTrabajador = null;

        System.out.println("Ejemplo de formato: 2007-12-06");

        while (fechaNacimientoTrabajador == null) {
            try {
                fechaNacimientoTrabajador = LocalDate.parse(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Por favor, inserte bien el formato (YYYY-MM-DD)");
            }
        }

        System.out.println("Ingresa el dni ");
        String dniTrabajador;
        do {
            System.out.println("Inserte SU DNI");
            System.out.println("El DNI consta de 8 números + 1 letra ");
            System.out.println("Ejemplo: 12345678Z");
            dniTrabajador = sc.nextLine().toUpperCase().toUpperCase();
        } while (!PatronDNI(dniTrabajador));

        System.out.println("Ingresa la direccion del trabajador:");
        String direccionTrabajador = sc.nextLine();

        System.out.println("Ingresa el nombre numero de la SeguridadSocial:");
        String numeroLaSeguridadSocial;

        do {
            System.out.println("Inserte SU numero de SSS");
            System.out.println("El SS consta de 10 números");
            System.out.println("Ejemplo: 1234567899");
            numeroLaSeguridadSocial = sc.nextLine().toUpperCase();
        }while (!PatronSS(numeroLaSeguridadSocial));


        System.out.println("Ingresa el Email:");
        String emailTrabajador = sc.nextLine();


        System.out.println("Ingrese el Salario del trabajador:");

        double salarioTrabajador = 0;
        try {
             salarioTrabajador = sc.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Por favor, inserte bien el Salario del trabajador)");
        }


        System.out.println("Ahora inserte su departamente");
        for (Departamento d : Departamento.values()) {
            System.out.println("- " + d);
        }

        Departamento departamento = null;

        while (departamento == null){
            System.out.println("Escribe bien el nombre de su departamento");
            String entrada = sc.nextLine().toUpperCase();

            for (Departamento d : Departamento.values()){
                if (d.name().equalsIgnoreCase(entrada)){
                    departamento = d;
                    break;
                }
            }
            if (departamento == null){
                System.out.println("El departamento no existe");
            }
        }

        try {
            nuevaEmpresa.validarDni(dniTrabajador);

            Trabajador nuevoTrabajador = new Trabajador(nombreTrabajador,fechaNacimientoTrabajador,dniTrabajador,direccionTrabajador,numeroLaSeguridadSocial,emailTrabajador,salarioTrabajador,departamento);
            nuevaEmpresa.addTrabajador(nuevoTrabajador);
        }catch (ValidacionDNI e) {
            System.err.println(e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("1. Para registrar trabajador");
        System.out.println("2. Informacion general empresa");
        System.out.println("3. Numero de trabajadores");
        System.out.println("4. Mostar informacion Departamento");
        System.out.println("5. Eliminar trabajador de la empresa. ");
        System.out.println("6. Guardar toda la información de la empresa. ");
        System.out.println("7. Salir de la Aplicacion ");
    }

    private static Empresa getEmpresa(Scanner sc) {
        Empresa nuevaEmpresa;
        System.out.println("Ingrese el nombre de la Empresa");
        String nombreEmpresa = sc.nextLine();

        String cif;

        do {
            System.out.println("Primero inserte el CIF del VideoClub:");
            System.out.println("Te recuerdo que el CIF valido para la empresa (Ejemplo: A12345678)\" \n");
            cif = sc.nextLine();
        }while (!PatronCIF(cif));

        LocalDate fechaFundacion = null;

        System.out.println("Inserte la fecha de fundacion");
        System.out.println("Ejemplo de formato: 2007-12-06");

        while (fechaFundacion == null) {
            try {
                fechaFundacion = LocalDate.parse(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Por favor, inserte bien el formato (YYYY-MM-DD)");
            }
        }


        nuevaEmpresa = new Empresa(nombreEmpresa,cif,fechaFundacion);

        System.out.println(nuevaEmpresa);
        return nuevaEmpresa;
    }

    private static void guardarEmpresa(Empresa nuevaEmpresa) {
        final String pathGestioDaw = "./src/Resources/";
        final String fileNameGestioDaw = "Empresa.dat";
        boolean fileModeGestioDaw = false;


        try (FileOutputStream file = new FileOutputStream(pathGestioDaw+fileNameGestioDaw,fileModeGestioDaw);
             ObjectOutputStream buffer = new ObjectOutputStream(file)){

            buffer.writeObject(nuevaEmpresa);
            System.out.println("Empresa guardado correctamente");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static Empresa cargarCuenta() {
        final String pathGestioDaw = "./src/Resources/";
        final String fileNameGestioDaw = "Empresa.dat";

        try (FileInputStream file = new FileInputStream(pathGestioDaw + fileNameGestioDaw);
             ObjectInputStream reader = new ObjectInputStream(file)) {

            Object obj = reader.readObject();
            if (obj instanceof Empresa) {
                Empresa empresa = (Empresa) obj;
                System.out.println("Datos cargados correctamente de la aldea: ");
                return empresa;
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo para cargar los datos.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ha habido un problema al cargar: " + e.getMessage());
        }

        return null;
    }


    static boolean PatronCIF(String CIF) {
        String patron = "^[A-HJUV][0-9]{7}[A-Z0-9]$";
        return Pattern.matches(patron,CIF);
    }
    static boolean PatronDNI(String DNI) {
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron, DNI);
    }
    static boolean PatronSS(String SS) {
        String Patron = "[0-9]{10}";
        return Pattern.matches(Patron, SS);
    }
    static boolean PatronNumero(String numero) {
        String patron = "[0-9]{9}";
        return Pattern.matches(patron,numero);
    }

}
